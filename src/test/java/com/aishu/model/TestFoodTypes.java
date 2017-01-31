package com.aishu.model;

import java.time.LocalTime;

import com.aishu.model.FoodTypes;

public class TestFoodTypes {

	public static void main(String[] args) {
		FoodTypes foodtypes=new FoodTypes();

		foodtypes.setId(5);
		foodtypes.setTypeName("BRUNCH");
		foodtypes.setFromTime(LocalTime.parse("10:15:00"));
		foodtypes.setToTime(LocalTime.parse("14:00:00"));

		System.out.println(foodtypes.toString());

		System.out.println(foodtypes.getId());
		System.out.println(foodtypes.getTypeName());
		System.out.println(foodtypes.getFromTime());
		System.out.println(foodtypes.getToTime());

	}

}
