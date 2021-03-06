package com.zp.designpatern.behavior.memento;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class Memento {
    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
