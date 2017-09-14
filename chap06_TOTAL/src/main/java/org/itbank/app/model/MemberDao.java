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
	
	// id�� email�� �Ӱ�, pass�� ���� �����Ͱ� �ִ��� Ȯ���Ҷ�
	public int existOne(Map map) {
		return template.selectOne("join.checkByIdmailAndPass", map);
	}

	// id�� email�� �Ӱ�, pass�� ���� �����Ͱ� �ִ��� Ȯ���Ҷ�
	public HashMap readOne(Map map) {
		return template.selectOne("join.readOne", map);
	}
}

