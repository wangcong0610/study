package com.zp.designpatern.behavior.memento;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class Storage {
    private Memento memento;

    public Storage(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
