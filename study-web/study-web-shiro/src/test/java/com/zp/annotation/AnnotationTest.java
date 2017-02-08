package com.zp.annotation;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Author: Zhang Peng
 * Date: 2016/12/26 0026
 * Description:
 */
public class AnnotationTest extends AbstractTestNGSpringContextTests {
    @Test
    public void appleTest(){
        Apple apple = new Apple();
        apple.displayName();
    }
}
