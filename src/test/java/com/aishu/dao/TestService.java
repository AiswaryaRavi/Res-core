package com.aishu.dao;

import com.aishu.model.MenuItems;
import com.aishu.validators.CustomerService;
import com.aishu.validators.ServiceException;

public class TestService {

	public static void main(String[] args) {
		CustomerService itemService = new CustomerService();

		MenuItems item = new MenuItems();

		item.setId(-1);
		// item.setItem("");
		// try {
		// itemService.save(item);
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		// try {
		// itemService.delete(item);
		// } catch (ServiceException e) {
		// e.printStackTrace();
		// }
		try {
			itemService.update(item);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
