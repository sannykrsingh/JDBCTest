package co.india.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCType4Exp {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try{
			// 1. Load the Driver Class
			Class.forName("com.mysql.jdbc.Driver");
			// 2. Creat the Connection
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sanny");
			// 3.Prepare the Query
			String qry="create table employee(eid int primary key,ename varchar(15),ecity varchar(35),ephone long)";
			
			// 4. Create the Statement
			st=con.createStatement();
			// 5. Submit the Query
			int res=st.executeUpdate(qry);
			
			System.out.println("Table Created Successfully");
			// 6. Process the Result
			System.out.println(res);
			
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
