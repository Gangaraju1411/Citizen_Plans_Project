package com.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.insurance.service.ReportServiceImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		 ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		 ReportServiceImpl bean = run.getBean(ReportServiceImpl.class);
		 boolean exportExcel = bean.exportExcel();
		 System.out.println(exportExcel);
		
	
	}

}
