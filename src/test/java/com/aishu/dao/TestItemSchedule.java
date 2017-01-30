package com.aishu.dao;

import java.util.Iterator;
import java.util.List;

import com.aishu.model.FoodTypes;
import com.aishu.model.ItemSchedules;
import com.aishu.model.MenuItems;
import com.aishu.dao.ItemSchedulesDao;

public class TestItemSchedule {

	public static void main(String[] args) {

		ItemSchedulesDao itemschedulesdao = new ItemSchedulesDao();
		FoodTypes foodtypes = new FoodTypes();
		MenuItems menuitems = new MenuItems();
		ItemSchedules itemschedules = new ItemSchedules();

		// TO INSERT INTO TABLE
		itemschedules.setId(18);
		foodtypes.setId(1);
		menuitems.setId(15);

		itemschedules.setFoodId(foodtypes);
		itemschedules.setMenuId(menuitems);
		itemschedules.setQuantity(100);
		itemschedulesdao.save(itemschedules);

		// to update Food_Id into table
		itemschedules.setId(18);
		foodtypes.setId(2);
		itemschedules.setFoodId(foodtypes);
		itemschedulesdao.update(itemschedules);

		// to update Quantity into table
		itemschedules.setQuantity(120);
		itemschedulesdao.update1(itemschedules);

		// to delete row from a table
		itemschedulesdao.delete(17);

		// It Displays null values for column which are not foreign key
		//// List<ItemSchedules> list=itemschedulesdao.list();
		// for(ItemSchedules i:list)
		// {
		// System.out.println(i);
		// }

		// TO AVOID DISPLAYING NULL VALUES ITERATOR IS USED
		List<ItemSchedules> list = itemschedulesdao.list();
		Iterator<ItemSchedules> i = list.iterator();
		while (i.hasNext()) {
			ItemSchedules itemschedules1 = (ItemSchedules) i.next();
			System.out.println(itemschedules1.getId() + "\t" + itemschedules1.getFoodId().getId() + "\t"
					+ itemschedules1.getMenuId().getId() + "\t" + itemschedules1.getQuantity());
		}
		//

		// It Displays null values for column which are not foreign key
		// System.out.println(itemschedulesdao.listById(1));

		// To avoid null values for the column which are not foreign key
		// itemschedules=itemschedulesdao.listById(1);
		// System.out.println(itemschedules.getId()+"\t"+itemschedules.getFoodId().getId()+"\t"+itemschedules.getMenuId().getId()+"\t"+itemschedules.getQuantity());
		//
		// itemschedules=itemschedulesdao.listByQuantity(1);
		// System.out.println(itemschedules.getId()+"\t"+itemschedules.getQuantity());

	}

}
