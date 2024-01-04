package BusReservation;

public class Bus {

	private int busNo;
	private int capacity; //Get and Set Method
	
	public Bus(int busNo,int capacity)
	{
		this.busNo = busNo;
		this.capacity = capacity;
	}
	
	public int getCapacity()
	{
		return capacity;
	}
	public void setCapacity()
	{
		capacity = capacity;
	}
	public int getBusNo()
	{
		return busNo;
	}
	public void setBusNo()
	{
		busNo = busNo;
	}
	
	
	public void displayBusInfo()
	{
		System.out.println("Bus No: "+busNo+" Capacity: "+capacity);
	}
}
