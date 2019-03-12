package com.cl.mybatis.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cl.mybatis.dao.UserDao;
import com.cl.mybatis.pojo.User;
import com.cl.mybatis.utils.SqlSessionFactoryUtil;

public class UserDaoImpl implements UserDao{

	public User getUserById(Integer id) {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("user.getUserById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserByUsername(String username) {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> user = sqlSession.selectList("user.getUserByUsername", username);
		sqlSession.close();
		return user;
	}

	@Override
	public void inserUser(User user) {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.insert("user.insertUser", user);
		sqlSession.close();
	}

}
