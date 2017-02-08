package com.zp.study.annotation.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author: Zhang Peng
 * Date: 2017/1/20 0020
 * Description:
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface ReqParam {
    String value() default "";
}
