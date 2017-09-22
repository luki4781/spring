package org.itbank.app.controll;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.itbank.app.controll.ws.AlertWSHandler;
import org.itbank.app.model.MemberDao;

@Controller
public class JoinController {
	@Autowired
	JavaMailSender sender;
	
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
			//session.setAttribute("auth", "on");
			session.setAttribute("auth", map);
			session.setAttribute("auth_id", map.get("id"));
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
	
	@PostMapping("/join/auth")
	@ResponseBody
	public String uuidMailHandle(@RequestBody String target, HttpSession session) {
		System.out.println("target : " + target);
		String key = UUID.randomUUID().toString().substring(24,36);
		session.setAttribute("authkey",key);
		
		try {
			MimeMessage msg = sender.createMimeMessage();
			//TO
			msg.setRecipient(RecipientType.TO, new InternetAddress(target));
			//SUBJECT
			msg.setSubject("EMAIL 인증번호요청");
			//TEXT
			String text = "<h1>환영합니다</h1>";
			text += "가입을 환영합니다";
			text += "인증메세지는"+key+"입니다";
			
			msg.setText(text, "UTF-8","html");
			//FROM
			sender.send(msg);
			return "true";
		}catch(Exception e) {
			return "false";
		}
	
	}
	
	@RequestMapping("/join/authCheck")
	@ResponseBody
	public String joinAuthCheckHandle(@RequestParam String key, HttpSession session) {
		System.out.println(key);
		System.out.println(session.getAttribute("authKey"));
		System.out.println(key.equals(session.getAttribute("authkey")));
		if(key.equals(session.getAttribute("authKey")) ) {
			return "YYYYY";
		}else {
			return "NNNNN";
		}
	}
	
	@PostMapping("/signup_check/{mode}")
	public String signupHandle() {
		return "";
	}
}
