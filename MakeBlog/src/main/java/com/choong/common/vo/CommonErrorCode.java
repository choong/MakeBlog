package com.choong.common.vo;

import com.choong.common.util.ErrorCodeUtil;

public enum CommonErrorCode implements ErrCodable {
	
	SUCCESS("0", ""),
	
	ERR_0001("ERR_0001", "%1은(는) 필수 입력 항목입니다."),
	
	ERR_0002("ERR_0002", "%1이(가) 존재하지 않습니다."),
	
	ERR_0003("ERR_0003", "%1이(가) 불일치합니다."),
	
	ERR_0004("ERR_0004", "서비스가 불안정합니다.");

	private String errorCode;
	private String message;
	
	@Override
	public String getErrorCode() {
		
		return errorCode;
	}

	@Override
	public String getMessage(String... args) {
		
		return ErrorCodeUtil.parseMessage(this.message, args);

	}

	CommonErrorCode(String errCode, String msg){
		errorCode = errCode;
		message = msg;
	}
}
