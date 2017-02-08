package com.zp;

/**
 * Author: Zhang Peng
 * Date: 2016/12/19 0019
 * Description:
 */
public class MainTest {
    public volatile static int count = 0;

    public volatile int cont1 = 0;

    public static void inc() {
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count++;
    }

    public void inc1() {
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        cont1++;
    }


    public static void main(String[] args) {
        //同时启动1000个线程，去进行i++计算，看看实际结果
        final MainTest test = new MainTest();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    MainTest.inc();
                    test.inc1();
                }
            }).start();
        }
//        List<MainTest> list1 = new ArrayList<MainTest>();
//        List<FruitColor> list2 = new ArrayList<FruitColor>();
//        for (FruitColor fruitColor : list2) {
//
//        }
        //这里每次运行的值都有可能不同,可能不为1000
        System.out.println("运行结果:MainTest.count=" + MainTest.count);
        System.out.println("运行结果:MainTest.cont1=" + test.cont1);
    }
}
