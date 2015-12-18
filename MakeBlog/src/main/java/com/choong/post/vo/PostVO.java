package com.choong.post.vo;

import org.apache.ibatis.type.Alias;

import com.choong.common.vo.BaseVO;

@Alias("postvo")
public class PostVO extends BaseVO {

	private long id;
	
	private String contents;
	
	private int memberNo;

	/**
	 * create date or update date
	 */
	private String date;
	
	private int readCount;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
}
