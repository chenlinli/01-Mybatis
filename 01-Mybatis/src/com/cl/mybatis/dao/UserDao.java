package com.cl.mybatis.dao;

import java.util.List;

import com.cl.mybatis.pojo.User;

public interface UserDao {
	
	/**
	 * 根据id找用户
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 根据用户名找user
	 * @param username
	 * @return
	 */

	List<User> getUserByUsername(String username);
	/**
	 * 插入用户
	 * @param user
	 */
	void inserUser(User user);
	
}
