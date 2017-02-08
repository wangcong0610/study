package com.zp.designpatern.behavior.responsibility;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public abstract class AbstractHandler {
    private Handler handler;

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
