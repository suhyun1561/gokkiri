package com.gokkiri.member;

import java.util.Date;

public class MemberModel {
	
	private String m_email;
	private String m_pw;
	private String m_name;
	private Date m_date;
	private int m_admin;
	
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getM_date() {
		return m_date;
	}
	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}
	public int getM_admin() {
		return m_admin;
	}
	public void setM_admin(int m_admin) {
		this.m_admin = m_admin;
	}
	
	
	
}
