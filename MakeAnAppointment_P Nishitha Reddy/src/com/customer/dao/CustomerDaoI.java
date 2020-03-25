package com.customer.dao;

import java.sql.ResultSet;

public interface CustomerDaoI {

	ResultSet showCenter() throws Exception;

	boolean showTest() throws Exception;

	String makeAppointment(String center,String test,String s, String uname) throws Exception;

	void view(String string) throws AppointmentNotFoundException,Exception;

}
