package com.Aiswarya.Validator;

import com.Aiswarya.model.MenuItems;

import com.Aiswarya.Exception.ItemNotFoundexception;

public class ItemValidator {
	public void validateSave(MenuItems item)
	{
		if("".equals(item.getItem()))
		{
			try
			{
				throw new ItemNotFoundexception ("Item name cannot be null");
			}
			catch (ItemNotFoundexception e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}
	
	public void validateUpdate(MenuItems item)
	{
		if("".equals(item.getItem()))
		{
			try
			{
				throw new ItemNotFoundexception ("Item name cannot be null");
			}
			catch (ItemNotFoundexception e)
			{
				System.out.println("Exception caught - "+e);
			}
		}
	}
	

}
