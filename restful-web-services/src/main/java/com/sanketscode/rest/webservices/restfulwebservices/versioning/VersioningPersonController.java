package com.sanketscode.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	
	//versioning based on URI
	@GetMapping(path="/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charli");
	}
	
	@GetMapping(path="/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob","Charli"));
	}
	
	
	//Versioning based on params
	@GetMapping(path="/person",params ="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charli");
	}
	
	@GetMapping(path="/person",params ="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParameter() {
		return new PersonV2(new Name("Bob","Charli"));
	}
	
	//versioning based on header
	@GetMapping(path="/person/header",headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charli");
	}
	
	@GetMapping(path="/person/header",headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader() {
		return new PersonV2(new Name("Bob","Charli"));
	}
	
	//versioning based on media
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v1+json")
	public PersonV1 acceptHeader() {
		return new PersonV1("Bob Charli");
	}
	
	@GetMapping(path="/person/accept",produces="application/vnd.company.app-v2+json")
	public PersonV2 getSecondHeader() {
		return new PersonV2(new Name("Bob","Charli"));
	}

}
