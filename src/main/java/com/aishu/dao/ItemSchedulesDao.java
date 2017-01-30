package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.FoodTypes;
import com.aishu.model.ItemSchedules;
import com.aishu.model.MenuItems;
import com.aishu.util.ConnectionUtil;

public class ItemSchedulesDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(ItemSchedules itemschedules) {

		String sql = "insert into ITEM_SCHEDULES (FOOD_ID,MENU_ID,QUANTITY) values(?,?,?)";
		Object[] params = { itemschedules.getFood_id().getId(), itemschedules.getMenu_id().getId(),
				itemschedules.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(ItemSchedules itemschedules) {

		String sql = "update ITEM_SCHEDULES set FOOD_ID=? where ID=?";
		Object[] params = { itemschedules.getFood_id().getId(), itemschedules.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void update2(ItemSchedules itemschedules) {

		String sql = "update ITEM_SCHEDULES set MENU_ID=? where ID=?";
		Object[] params = { itemschedules.getMenu_id().getId(), itemschedules.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void update1(ItemSchedules itemschedules) {

		String sql = "update ITEM_SCHEDULES set QUANTITY=? where ID=?";
		Object[] params = { itemschedules.getQuantity(), itemschedules.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void delete(int id) {
		String sql = "delete from ITEM_SCHEDULES where ID=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);
	}

	public List<ItemSchedules> list() {

		String sql = "select ID,FOOD_ID,MENU_ID,QUANTITY from ITEM_SCHEDULES";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			ItemSchedules itemschedules = new ItemSchedules();
			itemschedules.setId(rs.getInt("ID"));

			FoodTypes foodtypes = new FoodTypes();
			foodtypes.setId(rs.getInt("FOOD_ID"));
			itemschedules.setFood_id(foodtypes);

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("MENU_ID"));
			itemschedules.setMenu_id(menuitems);

			itemschedules.setQuantity(rs.getInt("QUANTITY"));
			return itemschedules;

		});
	}

	public ItemSchedules listById(int id) {
		String sql = "select ID,FOOD_ID,MENU_ID,QUANTITY fROM ITEM_SCHEDULES WHERE ID=?";
		Object[] params = { id };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			ItemSchedules itemschedules = new ItemSchedules();
			itemschedules.setId(rs.getInt("ID"));

			FoodTypes foodtypes = new FoodTypes();
			foodtypes.setId(rs.getInt("FOOD_ID"));
			itemschedules.setFood_id(foodtypes);

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("MENU_ID"));
			itemschedules.setMenu_id(menuitems);

			itemschedules.setQuantity(rs.getInt("QUANTITY"));
			return itemschedules;

		});
	}

	public ItemSchedules listByQuantity(int id) {
		String sql = "select ID, QUANTITY fROM ITEM_SCHEDULES WHERE ID=?";
		Object[] params = { id };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			ItemSchedules itemschedules = new ItemSchedules();
			itemschedules.setId(rs.getInt("ID"));

			itemschedules.setQuantity(rs.getInt("QUANTITY"));
			return itemschedules;

		});
	}

}
