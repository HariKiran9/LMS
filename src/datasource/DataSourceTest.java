package datasource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DataSourceTest {

	public static void main(String[] args) {

		// testDataSource("mysql");

		// testDataSource("oracle");

		testDataSource("sqlserver");

	}

	public static DataSource testDataSource(String dbType) {
		DataSource ds = null;
		if ("mysql".equals(dbType)) {
			ds = MyDataSourceFactory.getMySQLDataSource();
			getDataFromMySQL(ds);
		} else if ("oracle".equals(dbType)) {
			ds = MyDataSourceFactory.getOracleDataSource();
		} else if ("sqlserver".equals(dbType)) {
			ds = MyDataSourceFactory.getMSSQLServerDataSource();
			// getDataFromMSSqlServer(ds);
			getBlobDataFromMSSqlServer(ds);
		} else {
			System.out.println("invalid db type");
			return null;
		}
		return ds;
	}

	private static void getDataFromMySQL(DataSource ds) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			System.out.println(" MySQL Database Connected Successfully !!!!");
			// rs = stmt.executeQuery("select ticket, name from titanic_data");
			rs = stmt.executeQuery("select count(id) as count from test.student1");
			int count = 0;
			while (rs.next()) {
				// System.out.println("Employee ID=" + rs.getString("ticket") +
				// ", Name=" + rs.getString("name"));
				count = Integer.parseInt(rs.getString("count"));
			} // while
			System.out.println(" count : " + count);

			PreparedStatement pstmt = con.prepareStatement("UPDATE test.student1 SET marks = ? WHERE id = ?");
			for (int i = 0; i < count; i++) {
				pstmt.setInt(1, 80 * (i + 1));
				pstmt.setInt(2, (i + 1));
				pstmt.addBatch();
			} // for

			int[] batchCount = pstmt.executeBatch();
			for (int i = 0; i < batchCount.length; i++) {
				System.out.println(batchCount[i]);
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void getDataFromMSSqlServer(DataSource ds) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			System.out.println("MS SQL Server Connected Successfully !!!!!!!!");
			rs = stmt.executeQuery("select count(ac_no) as count from dbo.EROLL");
			int count = 0;
			while (rs.next()) {
				count = Integer.parseInt(rs.getString("count"));
			} // while

			System.out.println(" count : " + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void getBlobDataFromMSSqlServer(DataSource ds) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			stmt = con.createStatement();
			System.out.println("MS SQL Server Connected Successfully !!!!!!!!");

			String query = "select EPIC_NO, FM_NAME_V1, LASTNAME_V1, PHOTO from dbo.EROLL where slnoinpart = ?";
			PreparedStatement psstmt = con.prepareStatement(query);
			psstmt.setInt(1, 650);
			rs = psstmt.executeQuery();

			// rs = stmt.executeQuery(
			// "select EPIC_NO, FM_NAME_V1, LASTNAME_V1, PHOTO from dbo.EROLL where
			// slnoinpart = " + 650);

			while (rs.next()) {
				String EPIC_NO = rs.getString("EPIC_NO");
				System.out.println("EPIC_NO : " + EPIC_NO);

				File image = new File("D:\\db\\" + EPIC_NO);
				FileOutputStream fos = new FileOutputStream(image);
				byte[] buffer = new byte[1];
				InputStream is = rs.getBinaryStream("PHOTO");
				while (is.read(buffer) > 0) {
					fos.write(buffer);
				}
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // finally
	}

}
