package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.FoodTypes;
import com.aishu.util.ConnectionUtil;

public class FoodTypesDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(FoodTypes foodtypes) {

		String sql = "insert into FOOD_TYPES(ID,TYPE_NAME,FROM_TIME,TO_TIME) values(?,?,?,?)";
		Object[] params = { foodtypes.getId(), foodtypes.getType_name(), foodtypes.getFrom_time(),
				foodtypes.getTo_time() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	/**
	 * update method
	 * 
	 * @param foodtypes
	 */
	public void update(FoodTypes foodtypes) {

		String sql = "update FOOD_TYPES set TYPE_NAME=? where ID=?";
		Object[] params = { foodtypes.getType_name(), foodtypes.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void delete(FoodTypes foodtypes) {
		String sql = "delete from FOOD_TYPES where ID=?";
		Object[] params = { foodtypes.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
	}

	public List<FoodTypes> list() {

		String sql = "select * from FOOD_TYPES";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			FoodTypes foodtypes = new FoodTypes();
			foodtypes.setId(rs.getInt("ID"));
			foodtypes.setType_name(rs.getString("TYPE_NAME"));
			foodtypes.setFrom_time(rs.getTime("FROM_TIME").toLocalTime());
			foodtypes.setTo_time(rs.getTime("TO_TIME").toLocalTime());
			return foodtypes;

		});
	}

	public List<String> list1() {

		String sql = "select TYPE_NAME from FOOD_TYPES";
		return jdbcTemplate.queryForList(sql, String.class);

	}

	public FoodTypes list2(int ID) {

		String sql = "select ID,TYPE_NAME,FROM_TIME,TO_TIME from FOOD_TYPES where ID=?";
		Object[] params = { ID };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			FoodTypes foodtypes = new FoodTypes();
			foodtypes.setId(rs.getInt("ID"));
			foodtypes.setType_name(rs.getString("TYPE_NAME"));
			foodtypes.setFrom_time(rs.getTime("FROM_TIME").toLocalTime());
			foodtypes.setTo_time(rs.getTime("TO_TIME").toLocalTime());
			return foodtypes;

		});
	}

}