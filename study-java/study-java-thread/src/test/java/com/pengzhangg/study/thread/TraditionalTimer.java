package com.pengzhangg.study.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: pengz.
 * Date: 2016/12/26 0026.
 * Description:
 */
public class TraditionalTimer {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer Execute");
            }
        }, 10 * 1000l);
    }
}
