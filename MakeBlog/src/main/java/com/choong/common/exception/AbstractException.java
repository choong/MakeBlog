package com.choong.common.exception;

import com.choong.common.vo.ErrCodable;

public abstract class AbstractException extends Exception {
	private String code;
	private String message;

	private AbstractException(String message) {
		super(message);
		this.message = message;
	}

	protected AbstractException(String code, String message) {
		this(message);
		this.code = code;
	}

	private AbstractException(String message, Throwable err) {
		super(message, err);
		this.message = message;
	}

	protected AbstractException(String code, String message, Throwable err) {
		this(message, err);
		this.code = code;
	}

	protected AbstractException(ErrCodable errCodable, String... args) {
		this(errCodable.getErrorCode(), errCodable.getMessage(args));
	}

	protected AbstractException(ErrCodable errCodable) {
		this(errCodable.getErrorCode());
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
