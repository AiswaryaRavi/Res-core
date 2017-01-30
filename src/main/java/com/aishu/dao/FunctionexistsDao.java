package com.aishu.dao;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.util.ConnectionUtil;

public class FunctionexistsDao {
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int itemCheck(String itemName) 
	{
		String sql = "select ITEM_EXISTS(?)";
		Object[] params = { itemName };
		return jdbcTemplate.queryForObject(sql, params, int.class);
	
	}

}
