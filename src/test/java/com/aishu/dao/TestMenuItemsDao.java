package com.aishu.dao;

import java.util.List;

import com.aishu.model.MenuItems;
import com.aishu.dao.MenuItemsDao;

public class TestMenuItemsDao {

	public static void main(String[] args) {
		MenuItemsDao menuitemsdao=new MenuItemsDao();
		MenuItems menuitems=new MenuItems();
		menuitems.setId(15);
		menuitems.setItem("SAMOSA");
		menuitems.setRate(40);
		
		//menuitemsdao.save(menuitems);
		//menuitemsdao.update(menuitems);
		menuitemsdao.delete(menuitems);
		//List<MenuItems> list=menuitemsdao.list();
			//for(MenuItems i:list)
			//{
				//System.out.println(i);
				//}
			//System.out.println(menuitemsdao.list1());
			//List<String> list1=menuitemsdao.list1();
			//for(String i:list1)
			//{
			//System.out.println(i);
			//}
		//System.out.println(menuitemsdao.list2(3));

	}

}
