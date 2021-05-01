package co.india.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCType1InsertExp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
	
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
			con=DriverManager.getConnection("jdbc:odbc:SannyDSN1","root","sanny");
			// 3.Prepare the Query
			String qry="insert into student values(102,'kumar','kumar1@gmail.com','9020712345')";
	
			st=con.createStatement();
			
			int res=st.executeUpdate(qry);
			// 6. Process the Result
			System.out.println("Record successfully saved");
			
			 
		}catch(ClassNotFoundException e){
			System.out.println("Driver class not found");
			e.printStackTrace();
		}catch(SQLException e){
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
