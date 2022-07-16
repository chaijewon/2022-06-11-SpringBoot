package com.sist.test;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD) // 메소드만 찾기가 가능 
public @interface RequestMapping {
   public String value();
   // @RequestMapping("")
}
