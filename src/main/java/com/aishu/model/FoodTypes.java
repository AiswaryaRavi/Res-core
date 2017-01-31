package com.aishu.model;

import lombok.Data;
import java.time.LocalTime;

@Data
public class FoodTypes {

	private int id;
	private String typeName;
	private LocalTime fromTime;
	private LocalTime toTime;

}
