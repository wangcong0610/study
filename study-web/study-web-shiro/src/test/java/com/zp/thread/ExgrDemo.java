package com.zp.thread;

import java.util.concurrent.Exchanger;

/**
 * Author: Zhang Peng
 * Date: 2016/12/23 0023
 * Description:资源交换
 */
public class ExgrDemo {
    public static void main(String args[]) {

        //交换器
        Exchanger<String> exgr = new Exchanger<String>();

        new TeamB(exgr);
        new TeamA(exgr);
    }
}

/**
 * 项目组A
 *
 * @author liuyan
 */
class TeamA implements Runnable {
    Exchanger<String> ex;

    String str;

    TeamA(Exchanger<String> c) {
        ex = c;
        str = new String();

        new Thread(this).start();
    }

    public void run() {
        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                str += (char) ch++;

            try {
                str = ex.exchange(str);
                System.out.println("TeamA Got: " + str);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}

/**
 * 项目组B
 *
 * @author liuyan
 */
class TeamB implements Runnable {
    Exchanger<String> ex;

    String str;

    TeamB(Exchanger<String> c) {
        ex = c;
        new Thread(this).start();
    }

    public void run() {

        char ch = 'A';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++)
                str += (char) ch++;
            try {
                str = ex.exchange(str);
                System.out.println("TeamB Got: " + str);
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
        }
    }
}
