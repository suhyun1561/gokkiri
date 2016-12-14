package com.gokkiri.schedule;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Resource(name="scheduleService")
	private ScheduleService scheduleService;
	
	private int sch_conCount;
	
	//�����Խ��� ����Ʈ ����
	@RequestMapping("scheduleList.go")
	public ModelAndView scheduleList(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<ScheduleModel> scheduleList = scheduleService.scheduleList();
		
		mav.addObject("scheduleList", scheduleList);
		mav.setViewName("scheduleList");
		
		return mav;
	}
	
	//�����Խ��� �� �󼼺���
	@RequestMapping("scheduleDetail.go")
	public ModelAndView scheduleDetail(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		int s_no = Integer.parseInt(request.getParameter("s_no"));
		
		ScheduleModel scheduleModel = scheduleService.scheduleDetail(s_no);
		scheduleService.scheduleUpdateReadhit(s_no);
		
		mav.addObject("scheduleModel", scheduleModel);
		mav.setViewName("scheduleDetail");
		
		return mav;
	}
	
	
/*	//���� ����� �� ����
	@RequestMapping("scheduleWriteForm.go")
	public ModelAndView scheduleWriteForm(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("scheduleWriteForm");
		return mav;
	}
	
	//���� �����
	@RequestMapping("scheduleWrite.go")
	public ModelAndView scheduleWrite(HttpServletRequest request) throws Exception{
		
	}*/
}
