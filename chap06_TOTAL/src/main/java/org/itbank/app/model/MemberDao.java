package org.itbank.app.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	SqlSessionTemplate template;
	
	public boolean addOne(Map map) {
		template.insert("join.addOne",map);
		template.insert("join.addDetail", map);
		return true;
	}
	
	// id나 email이 머고, pass가 머인 데이터가 있는지 확인할때
	public int existOne(Map map) {
		return template.selectOne("join.checkByIdmailAndPass", map);
	}

	// id나 email이 머고, pass가 머인 데이터가 있는지 확인할때
	public HashMap readOne(Map map) {
		return template.selectOne("join.readOne", map);
	}
}

