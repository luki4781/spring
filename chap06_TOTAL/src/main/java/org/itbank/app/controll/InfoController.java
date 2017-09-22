package org.itbank.app.controll;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class InfoController {
	@Autowired
	MemberDao memberDao;
	@Autowired
	ObjectMapper mapper;
	

	@RequestMapping("/info/park")
	public ModelAndView parkListHandle(@RequestParam(defaultValue="1") String gu ) {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section", "info/park");
		RestTemplate rt = new RestTemplate();
		String str = rt.getForObject(
				"http://openapi.seoul.go.kr:8088/6f66654142746530383254796c4859/json/GetParkInfo/1/100", String.class);
		try {
			Map obj = mapper.readValue(str, Map.class);
			Map info = (Map)obj.get("GetParkInfo");
			mav.addObject("data", info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/info/mlist")
	public ModelAndView mlistHandle(@RequestParam(name = "page", defaultValue = "1") int page ) {
		ModelAndView mav = new ModelAndView("t_expr");
		int tot = memberDao.memberListCount();
		int size = tot / 5 + (tot % 5 != 0 ? 1 : 0);
		mav.addObject("size", size);
		mav.addObject("tot", tot);
		mav.addObject("section", "info/memberlist");
		if(page>size)
			page=size;
		if(page<0)
			page=1;
		
		Map p = new HashMap();
		p.put("start", (page-1)*5 +1 );	
		p.put("end", page*5);

		mav.addObject("mlist", memberDao.memberListFive(p));
		return mav;
	}
}
