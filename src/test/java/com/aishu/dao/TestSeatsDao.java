package com.aishu.dao;

import java.util.List;

import com.aishu.model.Seats;
import com.aishu.dao.SeatsDao;

public class TestSeatsDao {

	public static void main(String[] args) {
		SeatsDao seatsdao = new SeatsDao();
		Seats seats = new Seats();

		// To insert into table
		 seats.setId(11);
		// seats.setSeatNo(11);
		// seats.getSeatNo("AVAILABLE");
		// seats.setStatus(false);
		// seatsdao.save(seats);

		// To update the table values
		// seats.setSeatNo(3);
		// seats.setStatus(false);
		// seatsdao.update(seats);

		// To update the table values
		// seats.setSeatNo(3);
		// seats.setSeatStatus("AVAILABLE");
		// seatsdao.update1(seats);

		// To delete a particular record
		// seats.setId(11);
		// seatsdao.delete(seats);

		// TO display the whole table
		List<Seats> list = seatsdao.list();
		for (Seats i : list) {
			System.out.println(i);
		}

		// To display one record
		// System.out.println(seatsdao.list1(1));
	}

}
