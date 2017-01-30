package com.aishu.dao;

import com.aishu.dao.TakeOrderProcedureDao;

//import java.time.LocalTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;

public class TestProcedure {

	public static void main(String[] args) {
		TakeOrderProcedureDao dao = new TakeOrderProcedureDao();
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ENGLISH);
		//LocalTime time = LocalTime.now();
		//String timeForm = formatter.format(time);
		
		
		
		String status = dao.placeOrder("COFFE,TEA,TEA","2,1,2","1","@MESSAGE");
		System.out.println(status);



	}

}
