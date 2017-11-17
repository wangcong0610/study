package com.zp.test.mockito.core.service;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author:zp
 * Date:2017/11/17 0017
 * Description:
 */
public class ServiceB {

    @Autowired
    private ServiceC serviceC;

    public String test(){
        return serviceC.test();
    }

    public String mockB(){
        return null;
    }

}
