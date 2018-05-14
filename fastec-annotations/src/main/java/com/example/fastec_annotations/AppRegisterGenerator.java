package com.example.fastec_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * - @Author:  闫世豪
 * - @Time:  2018/5/11 下午3:00
 * - @Email whynightcode@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AppRegisterGenerator {
    String packageName();
    Class<?> registerTemplate();
}
