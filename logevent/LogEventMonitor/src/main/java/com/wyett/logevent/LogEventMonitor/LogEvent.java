package com.wyett.logevent.LogEventMonitor;

import lombok.NonNull;

import java.net.InetSocketAddress;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/11 17:14
 * @description: TODO
 */

public final class LogEvent {
    public static final byte SEPARATOR = (byte) ':';
    private final InetSocketAddress source;
    @NonNull private final String logfile;
    @NonNull private final String msg;
    private final long received;

    public LogEvent(String logfile, String msg) {
        this(null, -1, logfile, msg);
    }

    public LogEvent(InetSocketAddress source, long received,
                    String logfile, String msg) {
        this.source = source;
        this.logfile = logfile;
        this.msg = msg;
        this.received = received;
    }

    public InetSocketAddress getSource() {
        return source;
    }

    public String getLogfile() {
        return logfile;
    }

    public String getMsg() {
        return msg;
    }

    public long getReceived() {
        return received;
    }
}
