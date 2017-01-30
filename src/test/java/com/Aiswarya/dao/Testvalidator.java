package com.Aiswarya.dao;

import com.Aiswarya.Validator.ItemValidator;
import com.Aiswarya.model.MenuItems;

public class Testvalidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuItems items=new MenuItems();
		items.setItem("");
ItemValidator itemValidator = new ItemValidator();
		
		//itemValidator.validateSave(items);
		itemValidator.validateUpdate(items);
	}

}
