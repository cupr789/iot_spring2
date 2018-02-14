package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionInfoService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionInfoController {
	
	private static final Logger log = LoggerFactory.getLogger(UrlController.class);
	
	@Autowired
	ConnectionInfoService cs;
	
	@RequestMapping("/list")
	public @ResponseBody Map<String, Object> getConnectionList(HttpSession hs, Map<String, Object> map){
		UserInfoVO ui = new UserInfoVO();
		if(hs.getAttribute("user")!=null) {			
			ui= (UserInfoVO)hs.getAttribute("user");
			//log.info("session?? =>{}",hs.getAttribute("user"));
		}else {
			ui.setUiId("red");
		}
		ConnectionInfoVO ci = new ConnectionInfoVO();
		ci.setUiId(ui.getUiId());
		cs.getConnectionInfo(map,ci);
	/*	List<ConnectionInfoVO> conlist = cs.getConnectionInfo(ci);
		map.put("list", conlist);*/
		
		return map;
	}
	
	   @RequestMapping(value="/db_list/{ciNo}", method=RequestMethod.GET)
	   public @ResponseBody Map<String,Object> getDatabaseList(@PathVariable("ciNo") int ciNo, Map<String,Object> map, HttpSession hs) {
	      List<Map<String, Object>> dbList;
	      try {
	         dbList = cs.getDatabaseList(hs, ciNo);
	         map.put("list", dbList);
	         map.put("parentId", ciNo);
	      }catch(Exception e){
	         map.put("error", e.getMessage());
	         log.error("db connection error => {}",e);
	      }
	      return map;
	   }
	
	
	
}
