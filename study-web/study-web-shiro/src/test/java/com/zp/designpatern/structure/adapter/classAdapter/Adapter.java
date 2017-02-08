package com.zp.designpatern.structure.adapter.classAdapter;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
