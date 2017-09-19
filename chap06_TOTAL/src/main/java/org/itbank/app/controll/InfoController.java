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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	@Autowired
	MemberDao memberDao;

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
