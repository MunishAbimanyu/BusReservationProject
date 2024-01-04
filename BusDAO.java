package BusReservation;
import java.sql.*;
import java.sql.Date;
public class BusDAO {

	public  void displayBusInfo()throws SQLException
	{
		String query = "select * from bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next())
		{
			System.out.println("BusNo:"+rs.getInt(1));
			if(rs.getInt(2) == 0)
			{
				System.out.println("Ac: no");
			}
			else
			{
				System.out.println("Ac: Yes");
			}
			System.out.println("Capacity"+rs.getInt(3));
		}
		System.out.println("----------------------------------------");
	}
	
	public int getCapacity(int id)throws SQLException
	{
		String query = "select capacity from bus where id ="+id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	
	public void addBooking(Booking booking)throws SQLException
	{
		String query = "insert into booking values(?,?,?)";
		Connection con = DbConnection.getConnection();
		java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
		PreparedStatement pst = con.prepareCall(query);
		pst.setString(1, booking.passangerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqlDate);
	 pst.executeUpdate();
	}
}
