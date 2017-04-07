package com.zp.study.spring.util.core;

import com.zp.study.spring.util.core.po.UserFromPo;
import com.zp.study.spring.util.core.po.UserPo;
import org.springframework.beans.BeanUtils;

/**
 * Author:Zhang Peng
 * Date:2017/4/6 0006
 * Description:BeanUtils.copyProperties方法学习,
 * Result:个人不是很喜欢使用BeanUtils.copyProperties方法，该方法使用的是Java的反射机制，是要比直接get and set 耗时的
 */
public class BeanUtilsCopyProperties {
    public static void main(String[] args) {
        UserFromPo userFromPo = new UserFromPo(1, "name", "address", "sex", "a", "b", "c", "d", "e");
        UserPo userPo1 = new UserPo();

        long startCopy = System.currentTimeMillis();
        BeanUtils.copyProperties(userFromPo, userPo1);
        System.out.println(System.currentTimeMillis() - startCopy);

        UserPo userPo2  = new UserPo();

        long startSet = System.currentTimeMillis();
        userPo2.setAge(userFromPo.getAge());
        userPo2.setName(userFromPo.getName());
        userPo2.setAddress(userFromPo.getAddress());
        userPo2.setSex(userFromPo.getSex());
        userPo2.setA(userFromPo.getA());
        userPo2.setB(userFromPo.getB());
        userPo2.setC(userFromPo.getC());
        userPo2.setD(userFromPo.getD());
        userPo2.setE(userFromPo.getE());
        System.out.println(System.currentTimeMillis() - startSet);

    }
}
