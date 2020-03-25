package com.customer.dao;

import java.sql.ResultSet;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTest {
	CustomerDaoI dao = new CustomerDao();

	@Test
	public void showCenter() throws Exception {
		ResultSet result = dao.showCenter();
			assertNotNull(result.next());
	}
	
	/*@Test
	public void showCenter() throws Exception {
		ResultSet result = dao.showCenter();
			assertNull(result.next());
	}
*/}
