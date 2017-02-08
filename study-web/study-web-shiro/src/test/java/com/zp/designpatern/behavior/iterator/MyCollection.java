package com.zp.designpatern.behavior.iterator;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class MyCollection implements Collection{

    public String [] strs = {"A","B","C","D","E"};

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object get(int index) {
        return strs[index];
    }

    @Override
    public int size() {
        return strs.length;
    }
}
