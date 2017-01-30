package com.Aiswarya.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data

public class OrderRecords {
	
	private int Id;
	private Orders OrderId;
	private MenuItems MenuId;
	private int Quantity;
	private LocalDateTime OrderDate;
	private String OrderTrack;

}
