package com.ssafy.reflection.annotation;

public class ClassA {
	
	@Order(number = 2)
	public void second() {
		System.out.println("second call!");
	}
	@Order(number = 1)
	public void first() {
		System.out.println("first call!");
	}
	@Order(number = 3)
	public void third() {
		System.out.println("third call!");
	}
	
}
