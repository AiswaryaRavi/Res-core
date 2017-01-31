package com.aishu.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class OrderRecords {

	private int id;
	private Orders orderId;
	private MenuItems menuId;
	private int quantity;
	private LocalDateTime orderDate;
	private String orderTrack;

}
