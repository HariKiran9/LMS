/**
 * 
 */
package com.hk.data;

import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * @author Home
 *
 */
public class FirstPdf {

	public static final String DEST = "D:\\results/chapter01/hello_world.pdf";

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
			new FirstPdf().createPdf(DEST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
