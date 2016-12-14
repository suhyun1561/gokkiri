package com.gokkiri.schedule;

import java.util.List;
import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService implements ScheduleDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	//�����Խ��� ����Ʈ ����
	@Override
	public List<ScheduleModel> scheduleList() {
		return sqlSessionTemplate.selectList("schedule.scheduleList");
	}
	
	//�����Խ��� �� �󼼺���
	@Override
	public ScheduleModel scheduleDetail(int s_no) {
		return sqlSessionTemplate.selectOne("schedule.scheduleDetail", s_no);
	}
	
	//��ȸ�� ����
	@Override
	public int scheduleUpdateReadhit(int s_no) {
		return sqlSessionTemplate.update("schedule.scheduleUpdateReadhit", s_no);
	}
	
	//��� �� ����
	@Override
	public int sch_commCount(int s_no) {
		return sqlSessionTemplate.selectOne("schedule.sch_commCount", s_no);
	}
	

}
