package com.iot.spring.common.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.ClassPathResource;

import com.iot.spring.vo.ConnectionInfoVO;

public class DBConnector {
	private BasicDataSource bds;
	private SqlSessionFactoryBean ssf;
	
	
	public DBConnector(ConnectionInfoVO cvo) {
		bds = new BasicDataSource();
		bds.setDriverClassName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mysql://"+cvo.getCiUrl() +":"+cvo.getCiPort();
		bds.setUrl(url);
		bds.setUsername(cvo.getCiUser());
		bds.setPassword(cvo.getCiPwd());
		ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(bds);
		ssf.setConfigLocation(new ClassPathResource("/mybatis-conf.xml"));
	}
	
	
	public SqlSession getSqlSession() throws Exception {
		return ssf.getObject().openSession();
	}
	

/*	public static void main(String[] args) {
		ConnectionInfoVO cvo = new ConnectionInfoVO();
		cvo.setCiUrl("localhost");
		cvo.setCiPort(3306);
		cvo.setCiUser("root");
		cvo.setCiPwd("soos789");
		DBConnector dbc = new DBConnector(cvo);
		SqlSession ss = dbc.getSqlSession();
		ss.getConnection();
		if(ss.getConnection()!=null) {
			System.out.println("연결성공");
		}
	}*/
	
	
}
