package com.zp.study.annotation.core.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: Zhang Peng
 * Date: 2017/2/7 0007
 * Description: 注解测试，验证注解需要使用反射机制进行解析
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        System.out.println(dog.name);
    }
}
@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@interface Abc{
    String name();
}
class Dog{
    @Abc(name="hh")
    String name;
}
