package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import datasource.MyDataSourceFactory;

public class FileEx1 {

	private static final Logger log = Logger.getLogger(FileEx1.class.getName());

	public boolean writeDateToFileFromDB() {
		boolean isWritten = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			DataSource ds = MyDataSourceFactory.getMySQLDataSource();
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select ticket, name from titanic_data");
			while (rs.next()) {
				// log.info("Employee ID=" + rs.getString("ticket") + ", Name=" + rs.getString("name"));
				writeFile4(rs.getString("name"), rs.getString("ticket"));
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
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
				if (bw != null) {
					bw.close();
				}
				if (osw != null) 
					osw.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isWritten;
	}

	private void readWrite(String name, String ticket) {
		System.out.println("name : " + name);
		String content = name + ", " + ticket;
		Writer  bw = null;
		File file = new File("D:\\log\\sample.csv");
//		Charset charset = Charset.forName("US-ASCII");
//		Path wiki_path = Paths.get("D:\\log\\sample.csv");
//		try (BufferedWriter writer = Files.newBufferedWriter(wiki_path, charset, StandardOpenOption.CREATE)) {
//			writer.write(content + "\n");
//		    
//		} catch (IOException x) {
//		    System.err.format("IOException: %s%n", x);
//		}
	}
	
	static BufferedWriter bw =  null;
	public static void writeFile1(String name, String ticket) {
		System.out.println("name : " + name);
		String content = name + ", " + ticket;
		try {
			File fout = new File("D:\\log\\sample.csv");
			FileOutputStream fos = new FileOutputStream(fout);		 
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(content);
			bw.newLine();
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		} 		
	}
	
	static OutputStreamWriter osw = null;
	public static void writeFile4(String name, String ticket) throws IOException {
		String content = name + ", " + ticket;
		File fout = new File("D:\\log\\sample.csv");
		FileOutputStream fos = new FileOutputStream(fout);	 
		osw = new OutputStreamWriter(fos);	 
		osw.write(content);
	}

	public static void main(String[] args) {
		boolean isWritten = new FileEx1().writeDateToFileFromDB();
		log.info(" isWritten : " + isWritten);
	}

}
