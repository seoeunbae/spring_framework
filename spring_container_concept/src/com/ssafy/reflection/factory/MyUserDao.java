package com.ssafy.reflection.factory;

import java.util.HashMap;

public class MyUserDao implements UserDao{
	HashMap<Integer, User> map = new HashMap<>();
	
	public void insert(User user) {
		map.put(user.getId(),user);
	}
	
	public User select(int id) {
		return map.get(id);
	}
	
}
