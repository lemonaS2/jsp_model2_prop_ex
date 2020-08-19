package org.smart.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GuestBook {
	private String gid;
	private String content;
	private String reg;
	
	public GuestBook() {
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy.MM.dd(kk:mm)");
		reg = sdf.format(new Date());
	}

	public GuestBook(String content) {
		this();
		setContent(content);
	}

	public GuestBook(String gid, String content, String reg) {
		this.gid = gid;
		this.content = content;
		this.reg = reg;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}
	
	
}
