


	package com.aishu.dao;

	import java.sql.Types;
	import java.util.Map;

	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.SqlOutParameter;
	import org.springframework.jdbc.core.SqlParameter;
	import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
	import org.springframework.jdbc.core.namedparam.SqlParameterSource;
	import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.aishu.util.ConnectionUtil;

	public class CancelItemsDao {
			private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

			public String cancelItem(Integer seatno,String message) {
		 SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_CANCEL_ITEM")
	             .declareParameters(new SqlParameter("SEATNUM", Types.INTEGER),
	                     new SqlOutParameter("MESSAGE", Types.VARCHAR));
	             //	new SqlOutParameter("ERR", Types.BOOLEAN));
	     call.setAccessCallParameterMetaData(false);
	     SqlParameterSource in = new MapSqlParameterSource().addValue("SEATNUM",seatno);
	     Map<String, Object> execute = call.execute(in);
	     String status = (String) execute.get("MESSAGE");
	   // String error1 = (String) execute.get("ERR");
	     
	     return status;

	}
	}


