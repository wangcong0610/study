package com.zp.designpatern.create.Singleton;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class SafeSingleton {
    private static SafeSingleton instance = null;

    private SafeSingleton() {
    }

    private static synchronized void syncInit() {
        if (instance == null) {
            instance = new SafeSingleton();
        }
    }

    /**
     * 相对比较安全，synchronized锁的是方法时，若放在getInstance前面，则每次调用的时候都会加锁，这样显然影响效率
     * 若是将创建单独提出来，并加锁，由于只创建一次，所以对性能的影响也就小了很多
     * 还有一种方法是使用内部类，JVM内部机制能保证当一个类被加载时，这个类的加载过程是线程互斥的。
     * 即：
     * private static class SingletonFactory{
     *     private static Singleton instance = new Singleton();
     * }
     * public static Singleton getInstance(){
     *     return SingletonFactory.instance;
     * }
     * @return
     */
    public static SafeSingleton getInstance() {
        if (instance == null) {
            syncInit();
        }
        return instance;
    }
}
