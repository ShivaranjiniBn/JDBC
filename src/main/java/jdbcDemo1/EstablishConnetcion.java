 package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EstablishConnetcion {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");
		// System.out.println("connection established successfully");
		Statement st = con.createStatement();
		//st.execute("create database jdbc");
		//System.out.println("database created successfully");
//		st.execute("create table student (id int, name varchar(20),age int)");
//		System.out.println("table created successfully");
//		st.execute("insert into student (id,name,age) values (1,'A',20)");
//		st.execute("insert into student (id,name,age) values (4,'E',18)");
	//	st.executeUpdate("update student set name = 'Z' where id = 1");
		st.executeUpdate("delete from student where id = 2");
		
		ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
			
		}   
				
	}

}
