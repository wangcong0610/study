package com.zp.designpatern.behavior.iterator;

/**
 * Created by Zhang Peng on 2016/8/2.
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
