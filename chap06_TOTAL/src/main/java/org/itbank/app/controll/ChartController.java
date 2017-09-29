package org.itbank.app.controll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/chart")
public class ChartController {
	@Autowired
	MemberDao  memberDao;
	@Autowired
	ObjectMapper mapper;
	
	@RequestMapping("/01")
	public ModelAndView chart01Handle() {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list =  memberDao.countByGender();
		System.out.println(list);
		mav.addObject("section", "chart/01");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/02")
	public ModelAndView chart02Handle() throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list =  memberDao.countByGender();
		mav.addObject("section", "chart/02");
		// 2���� �迭������ JSON ���ڿ��� �����صδ� .. JSON array = java ' ArrayList ,  
		List json = new ArrayList();
		for(Map m : list) {
			Object[] ar = new Object[] {m.get("GENDER"), m.get("CNT")};
			json.add(ar);
		}
		String str = mapper.writeValueAsString(json);
		mav.addObject("json", str);
		return mav;
	}
	
	@RequestMapping("/03")
	public ModelAndView chart03Handle() throws JsonProcessingException {
		ModelAndView mav = new ModelAndView("t_expr");
		List<Map> list =  memberDao.countByGender();
		mav.addObject("section", "chart/03");
		// 2���� �迭������ JSON ���ڿ��� �����صδ� .. JSON array = java ' ArrayList ,  
		
		return mav;
	}
	
	@RequestMapping(path="/piedata",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String chart03AjaxHandle() throws JsonProcessingException {
		List<Map> list =  memberDao.countByGender();
		List json = new ArrayList();
		for(Map m : list) {
			Object[] ar = new Object[] {m.get("GENDER"), m.get("CNT")};
			json.add(ar);
		}
		json.add(new Object[] {"��", 1 });
		String str = mapper.writeValueAsString(json);
		return str;
	}
	
	@RequestMapping("/04")
	public ModelAndView chartBarHandle() {
		List<Map> list = memberDao.countByScore();
		List all = Arrays.asList("1��","2��","3��","4��","5��");
		for(Map m : list) {
			String s = (String)m.get("SCORE");
			all.remove(s);
		}
		return null;
	}
	
}