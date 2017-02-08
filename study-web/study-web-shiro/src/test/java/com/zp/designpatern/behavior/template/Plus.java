package com.zp.designpatern.behavior.template;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Plus extends AbstractCalculator {
    @Override
    protected int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
