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
	
	//일정게시판 리스트 보기
	@RequestMapping("scheduleList.go")
	public ModelAndView scheduleList(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<ScheduleModel> scheduleList = scheduleService.scheduleList();
		
		mav.addObject("scheduleList", scheduleList);
		mav.setViewName("scheduleList");
		
		return mav;
	}
	
	//일정게시판 글 상세보기
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
	
	
/*	//일정 만들기 폼 보기
	@RequestMapping("scheduleWriteForm.go")
	public ModelAndView scheduleWriteForm(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("scheduleWriteForm");
		return mav;
	}
	
	//일정 만들기
	@RequestMapping("scheduleWrite.go")
	public ModelAndView scheduleWrite(HttpServletRequest request) throws Exception{
		
	}*/
}
