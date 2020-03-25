package com.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbClass {
	

	public static Connection getConnection() throws Exception {
		String driverName="oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);
		Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
		return conn;
	}

}
