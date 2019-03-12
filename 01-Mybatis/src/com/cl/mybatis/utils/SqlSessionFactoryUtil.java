package com.cl.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	private static SqlSessionFactory sqlSessionFactory;
	static{
		
		InputStream stream;
		try {//创建SqlSessionFactoryBuilder
			SqlSessionFactoryBuilder ssfb= new SqlSessionFactoryBuilder();
			//核心配置文件的输入流
			stream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//通过输入流创建工厂SqlSessionFactory
			sqlSessionFactory = ssfb.build(stream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
