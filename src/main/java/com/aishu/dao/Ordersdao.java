package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.Orders;
import com.aishu.util.ConnectionUtil;

public class Ordersdao {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Orders orders) {
		String sql = "INSERT INTO ORDERS(ID,SEAT_NUM,STATUS)VALUES(?,?,?)";
		Object[] params = { orders.getId(), orders.getSeatNum(), orders.getStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
	}

	public void update(Orders orders) {
		String sql = "UPDATE ORDERS SET STATUS=? WHERE ID=?";
		Object[] params = { orders.getStatus(), orders.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public List<Orders> list() {

		String sql = "select * from ORDERS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Orders orders = new Orders();
			orders.setId(rs.getInt("ID"));
			orders.setSeatNum(rs.getInt("SEAT_NUM"));
			orders.setStatus(rs.getString("STATUS"));
			return orders;

		});
	}

	public Orders list1(int id) {

		String sql = "select ID,SEAT_NUM,STATUS from ORDERS WHERE ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Orders orders = new Orders();
			orders.setId(rs.getInt("ID"));
			orders.setSeatNum(rs.getInt("SEAT_NUM"));
			orders.setStatus(rs.getString("STATUS"));
			return orders;

		});
	}
}
