package com.wyett.mynet.concurrencysocket.datamodel;

import java.io.Serializable;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/23 19:21
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class TalkModel implements Serializable {
    private String talkStr;
    public TalkModel(String talkStr) {
        this.talkStr = talkStr;
    }
    public String toString() {
        return talkStr;
    }
    public String getTalkStr() {
        return this.talkStr;
    }
    public void setTalkStr(String talkStr) {
        this.talkStr = talkStr;
    }
}
