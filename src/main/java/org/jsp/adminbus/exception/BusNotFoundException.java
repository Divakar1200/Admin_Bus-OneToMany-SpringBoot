package org.jsp.adminbus.exception;

public class BusNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Bus Not Found";
	}
}
