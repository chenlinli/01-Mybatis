package com.cl.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.cl.mybatis.pojo.User;
import com.cl.mybatis.utils.SqlSessionFactoryUtil;

public class MybatisTest {

	@Test
	public void testGetUserbyId() throws IOException{
		//创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
		//核心配置文件的输入流
		InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//通过输入流创建工厂SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = ssfb.build(stream);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//查询，使用select的id,传入参数
		User user = sqlSession.selectOne("getUserById", 1);
		System.out.println(user);
		//释放资源
		sqlSession.close();
		
	}
	
	@Test
	public void testGetUserByUsername(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
//		List<User> list = sqlSession.selectList("user.getUserByUsername","张%");
		//使用了${}：字符串拼接指令
		List<User> list = sqlSession.selectList("user.getUserByUsername","张");
		for (User object : list) {
			System.out.println(object);
		}
		sqlSession.close();
	}
	
	@Test
	public void testInsertUser(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建sqlSession
		//设置true：自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		List<User> list = sqlSession.selectList("user.getUserByUsername","张%");
		//使用了${}：字符串拼接指令
		User user = new User();
		user.setUsername("李素2");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("深圳");
		//插入,返回数据库影响的行数
		sqlSession.insert("insertUser", user);
		System.out.println(user);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void testInsertUserUuid(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建sqlSession
		//设置true：自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		List<User> list = sqlSession.selectList("user.getUserByUsername","张%");
		//使用了${}：字符串拼接指令
		User user = new User();
		user.setUsername("李素2");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("深圳");
		//插入,返回数据库影响的行数
		sqlSession.insert("insertUserUuid", user);
		System.out.println(user);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testUpdateUser(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建sqlSession
		//设置true：自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
//		List<User> list = sqlSession.selectList("user.getUserByUsername","张%");
		//使用了${}：字符串拼接指令
		User user = new User();
		user.setUsername("李思");
		user.setId(30);
		//插入,返回数据库影响的行数
		sqlSession.update("user.updateUser", user);
		System.out.println(user);
		//提交事务
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDeleteUser(){
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		//创建sqlSession
		//设置true：自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		sqlSession.delete("user.deleteUser",31);
		sqlSession.commit();
		sqlSession.close();
	}
}
