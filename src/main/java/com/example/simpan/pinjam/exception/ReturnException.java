package com.example.simpan.pinjam.exception;

public class ReturnException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ReturnException() {
		super();
	}

	public ReturnException(String message) {
		super(message);
	}

	public ReturnException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
