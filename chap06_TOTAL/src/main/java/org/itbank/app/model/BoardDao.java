package org.itbank.app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BoardDao {
	@Autowired
	DataSource ds;
	
	@Autowired
	SqlSessionTemplate template;

	public List<Map> readAll() throws SQLException {
		List<Map> list = new ArrayList<Map>();
		Connection conn = ds.getConnection();
		String sql = "select * from board order by num desc";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Map m = new HashMap<>();
			m.put("num", rs.getInt("num"));
			m.put("writer", rs.getString("writer"));
			m.put("title", rs.getString("title"));
			m.put("content", rs.getString("content"));
			m.put("count", rs.getInt("count"));
			m.put("writedate", rs.getDate("writedate"));
			list.add(m);
		}
		conn.close();
		return list;
	}

	public boolean addOne(Map map) throws SQLException {
		boolean rst = false;
		Connection conn = ds.getConnection();
		String sql = "insert into board values(board_seq.nextval,?, ?, ?,0,sysdate)";
		// prepare 시키고, ? 세팅하고, executeUpdate 시키고,
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, map.get("writer"));
		ps.setObject(2, map.get("title"));
		ps.setObject(3, map.get("content"));
		// 그 결과 따라서 boolean 값 바꿔주면 됨.
		int r = ps.executeUpdate();
		if (r == 1)
			rst = true;
		conn.close();
		return rst;
	}

	public Map readOne(String num) throws SQLException {
		Map map = null;
		Connection conn = ds.getConnection();
		String sql = "select * from board where num=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setObject(1, num);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			map = new HashMap<>();
			map.put("num", rs.getInt("num"));
			map.put("writer", rs.getString("writer"));
			map.put("title", rs.getString("title"));
			map.put("content", rs.getString("content"));
			map.put("count", rs.getInt("count"));
			map.put("writedate", rs.getDate("writedate"));
		}
		conn.close();
		return map;
	}
}
