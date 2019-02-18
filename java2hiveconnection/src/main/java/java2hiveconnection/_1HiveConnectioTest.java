package java2hiveconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _1HiveConnectioTest {
	
	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			conn = DriverManager.getConnection("jdbc:hive2://localhost:10000/default","hduser","");
			st = conn.createStatement();
			String sql = "show databases";
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			
			sql = "use fbdb";
			st.execute(sql);
			System.out.println("**************************************");
			sql = "show tables";
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			sql = "select * from facebooklog1";
			rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
