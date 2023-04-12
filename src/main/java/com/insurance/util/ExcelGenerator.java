package com.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.insurance.entity.Citizen;

@Component
public class ExcelGenerator {
	

	public void generate(HttpServletResponse response, List<Citizen> records,File f) throws Exception {

		Workbook workbook = new HSSFWorkbook();

		Sheet sheet = workbook.createSheet("Citizen Plan");

		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("Policy Id");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Gender");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benefit Amount");

		int rowNumber = 1;

		for (Citizen plans : records) {
			Row createRow = sheet.createRow(rowNumber);

			createRow.createCell(0).setCellValue(plans.getCITIZEN_ID());
			createRow.createCell(1).setCellValue(plans.getCITIZEN_NAME());
			createRow.createCell(2).setCellValue(plans.getPLAN_NAME());
			createRow.createCell(3).setCellValue(plans.getPLAN_STATUS());
			createRow.createCell(4).setCellValue(plans.getGENDER());
			createRow.createCell(5).setCellValue(plans.getPLAN_START_DATE() + "");
			createRow.createCell(6).setCellValue(plans.getPLAN_END_DATE() + "");
			if (null != plans.getBENEFIT_AMOUNT()) {
				createRow.createCell(7).setCellValue(plans.getBENEFIT_AMOUNT());
			} else {
				createRow.createCell(7).setCellValue("N/A");
			}
			rowNumber++;
		}

		
		FileOutputStream fos = new FileOutputStream("Plans.xls");
		workbook.write(fos);
		fos.close();
		
		
		ServletOutputStream outputStream = response.getOutputStream();

		workbook.write(outputStream);
		workbook.close();

	}

}
