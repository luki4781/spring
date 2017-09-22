package org.itbank.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MarketDaoMyBatis {
	@Autowired
	SqlSessionTemplate template;
	
	public int addOne(Map map) {
		int r = template.insert("market.addOne",map);
		return r;
	}
	
	public List<Map> getAll() {
		return template.selectList("market.getAll");
	}
	
	public List<Map> searchSome(Map p) {
		return template.selectList("market.searchBySprice", p);
	}

	public HashMap getOne(String num) {
		HashMap r = template.selectOne("market.getOne", num);
		return r;
	}
}
