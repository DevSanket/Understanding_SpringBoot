package com.sanketscode.hellospring.examples.c1;

import org.springframework.stereotype.Component;

@Component
public interface DataService {

	int[] retrieveData();
}
