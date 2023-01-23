package com.sanketscode.hellospring.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;


@Component
public class BusinessCalculationService {
	
	private DataService dataService;
	
	public BusinessCalculationService(DataService dataservice) {
		super();
		this.dataService = dataservice;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
