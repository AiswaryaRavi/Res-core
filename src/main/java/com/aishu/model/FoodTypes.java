package com.aishu.model;

import lombok.Data;
import java.time.LocalTime;

@Data
public class FoodTypes {

	private int id;
	private String type_name;
	private LocalTime from_time;
	private LocalTime to_time;

}
