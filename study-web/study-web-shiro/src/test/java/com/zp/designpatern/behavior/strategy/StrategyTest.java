package com.zp.designpatern.behavior.strategy;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class StrategyTest {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator iCalculator = new Plus();
        System.out.println(iCalculator.calculate(exp));
    }
}
