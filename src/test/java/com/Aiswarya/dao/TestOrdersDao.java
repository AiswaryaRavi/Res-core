package com.Aiswarya.dao;

import java.util.List;

import com.Aiswarya.model.Orders;

public class TestOrdersDao {

	public static void main(String[] args) {
		
		Ordersdao ordersdao=new Ordersdao();
		Orders orders=new Orders();
		
		//To insert into table
		//orders.setId(3);
		//orders.setSeatNum(2);
		//orders.setStatus("served");
		//ordersdao.save(orders);
		
		
		//To update the table values
		//orders.setId(3);
		//orders.setStatus("Requested");
		//ordersdao.update(orders);
		
		
		
		
		//TO display the whole table
		//List<Orders> list=ordersdao.list();
				//for(Orders i:list)
				//{
					//System.out.println(i);
				//}
				
		//To display one record		
		System.out.println(ordersdao.list1(1));

	}

}
