package com.zp.designpatern.structure.bridge;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public abstract class Bridge {
    private Sourceable source;

    public void method(){
        source.method();
    }

    public Sourceable getSource() {
        return source;
    }

    public void setSource(Sourceable source) {
        this.source = source;
    }
}
