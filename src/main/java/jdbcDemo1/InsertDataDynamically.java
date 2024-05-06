package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataDynamically {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("Enter age");
		int age = sc.nextInt();	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");
		//prepared statement to dynamically read the values from user
		PreparedStatement ps = con.prepareStatement("insert into student (id,name,age) values (?,?,?) ");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		
		ps.execute();
		System.out.println("data entered successfully");
		
	}

}
