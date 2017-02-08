package com.zp.designpatern.behavior.strategy;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
