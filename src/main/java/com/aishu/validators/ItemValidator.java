package com.aishu.validators;

import java.util.logging.Logger;

import com.aishu.dao.MenuItemsDao;
import com.aishu.exception.ItemNotFoundexception;
import com.aishu.model.MenuItems;
import java.util.logging.Level;

public class ItemValidator {
	Logger logger = Logger.getLogger(MenuItemsDao.class.getName());
	public void validateSave(MenuItems item) {
		if ("".equals(item.getItem())) {
			try {
				throw new ItemNotFoundexception("Item name cannot be null");
			} catch (ItemNotFoundexception e) {
				logger.log(Level.INFO,"Exception caught -",e);
			}
		}
	}

	public void validateUpdate(MenuItems item) {
		if ("".equals(item.getItem())) {
			try {
				throw new ItemNotFoundexception("Item name cannot be null");
			} catch (ItemNotFoundexception e) {
				logger.log(Level.INFO,"Exception caught -",e);

			}
		}
	}

}
