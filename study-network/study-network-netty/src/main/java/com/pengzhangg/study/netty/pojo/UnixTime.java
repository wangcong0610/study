package com.pengzhangg.study.netty.pojo;

import java.util.Date;

/**
 * Author:zp
 * Date:2017/8/23 0023
 * Description:UnixTime
 */
public class UnixTime {

    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
}
