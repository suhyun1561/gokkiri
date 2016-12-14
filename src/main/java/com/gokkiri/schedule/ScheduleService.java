package com.gokkiri.schedule;

import java.util.List;
import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.stereotype.Service;

@Service
public class ScheduleService implements ScheduleDao{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	//일정게시판 리스트 보기
	@Override
	public List<ScheduleModel> scheduleList() {
		return sqlSessionTemplate.selectList("schedule.scheduleList");
	}
	
	//일정게시판 글 상세보기
	@Override
	public ScheduleModel scheduleDetail(int s_no) {
		return sqlSessionTemplate.selectOne("schedule.scheduleDetail", s_no);
	}
	
	//조회수 증가
	@Override
	public int scheduleUpdateReadhit(int s_no) {
		return sqlSessionTemplate.update("schedule.scheduleUpdateReadhit", s_no);
	}
	
	//댓글 총 개수
	@Override
	public int sch_commCount(int s_no) {
		return sqlSessionTemplate.selectOne("schedule.sch_commCount", s_no);
	}
	

}
