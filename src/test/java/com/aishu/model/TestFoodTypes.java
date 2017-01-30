package com.aishu.model;

import java.time.LocalTime;

import com.aishu.model.FoodTypes;

public class TestFoodTypes {

	public static void main(String[] args) {
		FoodTypes foodtypes=new FoodTypes();

		foodtypes.setId(5);
		foodtypes.setType_name("BRUNCH");
		foodtypes.setFrom_time(LocalTime.parse("10:15:00"));
		foodtypes.setTo_time(LocalTime.parse("14:00:00"));

		System.out.println(foodtypes.toString());

		System.out.println(foodtypes.getId());
		System.out.println(foodtypes.getType_name());
		System.out.println(foodtypes.getFrom_time());
		System.out.println(foodtypes.getTo_time());

	}

}
