package com.aishu.dao;

import java.util.List;

import com.aishu.model.FoodTypes;
import com.aishu.dao.FoodTypesDao;

public class TestFoodTypesDao {

	public static void main(String[] args) {
		FoodTypesDao foodtypesdao = new FoodTypesDao();
		FoodTypes foodtypes = new FoodTypes();
		foodtypes.setId(5);
		// foodtypes.setType_name("BRUNCHT");
		// foodtypes.setFrom_time(LocalTime.parse("10:20:00"));
		// foodtypes.setTo_time(LocalTime.parse("14:00:00"));

		// foodtypesdao.save(foodtypes);
		// foodtypesdao.update(foodtypes);
		// foodtypesdao.delete(foodtypes);
		List<FoodTypes> list = foodtypesdao.list();
		for (FoodTypes i : list) {
			System.out.println(i);
		}
		// System.out.println(foodtypesdao.list1());
		// List<String> list1=foodtypesdao.list1();
		// for(String i:list1)
		// {
		// System.out.println(i);
		// }
		// System.out.println(foodtypesdao.list2(3));
	}

}
