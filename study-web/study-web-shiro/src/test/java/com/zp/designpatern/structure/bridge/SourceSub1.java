package com.zp.designpatern.structure.bridge;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class SourceSub1 implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the first sub!");
    }
}
