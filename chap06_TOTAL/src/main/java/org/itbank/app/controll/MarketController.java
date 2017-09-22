package org.itbank.app.controll;

import java.util.Map;

import org.itbank.app.model.MarketDaoMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/market")
public class MarketController {

	@Autowired
	MarketDaoMyBatis market;
	
	@GetMapping("/show/{num}")
	public ModelAndView showHandle(@PathVariable String num) {
		ModelAndView mav = new ModelAndView("market/show");
		mav.addObject("one", market.getOne(num));
		return mav;
	} 
	
	@GetMapping("/all")
	public ModelAndView allHandle() {
		ModelAndView mav = new ModelAndView("t_expr");
		mav.addObject("section","market/all");
		mav.addObject("data", market.getAll());
		return mav;
	}
	
	@GetMapping("/search")
	public ModelAndView allHandle(@RequestParam Map param) {
		System.out.println(param);
		ModelAndView mav = new ModelAndView("market/all");
		mav.addObject("data", market.searchSome(param));
		return mav;
	}
	
	@GetMapping("/add")
	public String addGetHandle(Map map) {
			map.put("section","market/add");
		return "t_expr";
	}
	@PostMapping("/add")
		public String addPostHandle(@RequestParam Map param, Map model) {
		try {
			int r = market.addOne(param);
			model.put("rst", r);
		}catch (Exception e) {
			model.put("rst", -1);
		}
		
		return "market/add";
	}
}
	

