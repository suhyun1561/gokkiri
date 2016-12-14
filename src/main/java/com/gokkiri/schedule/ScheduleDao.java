package com.gokkiri.schedule;

import java.util.List;
import com.gokkiri.schedule.ScheduleModel;

public interface ScheduleDao {
	
	//�����Խ��� ����Ʈ ����
	public List<ScheduleModel> scheduleList();
	
	//�����Խ��� �� �󼼺���
	public ScheduleModel scheduleDetail(int s_no);
	
	//��ȸ�� ����
	public int scheduleUpdateReadhit(int s_no);
	
	//��� �� ����
	public int sch_commCount(int s_no);

}
