package com.lrn.springrestex_1.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String details;
	private String message;

	public ErrorDetails(Date timestamp, String details, String message) {
		super();
		this.timestamp = timestamp;
		this.details = details;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getDetails() {
		return details;
	}

	public String getMessage() {
		return message;
	}

}
