package samples.adaptive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerStatement;

public class SQLServerTest {

	public static void main(String[] args) {
		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=AC_118;integratedSecurity=true;";

		// Declare the JDBC objects.
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);

			// In adaptive mode, the application does not have to use a server cursor
			// to avoid OutOfMemoryError when the SELECT statement produces very large
			// results.

			// Create and execute an SQL statement that returns some data.
			String SQL = "SELECT TOP (1000) * FROM dbo.EROLL";

			stmt = con.createStatement();

			// Display the response buffering mode.
			SQLServerStatement SQLstmt = (SQLServerStatement) stmt;
			System.out.println("Response buffering mode is: " + SQLstmt.getResponseBuffering());

			// Get the updated data from the database and display it.
			rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println(rs.getString("C_HOUSE_NO") + " " + rs.getString("FM_NAME_V1") + " 	" + rs.getString("LASTNAME_V1"));
//				Reader reader = rs.getCharacterStream(2);
//				if (reader != null) {
//					char output[] = new char[40];
//					while (reader.read(output) != -1) {
//						// Do something with the chunk of the data that was
//						// read.
//					}
//
//					System.out.println(rs.getString(1) + " has been accessed for the summary column.");
//					// Close the stream.
//					reader.close();
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

	}

}
