package org.itbank.app.controll;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.itbank.app.model.BoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardDao boardDao;

	// View�� �ѱ涧 �����͸� �����ؾߵȴٸ�,
	// 1. �Ű������� (Map, Model, ModelMap)�� �޾Ƽ� �ű⿡ �����ϰ�, ���̸��� ��ȯ.
	// 2. ModelAndView ��ü�� ��ȯ
	@RequestMapping("/list")
	public ModelAndView boardListHandle() throws SQLException {
		List<Map> li = boardDao.readAll();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("t_expr");
		mav.addObject("section", "board/list");
		mav.addObject("list", li);
		mav.addObject("cnt", li.size());
		return mav;
	}

	// @GetMapping("/add")
	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String boardAddGetHandle() {
		return "board/add";
	}

	// @PostMapping("/add");
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String boardAddPostHandle(@RequestParam Map param, ModelMap map) throws SQLException {
		boolean b = boardDao.addOne(param);
		if (b) {
			return "redirect:/board/list";
		}
		map.put("result", b);
		return "board/add_rst";
	}

	@RequestMapping(path = "/view/{num}")
	public ModelAndView boardAddPostHandle(@PathVariable String num) throws SQLException {
		ModelAndView mav = new ModelAndView("board/view"); // �ٷ� ���̸�����
		Map one = boardDao.readOne(num);
		mav.addObject("one", one);
		return mav;
	}
}
