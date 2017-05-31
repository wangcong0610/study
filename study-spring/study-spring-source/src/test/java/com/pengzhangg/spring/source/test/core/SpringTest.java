package com.pengzhangg.spring.source.test.core;


import com.pengzhangg.spring.source.core.TestService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Author:Zhang Peng
 * Date:2017/5/22 0022
 * Description:Spring Test
 */
public class SpringTest {

    private static final Logger logger = Logger.getLogger(SpringTest.class);

    @Test
    public void springStartTest() {
        // ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
        // DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        // XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        // xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);

        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // context.start();
        // TestService testService = (TestService) context.getBean("testService");
        // testService.sayHello("zp");

        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        context.start();
        context.getBean("testService");
        context.stop();
    }

}
