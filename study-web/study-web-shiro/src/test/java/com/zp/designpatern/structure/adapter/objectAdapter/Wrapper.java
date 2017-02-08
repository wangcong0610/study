package com.zp.designpatern.structure.adapter.objectAdapter;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is targetable method!");
    }
}
