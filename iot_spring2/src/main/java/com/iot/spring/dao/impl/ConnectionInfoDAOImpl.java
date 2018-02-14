package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionInfoDAO;
import com.iot.spring.vo.ConnectionInfoVO;

@Repository
public class ConnectionInfoDAOImpl implements ConnectionInfoDAO {

	@Autowired
	SqlSessionFactory ssf;
	
	@Override
	public List<ConnectionInfoVO> selectConnectionInfo(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		List<ConnectionInfoVO> ciList = ss.selectList("con.selectConnectionInfo",ci);
		ss.close();
		return ciList;
	}

	@Override
	public ConnectionInfoVO selectConnection(int ciNo) {
		SqlSession ss= ssf.openSession();
		ConnectionInfoVO ci = ss.selectOne("con.selectConnectionInfoWithCiNo", ciNo);
		ss.close();
		return ci;
		
	}

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		return ss.selectList("con.selectDatabase");
	}

}
