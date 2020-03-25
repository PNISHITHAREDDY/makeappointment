package com.customer.ui;

import java.util.Scanner;

import com.customer.dao.AppointmentNotFoundException;
import com.customer.service.CustomerService;
import com.customer.service.CustomerServiceI;

public class Mainui {
	static CustomerServiceI service = new CustomerService();
	static String a = "09/3/2020 & 9:00 AM";
	static String b = "09/3/2020 & 11:00 AM";
	static String c = "09/3/2020 & 2:00 PM";
	static int count = 0, count1 = 0, count2 = 0;

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws AppointmentNotFoundException, Exception {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your option");
			System.out.println("1.Make Appointment");
			System.out.println("2.View Appointment");
			System.out.println("3.exit");
			int opt = sc.nextInt();
			switch (opt) {
			case 1:
				System.out.println("Enter your name");
				String uname = sc.next();
				System.out.println("select center");
				service.showCenter();
				String center = sc.next();
				System.out.println("select test");
				service.showTest();
				String test = sc.next();
				while (true) {
					System.out.println("select date and time");
					System.out.println("1. " + a);
					System.out.println("2. " + b);
					System.out.println("3. " + c);
					System.out.println("Enter your choice");
					int ch = sc.nextInt();
					if (ch == 1 && count == 0) {
						String s = a;
						String str = service.makeAppointment(center, test, s, uname);
						count++;
						break;
					} else if (ch == 2 && count1 == 0) {
						String s = b;
						service.makeAppointment(center, test, s, uname);
						count1++;
						break;
					} else if (ch == 3 && count2 == 0) {
						String s = c;
						service.makeAppointment(center, test, s, uname);
						count2++;
						break;
					} else
						System.out.println("Busy \n choose another date and time");
				}

			case 2:
				while (true) {
					try {
						System.out.println("to see the appointment details");
						System.out.println("Enter appointment id");
						service.view(sc.next());
					} catch (AppointmentNotFoundException e) {
						System.out.println("Enter valid AccountId");
					}
				}
			case 3:
				return;

			}
		}
	}
}
