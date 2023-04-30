package com.app.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	String resorceName;
	String fieldName;
	long fieldValues;
	public ResourceNotFoundException(String resorceName, String fieldName, long fieldValues) {
		super(String.format(" %s Not found with %s:%s" , resorceName,fieldName,fieldValues));
		
		this.resorceName = resorceName;
		this.fieldName = fieldName;
		this.fieldValues = fieldValues;
	}
	public String getResorceName() {
		return resorceName;
	}
	public void setResorceName(String resorceName) {
		this.resorceName = resorceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValues() {
		return fieldValues;
	}
	public void setFieldValues(long fieldValues) {
		this.fieldValues = fieldValues;
	}
	
}
