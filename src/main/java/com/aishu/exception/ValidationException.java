package com.aishu.exception;

public class ValidationException extends Exception {

	/**
	 * exception
	 */
	private static final long serialVersionUID = 1L;

	public ValidationException(String message, Throwable cause) {
		super(message, cause);

	}

	public ValidationException(String message) {
		super(message);

	}

}
