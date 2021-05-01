package co.india.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPreparedStExp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			// 1. Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Creat the Connection
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sanny");
			// 3.Prepare the Query
			String sql = "update student set name=? , phone=? where sid=?";
			// 4. Create the Statement
			PreparedStatement preparedStatement =con.prepareStatement(sql);
			
			preparedStatement.setString(1, "RamKumar");
			preparedStatement.setString(2, "88888888");
			preparedStatement.setLong  (3, 102);
			// 5. Submit the Query
			int rowsAffected =preparedStatement.executeUpdate();
			
			System.out.println("Table updated Successfully");
			// 6. Process the Result
			System.out.println(rowsAffected);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				// 7. close the connection
				if(st!=null)
					st.close();
				if(con!=null)
					con.close();
				
			}catch(SQLException e){
				System.out.println("Error in the Closing the Resource");
				e.printStackTrace();
			}
		}
	}
	}
