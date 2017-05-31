package com.zp.excel.test;

import java.util.Random;

/**
 * Author:Zhang Peng
 * Date:2017/4/20 0020
 * Description:Test
 */
public class Test {
    private static int data = 0;
    private static Random random = new Random();
    private static String sync = "";

    public static void main(String[] args) {
        synchronized(sync){
            System.out.println("aaa");
            System.out.println("bbb");
            System.out.println("ccc");
            sync = "sync";
            test();
        }
    }

    public static void test(){
        synchronized (sync){
            sync = "";
            System.out.println("ddd");
        }
    }
}
