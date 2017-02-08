package com.zp.designpatern.structure.facade;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class User {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
