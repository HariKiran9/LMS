package com.hk.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class C01E03_QuickBrownFox {
	// public static final String DOG = "src/main/resources/img/dog.bmp";

	public static final String DOG = "D:\\HariKiran\\Photos\\IMG_20170527_230026881.jpg";

	// public static final String FOX = "src/main/resources/img/fox.bmp";
	public static final String FOX = "D:\\Sarvani\\ScannedDocuments\\Sarvani_Photo.jpg";

	public static final String DEST = "D:/results/chapter01/quick_brown_fox.pdf";
	
	public static final String DEST2 = "D:/results/chapter01/united_states.pdf";

	public static final String DATA = "D:\\workspace2\\sample2\\src/main/resources/data/united_states.csv";

	public static void main(String args[]) throws IOException {

		File file = new File(DEST);

		file.getParentFile().mkdirs();

//		new C01E03_QuickBrownFox().createPdf(DEST);

		new C01E03_QuickBrownFox().createTable(DEST2);

	}

	private void createTable(String dest) throws IOException {
		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);

		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);
		
		// Initialize document
		Document document = new Document(pdf, PageSize.A4.rotate());
		
		document.setMargins(20, 20, 20, 20);

		PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);

		PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

		Table table = new Table(UnitValue.createPercentArray(new float[] { 4, 1, 3, 4, 3, 3, 3, 3, 1 }))

				.useAllAvailableWidth();

		
		 
		BufferedReader br = new BufferedReader(new FileReader(DATA));

		String line = br.readLine();

		process(table, line, bold, true);

		while ((line = br.readLine()) != null) {

			process(table, line, font, false);

		}

		br.close();

		document.add(table);

		// Close document
		document.close();
	}

	public static void process(Table table, String line, PdfFont font, boolean isHeader) {

		StringTokenizer tokenizer = new StringTokenizer(line, ";");

		while (tokenizer.hasMoreTokens()) {

			if (isHeader) {

				table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));

			} else {

				table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));

			}

		}

	}

	public void createPdf(String dest) throws IOException {

		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);

		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document document = new Document(pdf, PageSize.A4);

		// Compose Paragraph
		Image fox = new Image(ImageDataFactory.create(FOX));

		Image dog = new Image(ImageDataFactory.create(DOG));

		Paragraph p = new Paragraph("The quick brown ")

				.add(fox)

				.add(" jumps over the lazy ")

				.add(dog);

		// Add Paragraph to document
		document.add(p);

		// Close document
		document.close();

	}

}
