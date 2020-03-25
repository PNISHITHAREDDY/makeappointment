package com.customer.service;

import com.customer.dao.AppointmentNotFoundException;

public interface CustomerServiceI {
	void showCenter() throws Exception;
	boolean showTest() throws Exception;
	void view(String next) throws AppointmentNotFoundException,Exception;
	String makeAppointment(String center, String test, String s, String uname) throws Exception;

}
