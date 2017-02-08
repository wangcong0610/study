package com.zp.designpatern.behavior.observer;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public interface Subject {
    /**
     * 添加观察者
     */
    public void add(Observer observer);

    /**
     * 删除观察者
     */
    public void del(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyobservers();

    /**
     * 自身的操作
     */
    public void operation();
}
