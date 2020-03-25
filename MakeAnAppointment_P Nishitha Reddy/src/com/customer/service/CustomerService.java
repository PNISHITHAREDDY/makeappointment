package com.customer.service;

import com.customer.bean.CustomerBean;
import com.customer.dao.AppointmentNotFoundException;
import com.customer.dao.CustomerDao;
import com.customer.dao.CustomerDaoI;

public class CustomerService implements CustomerServiceI {
 static CustomerDaoI dao=new CustomerDao();
	public void showCenter() throws Exception {
		dao.showCenter();
	}
	
	public boolean showTest() throws Exception {
		return dao.showTest();
		
		
	}
	public String makeAppointment(String center,String test,String s,String uname) throws Exception {
		CustomerBean bean=new CustomerBean();
		bean.setUname(uname);
		return dao.makeAppointment(center,test,s,uname);
	}
	
	public void view(String string) throws AppointmentNotFoundException,Exception {
		dao.view(string);
		
	}
	
}
