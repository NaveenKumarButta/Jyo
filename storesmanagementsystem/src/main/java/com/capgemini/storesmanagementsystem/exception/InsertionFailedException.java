package com.capgemini.storesmanagementsystem.exception;

public class InsertionFailedException extends RuntimeException {

	String msg = "Please Check the Input ||| Try Again";

	public InsertionFailedException() {
		super();
	}

	public InsertionFailedException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMessage() {
		return this.msg;
	}

}
