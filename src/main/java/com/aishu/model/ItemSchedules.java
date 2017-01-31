package com.aishu.model;

import lombok.Data;

@Data

public class ItemSchedules {

	private int id;
	private FoodTypes foodId;
	private MenuItems menuId;
	private int quantity;

}
