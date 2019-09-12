package com.wyett.BaguaChat;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/10 15:35
 * @description: TODO
 */

public class HttpRequestHandler
extends SimpleChannelInboundHandler<FullHttpRequest>{
    private final String wsUri;
    private static final File INDEX;

    static {
        URL localtion = HttpRequestHandler.class
                .getProtectionDomain()
                .getCodeSource().getLocation();
        try {
            String path = localtion.toURI() + "index.html";
            path = !path.contains("file:") ? path : path.substring(5);
            INDEX = new File(path);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Unable to locate index.index", e);
        }
    }

    public HttpRequestHandler(String wsUri) {
        this.wsUri = wsUri;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             FullHttpRequest request) throws Exception {
        // if request.uri has /ws, request.retain() and transfer it to
        // next ChannelInboundHandler
        if (wsUri.equalsIgnoreCase(request.getUri())) {
            ctx.fireChannelRead(request.retain());
        } else {
            // check if 100 continue request
            if (HttpHeaders.is100ContinueExpected(request)) {
                send100Continue(ctx);
            }

            // read from INDEX
            RandomAccessFile file = new RandomAccessFile(INDEX, "r");

            // init new httpRespnose
            HttpResponse response = new DefaultHttpResponse(
                    request.getProtocolVersion(), HttpResponseStatus.OK);
            // set ResponseHeader
            response.headers().set(
                    HttpHeaders.Names.CONTENT_TYPE,
                    "text/plain; charset = UTF-8");

            // check if connection is alive
            boolean keepAlive = HttpHeaders.isKeepAlive(request);
            if (keepAlive) {
                // add http header info
                response.headers().set(
                        HttpHeaders.Names.CONTENT_LENGTH, file.length());
                response.headers().set(HttpHeaders.Names.CONNECTION,
                        HttpHeaders.Values.KEEP_ALIVE);
            }
            // write HttpResponse to client
            ctx.write(response);

            // if pipeline has SslHandler, write it to client with ChunkedNioFile
            // or, write it with defaultFileRegine
            if(ctx.pipeline().get(SslHandler.class) == null) {
                ctx.write(new DefaultFileRegion(
                        file.getChannel(), 0, file.length()));
            } else {
                ctx.write(new ChunkedNioFile(file.getChannel()));
            }

            // write LastHttpContent and flush it to client
            ChannelFuture future = ctx.writeAndFlush(
                    LastHttpContent.EMPTY_LAST_CONTENT);

            // if not keepAlive, add listener to future to close channel after writing
            // over
            if (!keepAlive) {
                future.addListener(ChannelFutureListener.CLOSE);
            }
        }
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(
            HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
        ctx.writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    throws Exception{
        cause.printStackTrace();
        ctx.close();
    }
}
