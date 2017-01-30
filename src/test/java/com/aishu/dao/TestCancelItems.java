package com.aishu.dao;

import com.aishu.dao.CancelItemsDao;

public class TestCancelItems {

	public static void main(String[] args) {
		CancelItemsDao dao = new CancelItemsDao();

		String status = dao.cancelItem(10);
		System.out.println(status);

	}

}
