package com.aishu.dao;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import com.aishu.model.MenuItems;
import com.aishu.model.OrderRecords;
import com.aishu.model.Orders;
import com.aishu.dao.OrderRecordsDao;

public class TestOrderRecordsDao {

	public static void main(String[] args) {
		
		OrderRecordsDao orderrecordsdao=new OrderRecordsDao();
		OrderRecords orderrecords=new OrderRecords();
		Orders orders=new Orders();
		MenuItems menuitems=new MenuItems();
		
		
		//TO INSERT INTO TABLE
//		orders.setId(3);
//		menuitems.setId(6);
//	
//		
//		orderrecords.setOrderId(orders);;
//		orderrecords.setMenuId(menuitems);	
//		orderrecords.setQuantity(10);
//		orderrecords.setOrderDate(LocalDateTime.now());
//		orderrecords.setOrderTrack("ORDER DISPATCHED");
//		orderrecordsdao.save(orderrecords);
		
		//TO AVOID DISPLAYING NULL VALUES ITERATOR IS USED
//		List<OrderRecords> list=orderrecordsdao.list();
//		Iterator<OrderRecords> i=list.iterator();
//		while(i.hasNext())
//		{
//			OrderRecords orderrecords1=(OrderRecords)i.next();
//			System.out.println(orderrecords1.getId()+"\t"+orderrecords1.getOrderId().getId()+"\t"+orderrecords1.getMenuId().getId()+"\t"+orderrecords1.getQuantity()+"\t"+orderrecords1.getOrderDate()+"\t"+orderrecords1.getOrderTrack());
//		}
		
		
		orderrecords=orderrecordsdao.listByQuantity(1);
		System.out.println(orderrecords.getId()+"\t"+orderrecords.getMenuId().getId()+"\t"+orderrecords.getQuantity());
		
		

	}

}
