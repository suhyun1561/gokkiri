package com.gokkiri.place;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/placeboard")
public class PlaceController {
	
	@Resource(name="placeService")
	private PlaceService placeService;
	
	
}
