package com.cl.mybatis.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cl.mybatis.mapper.UserMapper;
import com.cl.mybatis.pojo.User;
import com.cl.mybatis.utils.SqlSessionFactoryUtil;

public class UserMapperTest {

	@Test
	public void testGetUserById() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();
		//创建接口的代理实现类
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.getUserById(30);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testGetUserByUsername() {
		fail("Not yet implemented");
	}

	@Test
	public void testInserUser() {
		fail("Not yet implemented");
	}

}
