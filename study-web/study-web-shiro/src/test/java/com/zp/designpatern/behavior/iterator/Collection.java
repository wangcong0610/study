package com.zp.designpatern.behavior.iterator;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public interface Collection {
    public Iterator iterator();

    public Object get(int index);

    public int size();
}
