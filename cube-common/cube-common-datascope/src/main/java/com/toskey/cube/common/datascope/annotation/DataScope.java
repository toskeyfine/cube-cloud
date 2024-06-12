package com.toskey.cube.common.datascope.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DataScope
 *
 * @author lis
 * @version 1.0
 * @description TODO
 * @date 2024/6/7 10:57
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {

    boolean enabled() default true;

}
