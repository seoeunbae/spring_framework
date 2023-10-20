package com.ssafy.reflection.factory;

public class UserService {
	private UserDao dao = DaoFactory.getBean("my"); //parameter에 따라 찾아서 의존관계를 설정해주는방식 : dependency lookup + 주입까지해줘서 dependency Injection 이다.
	
	public void add(User user) {
		dao.insert(user);
	}
	
	public User get(int id) {
		return dao.select(id);
	}
}

//인터페이스를 사용해도 메소드명이랑 파라메터의 변화가 발생하면 또 문제가 생긴다.!->이를 위해 팩토리 개념 도입