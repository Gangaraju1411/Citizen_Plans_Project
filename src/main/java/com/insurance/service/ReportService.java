package com.insurance.service;

import java.util.List;

import com.insurance.entity.Citizen;
import com.insurance.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<Citizen> search (SearchRequest request)  ;
	public boolean exportExcel();
	public boolean exportPdf();


}
