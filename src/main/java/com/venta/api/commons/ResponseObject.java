package com.venta.api.commons;

import java.io.Serializable;

public class ResponseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7058637666412210409L;

	private Object data;
	private int httpStatus;
	private String message;

	public ResponseObject(Object data, int httpStatus, String message) {
		this.data = data;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
