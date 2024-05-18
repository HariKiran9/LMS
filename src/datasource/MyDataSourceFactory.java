package datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MyDataSourceFactory {

	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("D:\\workspace2\\sample2\\src\\main\\java\\db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}

	public static DataSource getOracleDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		OracleDataSource oracleDS = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}

	public static DataSource getMSSQLServerDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		SQLServerDataSource sqlServerDS = null;
		try {
			fis = new FileInputStream("D:\\workspace2\\sample2\\src\\main\\java\\db.properties");
			props.load(fis);
			sqlServerDS = new SQLServerDataSource();
			sqlServerDS.setURL(props.getProperty("MSSQL_DB_URL"));
//			sqlServerDS.setUser(props.getProperty("MSSQL_DB_USERNAME"));
//			sqlServerDS.setPassword(props.getProperty("MSSQL_DB_PASSWORD"));
//			sqlServerDS.setDatabaseName("AC_118");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlServerDS;
	}

}