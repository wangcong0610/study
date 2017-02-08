package com.zp.designpatern.structure.bridge;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}
