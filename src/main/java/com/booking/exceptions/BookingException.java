package com.booking.exceptions;

public class BookingException extends Exception {

	private static final long serialVersionUID = 1L;
	public static final String DEFAULT_ERROR_CODE = "";
	private final String msgErrorCode;

	public BookingException() {
		super();
		this.msgErrorCode = DEFAULT_ERROR_CODE;
	}

	public BookingException(final String errorMsg) {
		super(errorMsg);
		this.msgErrorCode = DEFAULT_ERROR_CODE;
	}

	public BookingException(final String errorCode, final String errorMsg) {
		super(errorMsg);
		this.msgErrorCode = errorCode;
	}

	public BookingException(Throwable cause) {
		super(cause);
		this.msgErrorCode = DEFAULT_ERROR_CODE;
	}

	public BookingException(final String errorMsg, final Throwable cause) {
		super(errorMsg, cause);
		this.msgErrorCode = DEFAULT_ERROR_CODE;
	}

	public BookingException(final String errorCode, final String errorMsg, final Throwable cause) {
		super(errorMsg, cause);
		this.msgErrorCode = errorCode;
	}

	public String getErrorCode() {
		return msgErrorCode;
	}
}
