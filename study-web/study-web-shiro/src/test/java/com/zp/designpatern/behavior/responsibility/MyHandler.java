package com.zp.designpatern.behavior.responsibility;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class MyHandler extends AbstractHandler implements Handler {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println(name + " deal!");
        if(getHandler() != null){
            getHandler().operator();
        }
    }
}
