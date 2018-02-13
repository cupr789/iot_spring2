package com.iot.spring.service;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserInfoService {
	public boolean login(Map<String,Object> map,UserInfoVO ui);
}
