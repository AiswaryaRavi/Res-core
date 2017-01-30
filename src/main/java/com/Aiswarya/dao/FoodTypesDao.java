package com.Aiswarya.dao;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Aiswarya.model.FoodTypes;
import com.Aiswarya.util.ConnectionUtil;


public class FoodTypesDao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public void save(FoodTypes foodtypes) {

		String sql = "insert into FOOD_TYPES(ID,TYPE_NAME,FROM_TIME,TO_TIME) values(?,?,?,?)";
		Object[] params = { foodtypes.getId(), foodtypes.getTypeName(),foodtypes.getFromTime(),foodtypes.getToTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	/**
	 * update method
	 * @param foodtypes
	 */
	public void update(FoodTypes foodtypes){
		
		String sql="update FOOD_TYPES set TYPE_NAME=? where ID=?";
		Object[] params={foodtypes.getTypeName(),foodtypes.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("No of rows updates: "+rows);
	}
	
	public void delete(FoodTypes foodtypes){
		String sql="delete from FOOD_TYPES where ID=?";
		Object[] params={foodtypes.getId()};
		int rows=jdbcTemplate.update(sql,params);
		System.out.println("No of rows deleted: "+ rows);
	}
	
	
	public List<FoodTypes> list(){
		
		String sql="select * from FOOD_TYPES";
		return jdbcTemplate.query(sql,(rs,rowNum)->
		{
			FoodTypes foodtypes=new FoodTypes();
			foodtypes.setId(rs.getInt("ID"));
			foodtypes.setTypeName(rs.getString("TYPE_NAME"));
			foodtypes.setFromTime(rs.getTime("FROM_TIME").toLocalTime());
			foodtypes.setToTime(rs.getTime("TO_TIME").toLocalTime());
			return foodtypes;

		});
	}
	
	
	public List<String> list1(){
		
		String sql="select TYPE_NAME from FOOD_TYPES";
		return jdbcTemplate.queryForList(sql,String.class);
		
	}
	
	
		public FoodTypes list2(int ID)
		{
		
		String sql="select ID,TYPE_NAME,FROM_TIME,TO_TIME from FOOD_TYPES where ID=?";
		Object[] params={ID};

		return jdbcTemplate.queryForObject(sql,params,(rs,rowNum)->
		{
			FoodTypes foodtypes=new FoodTypes();
			foodtypes.setId(rs.getInt("ID"));
			foodtypes.setTypeName(rs.getString("TYPE_NAME"));
			foodtypes.setFromTime(rs.getTime("FROM_TIME").toLocalTime());
			foodtypes.setToTime(rs.getTime("TO_TIME").toLocalTime());
			return foodtypes;

		});
	}
	
	
	
}	


