package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionInfoDAO;
import com.iot.spring.service.ConnectionInfoService;
import com.iot.spring.vo.ConnectionInfoVO;

@Service
public class ConnectionInfoServiceImpl implements ConnectionInfoService {

	@Autowired
	ConnectionInfoDAO conDao;
	
	@Override
	public List<ConnectionInfoVO> getConnectionInfo(Map<String, Object> map,ConnectionInfoVO ci) {
		List<ConnectionInfoVO> conList = conDao.selectConnectionInfo(ci);
		if(conList!=null) {
			map.put("list", conList);
		}
		return conDao.selectConnectionInfo(ci);
	}

	@Override
	public List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception {
		   ConnectionInfoVO ci = conDao.selectConnection(ciNo);
		      DBConnector dbc = new DBConnector(ci);
		      SqlSession ss = dbc.getSqlSession();
		      hs.setAttribute("sqlSession", ss);
		      List<Map<String,Object>> dbList = conDao.selectDatabaseList(ss);
		      int idx = 0;
		      for(Map<String,Object> mDb : dbList) {
		         mDb.put("id", ciNo + "_" + (++idx));
		         mDb.put("text", mDb.get("Database"));
		         mDb.put("items", new Object[] {});
		      }
		      return dbList;
	}

}
