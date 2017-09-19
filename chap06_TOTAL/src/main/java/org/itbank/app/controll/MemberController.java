package org.itbank.app.controll;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itbank.app.model.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/my")
public class MemberController {
	@Autowired
	MemberDao memberDao;
	@Autowired
	ServletContext application;
	@Autowired
	SimpleDateFormat sdf;

	@GetMapping("/profile")
	public ModelAndView profileHandle(HttpSession session) {
		ModelAndView mav = new ModelAndView("t_expr");
		String id = (String) session.getAttribute("auth_id");
		System.out.println("[/my/profile ] id = "  +id);
		Map prof = memberDao.resisteredId(id);
		mav.addObject("prof", prof);

		mav.addObject("section", "my/profile");
		return mav;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/profile")
	public ModelAndView profilePostHandle(@RequestParam(name="profile") MultipartFile f, 
																			HttpSession session) 
					throws InterruptedException {
		String id = (String)session.getAttribute("auth_id");
		boolean rst = false;
		String fmt = sdf.format(System.currentTimeMillis());
		String fileName = id+"_"+fmt;
		try {
			if(f.isEmpty())
				throw new Exception();
			File dst = new File(application.getRealPath("/profiles"), fileName);
			f.transferTo(dst);
			rst = !rst;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rst) {
			Map data = new HashMap<>();
			data.put("id", id);
			data.put("url", "/profiles/"+fileName);
			memberDao.resisterProfile(data);
		}
		
		ModelAndView mav = new ModelAndView("redirect:/my/profile");
		mav.addObject("rst", rst);
		return mav;
	}

	@GetMapping("/info")
	public String infoHandle(Model model, HttpSession session) {
		String id = (String)((Map)session.getAttribute("auth")).get("ID");
		
		
		model.addAttribute("section", "my/info");
		return "t_expr";
	}

	@PostMapping("/info")
	public String infoPostHandle() {
		return "t_expr";
	}

}
