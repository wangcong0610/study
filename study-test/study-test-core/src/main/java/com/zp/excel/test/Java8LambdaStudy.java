package com.zp.excel.test;

import java.util.stream.Stream;

/**
 * Created by Zhang Peng on 2017/3/24 0024.
 */
public class Java8LambdaStudy {
    public static void main(String[] args) {
        String []datas = new String[] {"peng","Zhao","li"};
//        String str = "test";
//        Stream.of(str).map(String::new).peek(System.out::println).findFirst();
        String []copyDatas = Stream.of(datas).toArray(String[]::new);
        Stream.of(copyDatas).forEach(x -> System.out.println(x));
    }
}
