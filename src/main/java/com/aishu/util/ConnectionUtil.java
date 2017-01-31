package com.aishu.util;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {
	private ConnectionUtil() {
		throw new IllegalAccessError("Utility class");
	}
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("dev_user");
		ds.setPassword("dev_pwd");
		String ip = "139.59.29.57";
		try {
			Socket socket = new Socket(ip, 3306);
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ds.setUrl("jdbc:mysql://socket/aishwarya_db");
		return ds;
	}

	public static JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
}
