package com.zp.test.core.code.service.impl;

import com.zp.test.core.code.service.MyNeedTestService;

/**
 * Author:zp
 * Date:2017/11/29 0029
 * Description:
 */
public class MyNeedTestServiceImpl implements MyNeedTestService {

    public static void main(String[] args) {
        System.out.println(Math.random() * 1000 % 10);
    }

    @Override
    public String myMethod(String name, int a) {
        String result = null;
        if((a % 2) == 0){
            result = "Hello, " + name;
        }else {
            result = "Unknown Error," + name;
        }
        // int b =  a/0;
        return result;
    }

}
