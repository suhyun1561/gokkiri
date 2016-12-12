package com.gokkiri.member;

import java.util.List;

public interface MemberDao {
	
	//�α���
	public MemberModel memberLogin(MemberModel mem);
	
	//�̸��ϻ̾ƿ���
	public MemberModel getMember(String email);
	
	//���̵� ã��
	public MemberModel idFindByName(MemberModel member);
	
	//��й�ȣ ã��
	public MemberModel pwFindById(MemberModel member);
	
	
	//ȸ������
	public Object insertMember(MemberModel mem);
	
	//ȸ����������
	public Object memberModify(MemberModel member);
	
	//ȸ��Ż��
	public Object memberDelete(String id);
	
	
	
}
