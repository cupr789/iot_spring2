package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionInfoService {
	List<ConnectionInfoVO> getConnectionInfo(Map<String, Object> map,ConnectionInfoVO ci);
	public List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception;
}
