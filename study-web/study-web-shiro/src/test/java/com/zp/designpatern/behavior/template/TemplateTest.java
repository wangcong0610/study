package com.zp.designpatern.behavior.template;

/**
 * Created by Zhang Peng on 2016/8/1.
 */
public class TemplateTest {
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp, "\\+");
        System.out.println(result);
    }
}
