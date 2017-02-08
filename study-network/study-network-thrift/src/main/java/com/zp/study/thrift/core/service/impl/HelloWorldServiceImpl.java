package com.zp.study.thrift.core.service.impl;

import com.zp.study.thrift.core.service.HelloWorldService;
import org.apache.thrift.TException;

/**
 * Author: Zhang Peng
 * Date: 2017/1/23 0023
 * Description:
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome!";
    }
}
