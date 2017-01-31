package com.aishu.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.aishu.model.Seats;
import com.aishu.util.ConnectionUtil;

public class SeatsDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Seats seats) {

		String sql = "insert into SEATS(ID,SEAT_NO,STATUS,CONCURRENT_USER_STATE) values(?,?,?)";
		Object[] params = { seats.getId(), seats.getSeatStatus(), seats.getSeatNo(), seats.getStatus() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(Seats seats) {

		String sql = "update SEATS set CONCURRENT_USER_STATE=? where SEAT_NO=?";
		Object[] params = { seats.getStatus(), seats.getSeatNo() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void update1(Seats seats) {

		String sql = "update SEATS set STATUS=? where SEAT_NO=?";
		Object[] params = { seats.getSeatStatus(), seats.getSeatNo() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updates: " + rows);
	}

	public void delete(Seats seats) {
		String sql = "delete from SEATS where ID=?";
		Object[] params = { seats.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
	}

	public List<Seats> list() {

		String sql = "select * from SEATS";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Seats seats = new Seats();
			seats.setId(rs.getInt("ID"));
			seats.setSeatNo(rs.getInt("SEAT_NO"));
			seats.setSeatStatus(rs.getString("STATUS"));
			seats.setStatus(rs.getBoolean("CONCURRENT_USER_STATE"));
			return seats;

		});
	}

	public Seats list1(int id) {

		String sql = "select ID,SEAT_NO,STATUS,CONCURRENT_USER_STATE from SEATS WHERE ID=?";
		Object[] params = { id };
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Seats seats = new Seats();
			seats.setId(rs.getInt("ID"));
			seats.setSeatNo(rs.getInt("SEAT_NO"));
			seats.setSeatStatus(rs.getString("STATUS"));
			seats.setStatus(rs.getBoolean("CONCURRENT_USER_STATE"));
			return seats;

		});
	}

}
