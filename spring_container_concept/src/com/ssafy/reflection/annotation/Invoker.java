package com.ssafy.reflection.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * 자바의 리플렉션(Reflection)
 * Reflection은 자바에서 기본적으로 제공하는 API로써
 * 클래스, 인터페이스, 메서드들을 찾을 수 있고, 객체를 생성하거나 변수를 변경할 수 있고
 * 메서드를 호출할 수도 있습니다.
 * 
 * Reflection은 다음과 같은 정보를 가져올 수 있습니다.
 * 이 정보를 가져와서 객체를 생성하거나 메서드를 호출하거나 변수의 값을 변경할 수 있습니다.
 * Class, Constructor, Method, Field
 * 
 */
public class Invoker {
	
	public void invoke(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = obj.getClass();
		Method[] methods = clazz.getDeclaredMethods();//clazz의 메소드들을 배열형태로 담는다.
		Method[] orders = new Method[methods.length];
		for(Method m : methods) { //메소드를 어노테이션 있는지 하나씩 확인
			if(m.isAnnotationPresent(Order.class)) {
				Order annotation = m.getAnnotation(Order.class); //어노테이션 정보를 가져온다.
				orders[annotation.number() - 1] = m;
			}
		}
		
		for(Method m : orders) {
			m.invoke(obj, null); //invoke(obj, argument...) : 실제 호출하는 메소드
		}
	}
	
}
