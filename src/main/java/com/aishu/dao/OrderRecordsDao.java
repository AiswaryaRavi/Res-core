package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.MenuItems;
import com.aishu.model.OrderRecords;
import com.aishu.model.Orders;
import com.aishu.util.ConnectionUtil;

public class OrderRecordsDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(OrderRecords orderrecords) {

		String sql = "insert into ORDER_RECORDS(ORDER_ID,MENU_ID,QUANTITY,ORDER_DATE,ORDER_TRACK) values(?,?,?,?,?)";
		Object[] params = { orderrecords.getOrder_id().getId(), orderrecords.getMenu_id().getId(),
				orderrecords.getQuantity(), orderrecords.getOrder_date(), orderrecords.getOrder_track() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public List<OrderRecords> list() {

		String sql = "select ID,ORDER_ID,MENU_ID,QUANTITY,ORDER_DATE,ORDER_TRACK FROM ORDER_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			OrderRecords orderrecords = new OrderRecords();
			orderrecords.setId(rs.getInt("ID"));

			Orders orders = new Orders();
			orders.setId(rs.getInt("ORDER_ID"));
			orderrecords.setOrder_id(orders);

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("MENU_ID"));
			orderrecords.setMenu_id(menuitems);

			orderrecords.setQuantity(rs.getInt("QUANTITY"));
			orderrecords.setOrder_date(rs.getTimestamp("ORDER_DATE").toLocalDateTime());
			orderrecords.setOrder_track(rs.getString("ORDER_TRACK"));

			return orderrecords;

		});
	}

	public OrderRecords listByQuantity(int id) {
		String sql = "select ID, MENU_ID,QUANTITY from ORDER_RECORDS WHERE ID=?";
		Object[] params = { id };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderRecords orderrecords = new OrderRecords();
			orderrecords.setId(rs.getInt("ID"));

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("MENU_ID"));
			orderrecords.setMenu_id(menuitems);

			orderrecords.setQuantity(rs.getInt("QUANTITY"));
			return orderrecords;

		});
	}
}
