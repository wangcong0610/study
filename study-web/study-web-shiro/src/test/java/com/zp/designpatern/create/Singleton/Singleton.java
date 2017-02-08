package com.zp.designpatern.create.Singleton;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    /**
     * 并不完全安全，比如如下情况：
     * 1.A、B两个线程同事进入了第一个if判断
     * 2.A首先进入synchronize块，由于instance为null，所以它执行instance = new Singleton();
     * 3.由于JVM内部的优化机制，JVM先画出一些分配给Singleton实力的空白内存，并赋值给instance成员（测试JVM并没有开始初始化这个实例），然后A离开了synchronized块
     * 4.B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序
     * 5.这样，线程B拿到的Singleton实例就是个没有被实例化的
     * @return
     */
    public static Singleton getInstance(){
        if (instance == null) {
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve(){
        return instance;
    }
}
