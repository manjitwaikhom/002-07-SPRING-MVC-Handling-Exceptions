package com.spring.mvc;

public class EmployeeNotFoundException extends RuntimeException {

	String eid;

	public EmployeeNotFoundException(String eid) {
		this.eid = eid;
	}

	@Override
	public String toString() {
		String msg = "Employee Not Found";
		if (eid != null) {
			msg = "Employee ID: " + eid + " not in records";
		}
		return msg;
	}

	public String getMessage() {
		return toString();
	}
}
