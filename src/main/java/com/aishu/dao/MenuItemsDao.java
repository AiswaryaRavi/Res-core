package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.MenuItems;
import com.aishu.util.ConnectionUtil;

public class MenuItemsDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(MenuItems menuitems) {

		String sql = "insert into MENU_ITEMS(ID,ITEM,RATE) values(?,?,?)";
		Object[] params = { menuitems.getId(), menuitems.getItem(), menuitems.getRate() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(MenuItems menuitems) {

		String sql = "update MENU_ITEMS set ITEM=? where ID=?";
		Object[] params = { menuitems.getItem(), menuitems.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void delete(MenuItems menuitems) {
		String sql = "delete from MENU_ITEMS where ID=?";
		Object[] params = { menuitems.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
	}

	public List<MenuItems> list() {

		String sql = "select * from MENU_ITEMS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("ID"));
			menuitems.setItem(rs.getString("ITEM"));
			menuitems.setRate(rs.getInt("RATE"));
			return menuitems;

		});
	}

	public List<String> list1() {

		String sql = "select ITEM from MENU_ITEMS";
		return jdbcTemplate.queryForList(sql, String.class);

	}

	public MenuItems list2(int ID) {

		String sql = "select ID,ITEM,RATE from MENU_ITEMS where ID=?";
		Object[] params = { ID };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("ID"));
			menuitems.setItem(rs.getString("ITEM"));
			menuitems.setRate(rs.getInt("RATE"));
			return menuitems;

		});
	}

}
