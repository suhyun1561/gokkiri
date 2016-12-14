package com.gokkiri.schedule;

import java.util.Date;

public class ScheduleModel {
	
	private String m_email;			//ȸ�� �̸���
	private int a_no;				//������ ��ȣ
	
	//SCH ���̺�
	private int s_no;				//���� ��ȣ
	private Date s_date;			//���� ���� ��¥
	private Date s_start_date;		//���� ���� ��¥
	private Date s_end_date;		//���� �� ��¥
	private int s_like;				//���� ��õ
	private int s_hit;				//���� ��ȸ��
	private int s_private;			//���� ���� ����
	private String s_together;		//���� ������ ȸ��
	private String s_name;			//���� �̸�
	
	//SCH_DAY ���̺�
	private int s_day_no;			//�Ϻ� ���� ��ȣ
	private int s_day_index;		//�Ϻ� ����
	
	//SCH_DETAIL ���̺�
	private String s_detail_memo;	//���� ��¥�� ���� �޸�
	private int s_detail_index;		//������ ����
	private String s_detail_cost;	//���� ��¥�� ���� ����
	
	//SCH_CO ���̺�
	private int s_co_no;			//���� ��� ��ȣ
	private String s_co_con;		//���� ��� ����
	private Date s_co_date;			//���� ��� ��¥
	
	
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public int getA_no() {
		return a_no;
	}
	public void setA_no(int a_no) {
		this.a_no = a_no;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getS_start_date() {
		return s_start_date;
	}
	public void setS_start_date(Date s_start_date) {
		this.s_start_date = s_start_date;
	}
	public Date getS_end_date() {
		return s_end_date;
	}
	public void setS_end_date(Date s_end_date) {
		this.s_end_date = s_end_date;
	}
	public int getS_like() {
		return s_like;
	}
	public void setS_like(int s_like) {
		this.s_like = s_like;
	}
	public int getS_hit() {
		return s_hit;
	}
	public void setS_hit(int s_hit) {
		this.s_hit = s_hit;
	}
	public int getS_private() {
		return s_private;
	}
	public void setS_private(int s_private) {
		this.s_private = s_private;
	}
	public String getS_together() {
		return s_together;
	}
	public void setS_together(String s_together) {
		this.s_together = s_together;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_day_no() {
		return s_day_no;
	}
	public void setS_day_no(int s_day_no) {
		this.s_day_no = s_day_no;
	}
	public int getS_day_index() {
		return s_day_index;
	}
	public void setS_day_index(int s_day_index) {
		this.s_day_index = s_day_index;
	}
	public String getS_detail_memo() {
		return s_detail_memo;
	}
	public void setS_detail_memo(String s_detail_memo) {
		this.s_detail_memo = s_detail_memo;
	}
	public int getS_detail_index() {
		return s_detail_index;
	}
	public void setS_detail_index(int s_detail_index) {
		this.s_detail_index = s_detail_index;
	}
	public String getS_detail_cost() {
		return s_detail_cost;
	}
	public void setS_detail_cost(String s_detail_cost) {
		this.s_detail_cost = s_detail_cost;
	}
	public int getS_co_no() {
		return s_co_no;
	}
	public void setS_co_no(int s_co_no) {
		this.s_co_no = s_co_no;
	}
	public String getS_co_con() {
		return s_co_con;
	}
	public void setS_co_con(String s_co_con) {
		this.s_co_con = s_co_con;
	}
	public Date getS_co_date() {
		return s_co_date;
	}
	public void setS_co_date(Date s_co_date) {
		this.s_co_date = s_co_date;
	}

}
