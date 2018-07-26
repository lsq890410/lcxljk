package com.lc.xljk.vo.smscheck;

public class SmscheckVO {
	private String smscheckid ;
	private String smscheckcode ;
	private String createtime;
	private String disabletime;
	private String telno;
	public String getSmscheckid() {
		return smscheckid;
	}
	public void setSmscheckid(String smscheckid) {
		this.smscheckid = smscheckid;
	}
	public String getSmscheckcode() {
		return smscheckcode;
	}
	public void setSmscheckcode(String smscheckcode) {
		this.smscheckcode = smscheckcode;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDisabletime() {
		return disabletime;
	}
	public void setDisabletime(String disabletime) {
		this.disabletime = disabletime;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
}
