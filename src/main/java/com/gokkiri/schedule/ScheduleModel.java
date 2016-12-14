package com.gokkiri.schedule;

import java.util.Date;

public class ScheduleModel {
	
	private String m_email;			//회원 이메일
	private int a_no;				//여행지 번호
	
	//SCH 테이블
	private int s_no;				//일정 번호
	private Date s_date;			//일정 생성 날짜
	private Date s_start_date;		//일정 시작 날짜
	private Date s_end_date;		//일정 끝 날짜
	private int s_like;				//일정 추천
	private int s_hit;				//일정 조회수
	private int s_private;			//공개 설정 여부
	private String s_together;		//일정 공유할 회원
	private String s_name;			//일정 이름
	
	//SCH_DAY 테이블
	private int s_day_no;			//일별 일정 번호
	private int s_day_index;		//일별 일일
	
	//SCH_DETAIL 테이블
	private String s_detail_memo;	//일정 날짜별 세부 메모
	private int s_detail_index;		//여행지 순서
	private String s_detail_cost;	//일정 날짜별 세부 예산
	
	//SCH_CO 테이블
	private int s_co_no;			//일정 댓글 번호
	private String s_co_con;		//일정 댓글 내용
	private Date s_co_date;			//일정 댓글 날짜
	
	
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
