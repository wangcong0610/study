package com.zp.study.annotation.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author: Zhang Peng
 * Date: 2017/1/20 0020
 * Description:
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface ReqType {
    /**
     * 请求方式枚举
     *
     */
    enum ReqTypeEnum{ GET,POST,DELETE,PUT};

    /**
     * 请求方式
     * @return
     */
    ReqTypeEnum reqType() default ReqTypeEnum.POST;
}
