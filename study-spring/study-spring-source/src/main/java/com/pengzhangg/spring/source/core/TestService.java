package com.pengzhangg.spring.source.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:Zhang Peng
 * Date:2017/5/22 0022
 * Description:测试Service
 */
public class TestService {

    private List<String> myList = new ArrayList<>();

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void sayHello(String name){
        System.out.println(name + ", Hello !");
    }

}
