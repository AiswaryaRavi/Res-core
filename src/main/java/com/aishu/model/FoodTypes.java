package com.aishu.model;

import lombok.Data;
import java.time.LocalTime;

@Data
public class FoodTypes {

	private int Id;
	private String TypeName;
	private LocalTime FromTime;
	private LocalTime ToTime;

}
