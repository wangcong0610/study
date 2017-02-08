package com.zp.designpatern.behavior.iterator;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public interface Iterator {
    //前移
    public Object previous();

    //后移
    public Object next();

    public boolean hasNext();

    //取得第一个元素
    public Object first();
}
