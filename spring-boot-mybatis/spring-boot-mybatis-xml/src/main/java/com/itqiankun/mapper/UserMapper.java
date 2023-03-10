package com.itqiankun.mapper;

import java.util.List;

import com.itqiankun.model.User;

public interface UserMapper {
	
	List<User> getAll();
	
	User getOne(Long id);

	void insert(User user);

	void update(User user);

	void delete(Long id);

}