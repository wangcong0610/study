package com.zp.designpatern.behavior.command;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void acton(){
        command.exe();
    }
}
