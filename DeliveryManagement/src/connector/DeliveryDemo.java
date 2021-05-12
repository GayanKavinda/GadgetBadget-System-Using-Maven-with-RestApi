

package connector;


/*import java.sql.*;
public class DeliveryDemo {

	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost 3306/delivery-db","root","");
			
			System.out.println("db connect");
		}catch(Exception e) {System.out.println(e);}
		return con;
	}
	
	public static int save(Delivery e) {
		int status=0;
		try {
			Connection con=DeliveryDemo.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into delivery-db(deliveryFee,date,location,time) values (?,?,?,?)");
			ps.setString(1, e.getDeliveryFee());
			ps.setString(2, e.getDate());
			ps.setString(3, e.getLocation());
			ps.setString(4, e.getTime());
			
			status=ps.executeUpdate();
			
			con.close();
			
			
		}catch(Exception ex) {ex.printStackTrace();}
		
		return status;
	}
	
	public static int update(Delivery e) {
		int status=0;
		try {
			Connection con=DeliveryDemo.getConnection();
			PreparedStatement ps=con.prepareStatement("update delivery set deliveryId=?, date=?, location=?, time=?");
			ps.setString(1, e.getDeliveryFee());
			ps.setString(2, e.getDate());
			ps.setString(3, e.getLocation());
			ps.setString(4, e.getTime());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex) {ex.printStackTrace();}
		
		return status;
	}
	
	/*public static int delete(int id) {
		int status=0;
		try {
			Connection con=DeliveryDemo.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from delivery-db where id=?");
			ps.setInt(1, id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {e.printStackTrace();}
		
		return status;
		
		public static Delivery getDeliverysById(int id) {
			Delivery e=new Delivery();
			
			try {
				Connection con=DeliveryDemo.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from delivery-db where id=?");
				
				
			}
			
		}
	}*/

