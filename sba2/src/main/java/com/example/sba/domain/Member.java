package com.example.sba.domain;

import java.util.Date;

/*
CREATE TABLE MEMBERS(
		MNO INTEGER NOT NULL COMMENT 'ȸ���Ϸù�ȣ',
		EMAIL VARCHAR(40) NOT NULL COMMENT '�̸���',
		PWD VARCHAR(40) NOT NULL COMMENT '��ȣ',
		MNAME VARCHAR(50) NOT NUULL COMMENT '�̸�',
		CRE_DATE DATETIME NOT NULL COMMENT '������',
		MOD_DATE DATETIME NOT NULL COMMENT '��������ȣ������'
		)
*/


public class Member {
	private int mno;
	private String mname;
	private String email;
	private String pwd;
	private Date cre_date;
	private Date mod_date;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	
	
}
