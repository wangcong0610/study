package com.zp.designpatern.create.Singleton.test;

/**
 * Created by Zhang Peng on 2016/7/25.
 */
public class SingletonTest {

    private static SingletonTest instance = null;

    private SingletonTest() {
        System.out.println("come in SingletonTest");
    }

    private static class SingletonFactory {
        private static SingletonTest instance = new SingletonTest();
    }

    public static SingletonTest getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String [] arg0) {
        SingletonTest singletonTest1 = SingletonTest.getInstance();
        SingletonTest singletonTest2 = SingletonTest.getInstance();
        SingletonTest singletonTest3 = SingletonTest.getInstance();
        SingletonTest singletonTest4 = SingletonTest.getInstance();
        SingletonTest singletonTest5 = SingletonTest.getInstance();
        SingletonTest singletonTest6 = SingletonTest.getInstance();
    }
}
