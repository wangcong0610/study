package com.pengzhangg.study.thread;

/**
 * Author: pengz.
 * Date: 2017/1/2 0002.
 * Description:
 */
public class TraditionalThreadSync {


    class OutPutter {
        public void outPutter(String str) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}
