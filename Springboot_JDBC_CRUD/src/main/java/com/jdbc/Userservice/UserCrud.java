package com.jdbc.Userservice;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserCrud {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// select
	public void select(int id) {

		String sql = "SELECT * FROM car WHERE c_id = ?";
		Object[] params = new Object[] { id };
		Map<String, Object> user = this.jdbcTemplate.queryForMap(sql, params);

		System.out.println(user.toString());
	}

	public void selectAndSaveToAfile(int id) throws IOException {

		String sql = "SELECT * FROM car WHERE c_id = ?";
		Object[] params = new Object[] { 1 };
		Map<String, Object> user = this.jdbcTemplate.queryForMap(sql, params);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		String dateTime = year + "-" + month + "-" + day + "-" + hour + "-" + minute + "-" + second;
		System.out.println(dateTime);

		FileOutputStream fileInputStream = new FileOutputStream("Car " + dateTime + "TZ.txt");
		BufferedOutputStream bufferedInputStream = new BufferedOutputStream(fileInputStream);
		bufferedInputStream.write(user.toString().getBytes());
		System.out.println(user.toString());
		bufferedInputStream.close();
		fileInputStream.close();
	}

	// update
	public void update(String name, int id) {

		/// c_id, c_name, cost
		String sql = "UPDATE car SET c_name = ? WHERE c_id = ?";
		Object[] params = new Object[] { name, id };
		int update = jdbcTemplate.update(sql, params);
		System.out.println(update);
		// note if update ==1 , means updated , and if 0 means not updated
	}

	// delete
	public void delete(int id) {
		String sql = "DELETE FROM car WHERE c_id = ?";
		Object[] params = new Object[] { id };
		int update = jdbcTemplate.update(sql, params);
		System.out.println(update);
		// note if update ==1 , means updated , and if 0 means not updated
	}

	// create
	// Insert a new record
	// public void create( int cid, String cname,double cost) {
	// String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
	// Object[] params = {"Alice", "alice@example.com"};
	// jdbcTemplate.update(sql, params);
	//
	// }
	// assign to controller , but note id must be uniue ,else will get a constraint
	// voilation error
	// usually we wont use create in a existing DB

}
