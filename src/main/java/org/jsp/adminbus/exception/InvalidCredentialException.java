package org.jsp.adminbus.exception;

public class InvalidCredentialException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid Id / Phone / email or password";
	}
}
