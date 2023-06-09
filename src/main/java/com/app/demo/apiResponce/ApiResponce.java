package com.app.demo.apiResponce;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ApiResponce {
	private String message;
	private boolean status;
	
	public ApiResponce() {
		super();
	}
	
	public ApiResponce(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
