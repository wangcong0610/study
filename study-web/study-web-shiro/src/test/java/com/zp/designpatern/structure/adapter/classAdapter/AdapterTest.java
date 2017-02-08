package com.zp.designpatern.structure.adapter.classAdapter;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class AdapterTest {
    public static void main(String [] arg0){
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }
}
