package com.iot.spring.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserInfoDAO;
import com.iot.spring.service.UserInfoService;
import com.iot.spring.vo.UserInfoVO;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired 
	private UserInfoDAO uidao;
	
	
	@Override
	public boolean login(Map<String, Object> map, UserInfoVO ui) {
		ui=uidao.selectUserInfo(ui);
		map.put("msg","아이디 비밀번호를 확인해주세요.");
		map.put("biz", false);
		
		if(ui!=null) {
			map.put("msg",ui.getUiName()+"님 로그인에 성공하셨습니다.");
			map.put("biz", true);
			map.put("user", ui);
			return true;
		}
		return false;
	}
	
	
	public int checkUserId(String uiId) {
		
		
		return 0;
		
	}
	


	@Override
	public int join(UserInfoVO ui) {
		String pwd = ui.getUiPwd();
		ui.setUiPwd(null);
		if(uidao.selectUserInfo(ui)!=null) {
			return 2;
		}
		ui.setUiPwd(pwd);
		return uidao.insertUserInfo(ui);
	}

}
