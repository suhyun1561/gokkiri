package com.gokkiri.city;

import java.util.Date;
import java.io.File;

public class CityModel {
	
	private int c_no;			//���� ��ȣ
	private String c_name;		//���� �̸�
	private String c_con;		//���� ����
	private String c_addr;		//���� �ּ�
	private String c_like;		//���� ��ȣ��
	private int state_no;		//�� ��ȣ
		
	//AREA_IMG ���̺�
	private int c_img_no;		//���� ���� ��ȣ
	private String c_img_org;	//���� ���� ���� �̸�
	private String c_img_sav;	//���� ���� ���� �̸�
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_con() {
		return c_con;
	}
	public void setC_con(String c_con) {
		this.c_con = c_con;
	}
	public String getC_addr() {
		return c_addr;
	}
	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}
	public String getC_like() {
		return c_like;
	}
	public void setC_like(String c_like) {
		this.c_like = c_like;
	}
	public int getState_no() {
		return state_no;
	}
	public void setState_no(int state_no) {
		this.state_no = state_no;
	}
	public int getC_img_no() {
		return c_img_no;
	}
	public void setC_img_no(int c_img_no) {
		this.c_img_no = c_img_no;
	}
	public String getC_img_org() {
		return c_img_org;
	}
	public void setC_img_org(String c_img_org) {
		this.c_img_org = c_img_org;
	}
	public String getC_img_sav() {
		return c_img_sav;
	}
	public void setC_img_sav(String c_img_sav) {
		this.c_img_sav = c_img_sav;
	}
	

}
