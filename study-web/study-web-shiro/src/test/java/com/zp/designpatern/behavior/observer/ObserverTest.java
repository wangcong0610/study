package com.zp.designpatern.behavior.observer;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());

        sub.operation();
    }
}
