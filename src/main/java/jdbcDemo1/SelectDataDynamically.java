package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectDataDynamically {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		String name = sc.next();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from student where name =?");
		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		} else {
			System.out.println("No data found");
		}

	//	System.out.println("data fetched successfuly!...");

	}

}
