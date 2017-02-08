package com.zp.designpatern.behavior.command;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class CommandTest {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new MyCommand(receiver);
        Invoker invoker = new Invoker(command);
        invoker.acton();
    }
}
