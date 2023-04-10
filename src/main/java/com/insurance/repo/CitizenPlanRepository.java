package com.insurance.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.insurance.entity.Citizen;
import com.insurance.request.SearchRequest;


@Repository

public interface CitizenPlanRepository  extends JpaRepository<Citizen, Integer>{
	
	
	@Query("select distinct (PLAN_NAME) from Citizen")
	public List<String> getPlanNames();
	

	@Query("select distinct (PLAN_STATUS) from Citizen")
	public List<String> getPlanStatus();
	
		
		
		
		
	

}
