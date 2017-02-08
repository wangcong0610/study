package com.zp.designpatern.behavior.state;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class State {
    private String value;

    public void method1(){
        System.out.println("execute the first opt!");
    }

    public void method2(){
        System.out.println("execute the second opt!");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
