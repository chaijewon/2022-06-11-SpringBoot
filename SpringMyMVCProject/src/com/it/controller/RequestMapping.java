package com.it.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {
    public String value(); // 문자열을 이용해서 메소드를 찾아주는 역할 
    // => if문 대신 사용 => 어노테이션 
}
