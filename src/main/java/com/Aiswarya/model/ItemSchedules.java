package com.Aiswarya.model;
import lombok.Data;

@Data

public class ItemSchedules {
	
	private int Id;
	private FoodTypes FoodId;
	private MenuItems MenuId;
	private int Quantity;

}
