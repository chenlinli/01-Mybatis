package com.cl.mybatis.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.cl.mybatis.dao.UserDao;
import com.cl.mybatis.dao.impl.UserDaoImpl;
import com.cl.mybatis.pojo.User;

public class UserDaoTest {

	@Test
	public void testGetUserById() {
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.getUserById(29));
	}

	@Test
	public void testGetUserByUsername() {
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.getUserByUsername("张");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testInserUser() {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		user.setUsername("王六");
		user.setSex("0");
		user.setBirthday(new Date());
		user.setAddress("深圳");
		userDao.inserUser(user);
		
	}

}
