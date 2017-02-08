package com.zp.designpatern.structure.adapter.implementAdapter;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class WrapperTest {
    public static void main(String[] arg0){
        Sourceable sourceSub1 = new SourceSub1();
        Sourceable sourceSub2 = new SourceSub2();

        sourceSub1.method1();
        sourceSub1.method2();
        sourceSub2.method1();
        sourceSub2.method2();
    }
}
