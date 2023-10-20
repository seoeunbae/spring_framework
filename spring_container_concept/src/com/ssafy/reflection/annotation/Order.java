package com.ssafy.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * ElementType: 해당 애노테이션을 사용할 수 있는 위치
 * 
 * RetentionPolicy
 * - SOURCE: 애노테이션을 주석처럼 사용하는 것. 컴파일러가 컴파일할때 해당 애노테이션을 메모리에서 제거 
 * - CLASS: 컴파일러가 컴파일할 때 해당 애노테이션을 메모리에서 사용하지만 런타임시에는 메모리에서 제거
 *         리플렉션으로 선언된 어노테이션 데이터를 가져올 수 없게 됩니다. (기본값)
 * - RUNTIME: 애노테이션을 런타임시에도 사용가능
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Order {
	int number() default 0; //number라는 변수를 사용한다.
	
	
	
}
