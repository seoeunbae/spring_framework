package com.ssafy.reflection.factory;

public class TestDrive {
	public static void main(String[] args) {
		
		UserService service = new UserService();
		
		User user = new User(1,27,"Kim");
		service.add(user);
		
		User selected = service.get(1);
		System.out.println(selected);
	}
}
