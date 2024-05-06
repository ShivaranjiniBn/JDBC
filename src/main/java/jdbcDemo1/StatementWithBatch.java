package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementWithBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");
		
		Statement st = con.createStatement();
		st.addBatch("insert into student (id,name,age) values (104,'jerry',20)");
		st.addBatch("insert into student (id,name,age) values (105,'manu',20)");
		st.addBatch("delete from student where id = 1");
		
		 int[] arr = st.executeBatch();
		 
		 
		for(int i : arr) {
			 System.out.println(i);
		}
		

	}

}
