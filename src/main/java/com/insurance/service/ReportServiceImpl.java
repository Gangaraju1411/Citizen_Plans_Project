package com.insurance.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.insurance.entity.Citizen;
import com.insurance.repo.CitizenPlanRepository;
import com.insurance.request.SearchRequest;
import com.insurance.util.ExcelGenerator;
import com.insurance.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public List<String> getPlanNames() {
		List<String> planNames = repo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = repo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<Citizen> search(SearchRequest request)  {
		Citizen entity = new Citizen();

		if (null != request.getPlan_Name() && !"".equals(request.getPlan_Name())) {
			entity.setPLAN_NAME(request.getPlan_Name());
			System.out.println(entity.getPLAN_NAME());

		}
		if (null != request.getPlan_Status() && !"".equals(request.getPlan_Status())) {
			entity.setPLAN_STATUS(request.getPlan_Status());
			System.out.println(entity.getPLAN_STATUS());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGENDER(request.getGender());

		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// converting string to localdate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPLAN_START_DATE(localDate);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String startDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// converting string to localdate
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPLAN_START_DATE(localDate);
		}
		return  repo.findAll(Example.of(entity));

		

		
	}

	@Override
	public boolean exportExcel() {

		List<Citizen> list = repo.findAll();

		return false;
	}

	@Override
	public boolean exportPdf() {

		return false;
	}

}
