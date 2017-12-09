package com.legend.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legend.dao.LegendDao;
import com.legend.dto.Member;

@RestController
@RequestMapping("/api")
public class WebController {
	private Logger logger = Logger.getLogger(WebController.class);
	
	private int focus = 1;
	private String action ="";
	private boolean userControl = true;
	private long controlSeq = 41489L;
	
	@Autowired
	private LegendDao dao;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest req){
		List<Member> list = dao.getMemberList();
		
		for( Member m : list){
			System.out.println("id : " + m.getId());
		}
		return "OK";
	}
	
	@RequestMapping("/ptInfo")
	public String getPtInfo(HttpServletRequest req) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("focus", focus);
		map.put("action", action);
		map.put("controlSeq", controlSeq);
		map.put("userControl", userControl);
		String collBack = req.getParameter("collBack");
		if(StringUtils.isEmpty(collBack))
			return new JSONObject(map).toString();
		else 
			return collBack+"(" + new JSONObject(map).toString() + ")"; 
	}
	
	@RequestMapping("/set/focus/{focus}")
	public String setFocus(HttpServletRequest req, @PathVariable String focus) {
		try {
			int f = Integer.parseInt(focus);
			this.focus = f;
			controlSeq++;
		}catch (Exception e) {
			return "No. Only Number";
		}
		return "OK";
	}
	
	@RequestMapping("/set/action/{action}")
	public String setAction(HttpServletRequest req, @PathVariable String action) {
		this.action = action;
		controlSeq++;
		return "OK";
	}
	@RequestMapping("/set/userControl/{userControl}")
	public String setUserControl(HttpServletRequest req, @PathVariable String userControl) {
		if("false".equals(userControl))
			this.userControl = false;
		else
			this.userControl = true;
		controlSeq++;
		return "OK";
	}
	
	
}
