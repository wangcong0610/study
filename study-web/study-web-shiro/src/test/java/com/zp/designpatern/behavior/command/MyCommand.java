package com.zp.designpatern.behavior.command;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {
        receiver.action();
    }
}
