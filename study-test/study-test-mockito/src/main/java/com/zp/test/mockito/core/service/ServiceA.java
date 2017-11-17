package com.zp.test.mockito.core.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author:zp
 * Date:2017/11/17 0017
 * Description:
 */
public class ServiceA {

    @Autowired
    private ServiceB serviceB;

    public String test(){
        return serviceB.test();
    }

    public String testB(){
        return serviceB.mockB();
    }

}
