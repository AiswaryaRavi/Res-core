package com.Aiswarya.dao;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Aiswarya.util.ConnectionUtil;

public class FunctionexistsDao {
	
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public int itemCheck(String itemName) 
	{
		String sql = "select ITEM_EXISTS(?)";
		Object[] params = { itemName };
		int itemID = jdbcTemplate.queryForObject(sql, params, int.class);
		return itemID;
	}

}
