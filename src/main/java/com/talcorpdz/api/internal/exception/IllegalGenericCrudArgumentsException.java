package com.talcorpdz.api.internal.exception;

import java.util.LinkedHashMap;

public class IllegalGenericCrudArgumentsException extends Exception {


	private static final long serialVersionUID = 687645134981L;
		
	
	private String className;
	private String toStringOfT;
	private String message;

	LinkedHashMap<String, Object> body = new LinkedHashMap<>();

	public IllegalGenericCrudArgumentsException(String className,String toStringOfT,String message) {
		this.className = className;
		this.toStringOfT = toStringOfT;
		this.message = message;
	}
	
	public IllegalGenericCrudArgumentsException add(String key, Object value ) {
		body.put(key, value);	
		return this;
	}
	
	public LinkedHashMap<String, Object> getBody(){
		body.put("className", this.className);
		body.put("values", this.toStringOfT);
		body.put("exceptionMessage", this.message);
		return body ;
	}
	
}
