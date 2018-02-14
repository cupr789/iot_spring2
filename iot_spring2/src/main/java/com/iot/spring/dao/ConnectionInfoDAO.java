package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionInfoDAO {
	List<ConnectionInfoVO> selectConnectionInfo(ConnectionInfoVO ci);
	public ConnectionInfoVO selectConnection(int ciNo);
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception ;
}
