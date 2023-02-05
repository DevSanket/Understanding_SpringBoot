package com.sanketscode.rest.webservices.restfulwebservices.versioning;

public class Name {
	private String firstName;
	private String SecondName;
	public Name(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		SecondName = secondName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	@Override
	public String toString() {
		return "PersonV2 [firstName=" + firstName + ", SecondName=" + SecondName + "]";
	}

}
