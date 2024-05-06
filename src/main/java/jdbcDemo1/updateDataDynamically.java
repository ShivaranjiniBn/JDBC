package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateDataDynamically {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		System.out.println("enter name");
		String name = sc.next();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");
		// prepared statement to dynamically read the values from user
//		PreparedStatement ps = con.prepareStatement("update student set name = ? where id = ? ");
		PreparedStatement ps = con.prepareStatement("delete from student where id = ? ");

		ps.setInt(1, id);

		int row = ps.executeUpdate();
		System.out.println(row);
		// System.out.println("data updated successfully");
		System.out.println("data deleted successfully");
	}

}
