package org.itbank.app.controll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/member")
public class SearchController {
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(path="/search")
	@ResponseBody
	public ModelAndView searchIdHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section", "member/search");
		return mav;
	}
	
	@RequestMapping("/searchAjax")
	@ResponseBody
	public List<Map> searchIdAjaxHandle(@RequestParam String id) {
		return memberDao.readId(id+"%");
	}
	
	@RequestMapping("/searchAjaxx")
	public ModelAndView searchIdAjaxxHandle(@RequestParam String id) {
		ModelAndView mav = new ModelAndView("member/searchresult");
		mav.addObject("data", memberDao.readId(id+"%"));
		
		return mav;
	}
}