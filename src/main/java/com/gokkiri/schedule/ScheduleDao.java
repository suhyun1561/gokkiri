package com.gokkiri.schedule;

import java.util.List;
import com.gokkiri.schedule.ScheduleModel;

public interface ScheduleDao {
	
	//일정게시판 리스트 보기
	public List<ScheduleModel> scheduleList();
	
	//일정게시판 글 상세보기
	public ScheduleModel scheduleDetail(int s_no);
	
	//조회수 증가
	public int scheduleUpdateReadhit(int s_no);
	
	//댓글 총 개수
	public int sch_commCount(int s_no);

}
