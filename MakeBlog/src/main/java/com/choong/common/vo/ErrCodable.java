package com.choong.common.vo;

public interface ErrCodable {

	public String getErrorCode();
	public String getMessage(String... args);
}
