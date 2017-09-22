package org.itbank.app.controll;

import java.util.UUID;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.router.RecipientListRouter.Recipient;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	JavaMailSender sender;
	
	@RequestMapping("/basic")
	public String basicHandel() {
		return "test/basic";
	}
	
	@RequestMapping("/uuid")
	public void uuidHandle() {
		UUID u = UUID.randomUUID();	//고유 식별자가 필요하게 될때 사용되는 클래스
		//정해진 규칙에 의해 거의 완벽하게 중복되지 않는 고유 키를 생성해서 사용할 수 있음
		//32개의 16진수
		System.out.println(Math.pow(16, 32));
		System.out.println(u.toString());
		String auth_str = u.toString().substring(24,36);
		System.out.println(auth_str);
	}
	
	@RequestMapping("/send01")
	public void send01Handel(@RequestParam(name="t") String t) {
		// 1. SimpleMailMessage 객체 이용
		SimpleMailMessage msg = new SimpleMailMessage();
		// 발신자, 수신자, 내용
		try {
		msg.setTo(t); //받을사람 주소
		msg.setFrom("luki4781@naver.com"); //보내는 사람 주소
					// stmp.gmail 이쪽 우회해서 전송될 때, 보내는 사람 주소가, gamil 주소로 자동 변환, 
		msg.setSubject("환영메일");
		String text = "환영합니다.\n 항상 최선의 서비스를 제공하겠습니다.";
		text += "<h2>text</h2>";	// TEXT 만 전송 가능
		msg.setText(text);
		sender.send(msg); // 발송
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/send02")
	public void send02Handle(@RequestParam(name="t") String t) {
		//MimeMessage
		try {
			MimeMessage msg = sender.createMimeMessage();
			//TO
			msg.setRecipient(RecipientType.TO, new InternetAddress(t));
			//SUBJECT
			msg.setSubject("WELCOME");
			//TEXT
			String text = "<h1>환영합니다</h1>";
			text += "가입을 환영합니다";
			text += "<a href=\"http://192.168.10.88\"> 사이트 이동</a>";
			
			msg.setText(text, "UTF-8","html");
			//FROM
			
			
			sender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
