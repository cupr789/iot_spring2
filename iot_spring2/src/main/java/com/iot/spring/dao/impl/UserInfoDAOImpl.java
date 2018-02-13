package com.iot.spring.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.vo.UserInfoVO;

@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

	@Autowired
	SqlSessionFactory ssf;
	
	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		ui=ss.selectOne("user_info.selectUserInfo",ui);
		ss.close();
		return ui;
	}

}
