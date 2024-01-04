package BusReservation;
import java.util.Date;
import java.sql.*;
public class BookingDAO {

	public int getBookedCount(int BusNo,Date date)throws SQLException 
	{
		String query = "select count(*) from booking where bus_no = ? and travel_date = ?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareCall(query);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		pst.setInt(1,BusNo);
		pst.setDate(2, sqlDate);
		ResultSet rs = pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
}
