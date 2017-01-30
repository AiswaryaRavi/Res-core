package com.Aiswarya.dao;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.Aiswarya.util.ConnectionUtil;

public class TakeOrderProcedureDao {
	private final JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public String placeOrder(String items,String quantity,String seatno,String message) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("PR_TAKEORDER")
                .declareParameters(new SqlParameter("ITEM_LISTS", Types.LONGVARCHAR),
                		new SqlParameter("ITEM_QUANTITY", Types.LONGNVARCHAR),
                        new SqlParameter("SEAT_NUMB", Types.VARCHAR),
                        new SqlOutParameter("MESSAGE", Types.VARCHAR));
                //	new SqlOutParameter("ERR", Types.BOOLEAN));
        call.setAccessCallParameterMetaData(false);
        SqlParameterSource in = new MapSqlParameterSource().addValue("ITEM_LISTS", items)
        													.addValue("ITEM_QUANTITY",quantity)
        													.addValue("SEAT_NUMB", seatno);
        Map<String, Object> execute = call.execute(in);
        String status = (String) execute.get("MESSAGE");
      // String error1 = (String) execute.get("ERR");
        
        return status;
        
 
    }
}
