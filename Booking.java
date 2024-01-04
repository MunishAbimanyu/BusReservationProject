package BusReservation;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Booking {
	String passangerName;
	int busNo;
	Date date;
	Scanner input = new Scanner(System.in);
	public Booking()
	{
		System.out.println("Enter the Name of Passanger:");
		passangerName = input.next();
		System.out.println("Enter the Bus No:");
		busNo = input.nextInt();
		System.out.println("Enter the Date dd-mm-yyyy");
		String dateInput = input.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try
		{
			date = dateFormat.parse(dateInput);
			System.out.println("Bus is Full");
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
	}
	public boolean isAvaliable() throws SQLException
	{
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);
		
		int booked = bookingdao.getBookedCount(busNo,date);
		
		return booked < capacity?true:false;
	}
}
