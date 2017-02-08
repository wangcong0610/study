package com.zp.designpatern.create.Builder;

/**
 * Created by Zhang Peng on 2016/7/26.
 */
public class BuilderTest {
    public static void main(String [] arg0){
        MyContact myContact = new MyContact.Builder("zp").age(20).safeID(1).address("shanghai").build();
        System.out.println(myContact.getName());
        System.out.println(myContact.getAddress());
        System.out.println(myContact.getAge());
        System.out.println(myContact.getSafeID());
    }
}
