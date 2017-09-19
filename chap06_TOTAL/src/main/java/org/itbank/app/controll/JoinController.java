package org.itbank.app.controll;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.itbank.app.controll.ws.AlertWSHandler;
import org.itbank.app.model.MemberDao;

@Controller
public class JoinController {
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	AlertWSHandler aws;	// 웹소켓 핸들러를 AutoWired 걸어서 연결 잡고.
	
	@Autowired
	MemberDao memberDao;

	@GetMapping(path = "/join")
	public String joinGetHandle(Model model) {
		model.addAttribute("section","join");
		return "t_expr";
	}

	@PostMapping("/join")
	public String joinPostHandle(@RequestParam Map map, HttpSession session, Model model) {
		
		try {
			boolean b = memberDao.addOne(map);
			session.setAttribute("auth", "on");
			/*
			 * AlertWSHandler 를 통해서, 메세지를 보내보자
			 */
			aws.sendMessage("누군가 가입하였습니다");
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("temp", map);
			model.addAttribute("section","join");
			return "t_expr";
		}
	}

	@PostMapping("/signup_check/{mode}")
	public String signupHandle() {
		return "";
	}
}
