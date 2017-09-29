package org.itbank.app.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jquery")
public class JQueryController {
	@RequestMapping("/01")
	public ModelAndView jquury01() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/01");
		return mav;
	}
	
	@RequestMapping("/02")
	public ModelAndView jquury02() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/02");
		return mav;
	}
	
	@RequestMapping("/03")
	public ModelAndView jquury03() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/03");
		return mav;
	}
	
	@RequestMapping("/04")
	public ModelAndView jquury04() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/04");
		return mav;
	}
	
	
	@RequestMapping("/05")
	public ModelAndView jquury05() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/05");
		return mav;
	}
	
	@RequestMapping("/06")
	public ModelAndView jquury06() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/06");
		return mav;
	}
	
	@RequestMapping("/qz01")
	public ModelAndView jquuryQz01() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/qz01");
		return mav;
	}
	
	@RequestMapping("/qz02")
	public ModelAndView jquuryQz02() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/qz02");
		return mav;
	}
	
	@RequestMapping("/qz03")
	public ModelAndView jquuryQz03() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","jquery/qz03");
		return mav;
	}
}
