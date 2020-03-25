package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.customer.bean.CustomerBean;

public class CustomerDao implements CustomerDaoI {
	CustomerBean bean = new CustomerBean();
	static String centername = "";
	static String tests = "";
	Scanner sc = new Scanner(System.in);
	public ResultSet showCenter() throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DbClass.getConnection();
		String str = "select * from center";
		pst = conn.prepareStatement(str);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		return rs;
	}

	public boolean showTest() throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DbClass.getConnection();
		String str1 = "select * from center";
		pst = conn.prepareStatement(str1);
		ResultSet rs1 = pst.executeQuery();
		while (rs1.next()) {
			System.out.println(rs1.getString(3));
		}
		return true;
	}
	public String makeAppointment(String center,String test,String s,String uname) throws Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DbClass.getConnection();
		pst=conn.prepareStatement("insert into appointment values(id2.nextval,?,?,?,?)");
		pst.setString(1, uname);
		pst.setString(2, center);
		pst.setString(3, test);
		pst.setString(4, s);
		pst.executeUpdate();
		PreparedStatement pst1 = conn.prepareStatement("select * from appointment where username=?");
		pst1.setString(1, uname);
		ResultSet rs2 = pst1.executeQuery();
		if(rs2.next())
		{
			System.out.println("Appointment id:"+rs2.getString(1));
		}
		return rs2.getString(1);
	}
	public void view(String string) throws AppointmentNotFoundException,Exception {
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DbClass.getConnection();
		pst = conn.prepareStatement("select * from appointment");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			if (rs.getString(1).equals(string))
				System.out.println("Appointment id :" + rs.getString(1) + "\nUser name: " + rs.getString(2)
						+ "\ncentre name: " + rs.getString(3) + "\nTest name: " + rs.getString(4) + "\nDate and Time: "
						+ rs.getString(5));
			else
				throw new AppointmentNotFoundException("No Appointment Found");
		}
	}	
}
