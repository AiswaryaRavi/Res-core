package com.Aiswarya.dao;

public class TestCancelItems {

	public static void main(String[] args) {
CancelItemsDao dao = new CancelItemsDao();
	
		String status = dao.cancelItem(10,"@MESSAGE");
		System.out.println(status);

	}

}
