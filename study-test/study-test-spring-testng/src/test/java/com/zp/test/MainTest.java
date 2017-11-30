package com.zp.test;

import com.zp.test.core.code.service.MyNeedTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Author:zp
 * Date:2017/11/29 0029
 * Description:
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class MainTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MyNeedTestService myNeedTestService;

    @Test
    public void test() {
        String result = myNeedTestService.myMethod("zp", 1);
        System.out.println(result);
    }

}
