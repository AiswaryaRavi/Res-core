package com.aishu.Validator;

import com.aishu.Exception.ItemNotFoundexception;
import com.aishu.model.MenuItems;

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
