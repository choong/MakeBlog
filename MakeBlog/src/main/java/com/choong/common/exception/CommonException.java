package com.choong.common.exception;

import com.choong.common.vo.ErrCodable;

public class CommonException extends AbstractException {

	public CommonException(ErrCodable errCodable) {
		super(errCodable);
	}
	
	public CommonException(String code, String message) {
		super(code, message);
	}

	public CommonException(String code, String message, Throwable err) {
		super(code, message, err);
	}

	public CommonException(ErrCodable errCodable, String... args) {
		super(errCodable, args);
	}

}
