package com.insurance.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.insurance.entity.Citizen;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public  class PdfGenerator{
	
	
	
      public static ByteArrayInputStream employeePDFReport(List<Citizen> citizens) {
    	  
    	  com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfWriter.getInstance(document, out);
			document.open();

			// Add Text to PDF file ->
			Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
			Paragraph para = new Paragraph("Employee Table", font);
			para.setAlignment(Element.ALIGN_CENTER);
			document.add(para);
			document.add(Chunk.NEWLINE);

			PdfPTable table = new PdfPTable(3);
			// Add PDF Table Header ->
			Stream.of("CITIZEN_ID", "CITIZEN_NAME", "GENDER", "PLAN_NAME", "PLAN_STATUS", "PLAN_START_DATE",
					"PLAN_END_DATE", "BENEFIT_AMOUNT", "DENIAL_REASON", "TERMINATED_DATE", "TERMINATION_REASON")
					.forEach(headerTitle -> {
						PdfPCell header = new PdfPCell();
						Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
						header.setBackgroundColor(BaseColor.LIGHT_GRAY);
						header.setHorizontalAlignment(Element.ALIGN_CENTER);
						header.setBorderWidth(2);
						header.setPhrase(new Phrase(headerTitle, headFont));
						table.addCell(header);
					});

			for (Citizen cit : citizens) {
				PdfPCell idCell = new PdfPCell(new Phrase(cit.getCITIZEN_ID().toString()));
				idCell.setPaddingLeft(4);
				idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(idCell);

				PdfPCell firstNameCell = new PdfPCell(new Phrase(cit.getCITIZEN_NAME()));
				firstNameCell.setPaddingLeft(4);
				firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(firstNameCell);

				PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(cit.getGENDER())));
				init(lastNameCell);
				table.addCell(lastNameCell);

				PdfPCell NameCell = new PdfPCell(new Phrase(String.valueOf(cit.getPLAN_NAME())));
				init(NameCell);
				table.addCell(NameCell);

				PdfPCell lastNameCell1 = new PdfPCell(new Phrase(String.valueOf(cit.getPLAN_STATUS())));
				init(lastNameCell1);
				table.addCell(lastNameCell1);

				PdfPCell lastNameCell2 = new PdfPCell(new Phrase(String.valueOf(cit.getPLAN_START_DATE())));
				init(lastNameCell2);
				table.addCell(lastNameCell2);

				PdfPCell lastNameCell3 = new PdfPCell(new Phrase(String.valueOf(cit.getPLAN_END_DATE())));
				init(lastNameCell3);
				table.addCell(lastNameCell3);

				PdfPCell lastNameCell4 = new PdfPCell(new Phrase(String.valueOf(cit.getBENEFIT_AMOUNT())));
				init(lastNameCell4);
				table.addCell(lastNameCell4);

				PdfPCell lastNameCell5 = new PdfPCell(new Phrase(String.valueOf(cit.getDENIAL_REASON())));
				init(lastNameCell5);
				table.addCell(lastNameCell5);

				PdfPCell lastNameCell6 = new PdfPCell(new Phrase(String.valueOf(cit.getTERMINATED_DATE())));
				init(lastNameCell6);
				table.addCell(lastNameCell6);

				PdfPCell lastNameCell7 = new PdfPCell(new Phrase(String.valueOf(cit.getTERMINATION_REASON())));
				init(lastNameCell7);
				table.addCell(lastNameCell7);

			}
			document.add(table);

			document.close();
		} catch (DocumentException e) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

	private static void init(PdfPCell lastNameCell) {
		lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		lastNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		lastNameCell.setPaddingRight(4);
	}

}

	
	
	
	
	
	
	
	
	
