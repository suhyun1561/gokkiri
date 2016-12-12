package com.gokkiri.member;

import java.util.List;

public interface MemberDao {
	
	//로그인
	public MemberModel memberLogin(MemberModel mem);
	
	//이메일뽑아오기
	public MemberModel getMember(String email);
	
	//아이디 찾기
	public MemberModel idFindByName(MemberModel member);
	
	//비밀번호 찾기
	public MemberModel pwFindById(MemberModel member);
	
	
	//회원가입
	public Object insertMember(MemberModel mem);
	
	//회원정보수정
	public Object memberModify(MemberModel member);
	
	//회원탈퇴
	public Object memberDelete(String id);
	
	
	
}
