package com.aishu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
		Object[] params = { orderrecords.getOrderId().getId(), orderrecords.getMenuId().getId(),
				orderrecords.getQuantity(), orderrecords.getOrderDate(), orderrecords.getOrderTrack() };
		jdbcTemplate.update(sql, params);

	}

	public List<OrderRecords> list() {

		String sql = "select ID,ORDER_ID,MENU_ID,QUANTITY,ORDER_DATE,ORDER_TRACK FROM ORDER_RECORDS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> convert(rs));
		
	}

	private OrderRecords convert(ResultSet rs) throws SQLException {
		OrderRecords orderrecords = new OrderRecords();
		orderrecords.setId(rs.getInt("ID"));

		Orders orders = new Orders();
		orders.setId(rs.getInt("ORDER_ID"));
		orderrecords.setOrderId(orders);

		MenuItems menuitems = new MenuItems();
		menuitems.setId(rs.getInt("MENU_ID"));
		orderrecords.setMenuId(menuitems);

		orderrecords.setQuantity(rs.getInt("QUANTITY"));
		orderrecords.setOrderDate(rs.getTimestamp("ORDER_DATE").toLocalDateTime());
		orderrecords.setOrderTrack(rs.getString("ORDER_TRACK"));

		return orderrecords;
	}

	public OrderRecords listByQuantity(int id) {
		String sql = "select ID, MENU_ID,QUANTITY from ORDER_RECORDS WHERE ID=?";
		Object[] params = { id };

		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			OrderRecords orderrecords = new OrderRecords();
			orderrecords.setId(rs.getInt("ID"));

			MenuItems menuitems = new MenuItems();
			menuitems.setId(rs.getInt("MENU_ID"));
			orderrecords.setMenuId(menuitems);

			orderrecords.setQuantity(rs.getInt("QUANTITY"));
			return orderrecords;

		});
	}
}
