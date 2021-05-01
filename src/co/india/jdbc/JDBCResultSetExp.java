package co.india.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCResultSetExp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			// 1. Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Creat the Connection
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sanny");
			// 3.Prepare the Query
			String sql = "select * from student";
			// 4. Create the Statement
			PreparedStatement preparedStatement =con.prepareStatement(sql);
			// 5. Execute the Query
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Printing result.....Start");
		    while (resultSet.next()) {
                
                // Now we can fetch the data by column name, save and use them!
                int student_id = resultSet.getInt("sid");
                String student_name = resultSet.getString("name");
                String student_email = resultSet.getString("email");
                long student_phone = resultSet.getLong("phone");
 
                System.out.println("sid= " +student_id + ",name= " +student_name+ ",email= " +student_email+ ",phone= " + student_phone );
		    }
			
		    System.out.println("Printing result.....End");
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
