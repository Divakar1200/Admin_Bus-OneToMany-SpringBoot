package org.jsp.adminbus.exception;

public class AdminNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Admin Not Found";
	}
}
