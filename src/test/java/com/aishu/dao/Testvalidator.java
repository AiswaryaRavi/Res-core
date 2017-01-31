package com.aishu.dao;

import com.aishu.model.MenuItems;
import com.aishu.validators.ItemValidator;

public class Testvalidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuItems items = new MenuItems();
		items.setItem("");
		ItemValidator itemValidator = new ItemValidator();

		// itemValidator.validateSave(items);
		itemValidator.validateUpdate(items);
	}

}
