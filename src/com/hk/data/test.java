/**
 * 
 */
package com.hk.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import datasource.DataSourceTest;

/**
 * @author Home
 *
 */
public class test {

	public static final String DEST = "D:\\results/chapter01/hello_world.pdf";

	
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
	
	public void createPdf(String dest) throws IOException {

		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);

		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document document = new Document(pdf);

		// Add paragraph to the document
		document.add(new Paragraph("Hello World!"));
		
		// Close document
		document.close();
	}

	public static void main(String[] args) {
		try {
			File file = new File(DEST);
			file.getParentFile().mkdirs();
			new test().createPdf(DEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
