package org.itbank.app.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/basic")
	public String basicHandel() {
		return "test/basic";
	}
}
