package com.zp.designpatern.behavior.memento;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class Original {
    private String value;

    public Original(String value) {
        this.value = value;
    }

    public Memento createMemento(){
        return new Memento(value);
    }

    public void restoreMemento(Memento memento){
        this.value = memento.getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
