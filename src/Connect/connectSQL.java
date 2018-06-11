package Connect;

import java.sql.*;

public class connectSQL {
	static String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String userName = "";
	static String passWord = "";
	static String URL = "jdbc:sqlserver://localhost:1433"
			+ ";instance=SQLEXPRESS;databaseName=QuanLyNhanSU;integratedSecurity=true;";

	public static Connection connect() throws ClassNotFoundException, SQLException {
		// load driver
		Class.forName(Driver);
		// get connection
		Connection cn = DriverManager.getConnection(URL, userName, passWord);
		return cn;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connectSQL.connect();
	}
}
