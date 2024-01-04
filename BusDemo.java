package BusReservation;

import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;

public class BusDemo {

	public static void main(String[] args) {

		try {
			BusDAO busdao = new BusDAO();
			busdao.displayBusInfo();
			Scanner input = new Scanner(System.in);

			while (true) {
				System.out.println("1.)Book the Ticket\n2.)Exit");
				System.out.println("Please Make a Choice:");
				int choice = input.nextInt();
				switch (choice) {
				case 1:
					if (choice == 1) {
						Booking booking = new Booking();
						if (booking.isAvaliable()) {
							BookingDAO bookingdao = new BookingDAO();
							busdao.addBooking(booking);
							System.out.println("Your Booking is Confirmed");
						}
					} else {
						System.out.println("Bus is Full");
					}
					break;

				case 2:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Choice");
					break;
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
