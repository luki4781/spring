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
		System.out.println(template);
		System.out.println(map);
		return template.selectOne("join.checkByIdmailAndPass", map);
	}


	// id�� email�� �Ӱ�,
	public HashMap readOneByIdOrEmail(String idmail) {
		return template.selectOne("join.readOneByIdOrEmail", idmail);
	}

	// id�� email�� �Ӱ�, pass�� ���� �����Ͱ� �ִ��� Ȯ���Ҷ�
	public HashMap readOneById(String id) {
		return template.selectOne("join.readOneById", id);
	}
	
	public int resisterProfile(Map map) {
		return template.insert("profile.resisterProfile", map);
	}
	
	public Map resisteredId(String id) {
		System.out.println(id);
		return template.selectOne("profile.resisteredId", id);
	}
	
	public List<Map> resisteredAll(String id) {
		return template.selectList("profile.resisteredAll", id);
	}
	
	public List<Map> memberListWith(){
		return template.selectList("join.memberListWith");
	}
	
	public List<Map> memberList() {
		return template.selectList("join.memberList");
	}
	
	public List<Map> memberListFive(Map map) {
		return template.selectList("join.memberListFive", map);
	}
	
	public Integer memberListCount() {
		return template.selectOne("join.memberListCount");
	}
}

