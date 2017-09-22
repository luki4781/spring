package org.itbank.app.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDao {
	@Autowired
	SqlSessionTemplate sql;

	
	public int addNew(Map map) {
		return sql.insert("memo.addNew", map);
	}
}
