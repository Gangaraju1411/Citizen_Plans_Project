package com.insurance.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.insurance.entity.Citizen;

@Component
public class ExcelGenerator {

	 public boolean generateExcelFile(List<Citizen> citizens) {
	        try (Workbook workbook = new XSSFWorkbook()) {
	            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("citizens");
	            // Write column headers
	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("CITIZEN_ID");
	            headerRow.createCell(1).setCellValue("CITIZEN_NAME");
	            headerRow.createCell(2).setCellValue("GENDER");
	            headerRow.createCell(3).setCellValue("PLAN_NAME");
	            headerRow.createCell(4).setCellValue("PLAN_STATUS");
	            headerRow.createCell(5).setCellValue("PLAN_START_DATE");
	            headerRow.createCell(6).setCellValue("PLAN_END_DATE");
	            headerRow.createCell(7).setCellValue("BENEFIT_AMOUNT");
	            headerRow.createCell(8).setCellValue("DENIAL_REASON");
	            headerRow.createCell(9).setCellValue("TERMINATED_DATE");
	            headerRow.createCell(10).setCellValue("TERMINATION_REASON");
	            
	            // Write employee data
	            int rowNumber = 1;
	            for (Citizen cit : citizens) {
	                Row row = sheet.createRow(rowNumber++);
	                row.createCell(0).setCellValue(cit.getCITIZEN_ID());
	                row.createCell(1).setCellValue(cit.getCITIZEN_NAME());
	                row.createCell(2).setCellValue(cit.getGENDER());
	                row.createCell(3).setCellValue(cit.getPLAN_NAME());
	                row.createCell(4).setCellValue(cit.getPLAN_STATUS());
	                row.createCell(5).setCellValue(cit.getPLAN_START_DATE());
	                row.createCell(6).setCellValue(cit.getPLAN_END_DATE());
	                row.createCell(7).setCellValue(cit.getBENEFIT_AMOUNT());
	                row.createCell(8).setCellValue(cit.getDENIAL_REASON());
	                row.createCell(9).setCellValue(cit.getTERMINATED_DATE());
	                row.createCell(10).setCellValue(cit.getTERMINATION_REASON());
	                
	                
	            }

	            // Write Excel file to disk
	            try (FileOutputStream fileOut = new FileOutputStream("D:\\imp\\ProjectExcel.xlsx")) {
	                workbook.write(fileOut);
	            }
	        } catch (IOException e) {
	            // Handle exception
	        }
	        return true;
	    }

}
	
	
