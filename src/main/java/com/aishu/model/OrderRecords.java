package com.aishu.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class OrderRecords {

	private int id;
	private Orders order_id;
	private MenuItems menu_id;
	private int quantity;
	private LocalDateTime order_date;
	private String order_track;

}
