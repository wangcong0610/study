package com.zp.test.core;

import com.zp.test.mockito.core.service.ServiceA;
import com.zp.test.mockito.core.service.ServiceB;
import com.zp.test.mockito.core.service.ServiceC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Author:zp
 * Date:2017/11/17 0017
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/test.xml"})
public class MockitoTest extends AbstractTestNGSpringContextTests {

    /**
     * @InjectMocks 全部替换
     */
    @InjectMocks
    @Autowired
    private ServiceA serviceA;
    /**
     * @Spy + @Autowired 指定mock的方法将会被替换
     */
    @Spy
    @InjectMocks
    @Autowired
    private ServiceB serviceB;
    @Mock
    private ServiceC serviceC;

    @Test
    public void testC() {
        System.out.println("out: " + serviceC.test());
    }

    @Test
    public void testA() {
        String str1 = serviceA.test();
        String str2 = serviceA.testB();
        System.out.println("out: " + str1);
        System.out.println("out: " + str2);
    }

    @Before
    public void beforeTest() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(serviceB.mockB()).thenReturn("123 !");
        Mockito.when(serviceC.test()).thenReturn("hello !");
    }
}
