package com.aishu.model;

import lombok.Data;

@Data

public class ItemSchedules {

	private int Id;
	private FoodTypes food_id;
	private MenuItems menu_id;
	private int quantity;

}
