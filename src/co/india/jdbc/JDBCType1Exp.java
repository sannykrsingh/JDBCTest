package co.india.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCType1Exp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			// 1. Load the Driver Class
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// 2. Creat the Connection
			
			con=DriverManager.getConnection("jdbc:odbc:SannyDSN1","root","sanny");
			// 3.Prepare the Query
			String qry="create table student(sid int primary key,name varchar(15),email varchar(35),phone long)";
			
			// 4. Create the Statement
			st=con.createStatement();
			// 5. Submit the Query
			int res=st.executeUpdate(qry);
			System.out.println("Table Created Successfully");
			// 6. Process the Result
			System.out.println(res);
			
			 
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
