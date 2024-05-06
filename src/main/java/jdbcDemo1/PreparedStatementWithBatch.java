package jdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementWithBatch {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:Mysql://localhost:3306/jdbc", "root", "root");

		PreparedStatement ps = con.prepareStatement("insert into student (id,name,age) values (?,?,?)");

		ps.setInt(1, 25);
		ps.setString(2, "jhon");
		ps.setInt(3, 25);

		ps.addBatch();

		ps.executeBatch();

	}

}
