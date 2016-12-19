package com.gokkiri.area;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FilenameUtils;

@Controller
@RequestMapping("/area")
public class AreaController { 
	
	@Resource(name="areaService")
	private AreaService areaService;
	
	private static final String uploadPath = "C:\\Users\\ChoiSuHyun\\workspace\\git\\Gokkiri\\src\\main\\webapp\\resources\\area_img\\";
	int totalCount;
	int a_cate;
	int a_img_index;
	
	//여행지 리스트 보기
	@RequestMapping("areaList.go")
	public ModelAndView areaList(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<AreaModel> areaList = null;
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		//검색 로직
		if(searchKeyword != null){
			searchKeyword = new String(searchKeyword.getBytes("8859_1"), "euc-kr");
			int searchNum = Integer.parseInt(request.getParameter("searchNum"));
			a_cate = Integer.parseInt(request.getParameter("a_cate"));
			
			if(searchNum == 0)
				//제목 검색
				areaList = areaService.areaSearch0(searchKeyword, a_cate);
			else if(searchNum == 1)
				//내용 검색
				areaList = areaService.areaSearch1(searchKeyword, a_cate);
			
			totalCount = areaList.size();
			
			mav.addObject("areaList", areaList);
			mav.addObject("totalCount", totalCount);
			mav.addObject("searchKeyword", searchKeyword);
			mav.setViewName("areaList");
			
			return mav;
		}
		
		a_cate = Integer.parseInt(request.getParameter("a_cate"));
		
		areaList = areaService.areaList(a_cate);

		totalCount = areaList.size();
		
		mav.addObject("areaList", areaList);
		mav.addObject("totalCount", totalCount);
		mav.setViewName("areaList");
		
		return mav;
	}
	
	//여행지 글쓰기 폼 이동
	@RequestMapping("areaWriteForm.go")
	public ModelAndView areaWriteForm(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("areaWriteForm");
		return mav;
	}
	
	//여행지 글쓰기
	@RequestMapping("areaWrite.go")
	public ModelAndView areaWrite(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest, AreaModel areaModel) throws Exception{
		
		//줄바꿈
		String a_con = areaModel.getA_con().replaceAll("\r\n", "<br/>");
		areaModel.setA_con(a_con);
		
		//첨부파일을 제외한 글쓰기 등록
		areaService.areaWrite(areaModel);
		
		//첨부파일 등록↓↓↓
		
		File dir = new File(uploadPath);		
		//uploadPath 경로에 폴더가 없으면 새로 생성
		if(!dir.isDirectory()){
			dir.mkdir();
		}
	
		
		//콘솔에 uploadPath 출력
		System.out.println("uploadPath : "+ uploadPath);
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = multipartHttpServletRequest.getFiles("file");
		if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")){	//첨부파일이 없으면
		
		}else{	//첨부파일이 있으면
			
			for(int i=0; i<mf.size(); i++){
				//파일 중복명 처리
				String genId = UUID.randomUUID().toString();
				//본래 파일명
				String originalFilename = mf.get(i).getOriginalFilename();
				//저장되는 파일 이름
				String saveFilename = genId + "." + FilenameUtils.getExtension(originalFilename);
				//저장될 파일경로 + 파일 이름
				String savePath = uploadPath + saveFilename;
				//파일 저장
				mf.get(i).transferTo(new File(savePath));
				
				//리스트에서 보여줄 첫번째 이미지에 인덱스 부여
				if(i==0){
				a_img_index = 1;
				}
				
				areaService.fileupload(originalFilename, saveFilename, a_img_index);
			}
			
		}
	
		//글쓰면 상세보기로 수정하기
		return new ModelAndView("redirect:areaList.go");
	}
	
	//여행지 글 상세보기
	@RequestMapping("areaDetail.go")
	public ModelAndView areaDetail(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		int a_no = Integer.parseInt(request.getParameter("a_no"));
		
		AreaModel areaModel = areaService.areaDetail(a_no);
		List<AreaModel> area_imgList = areaService.area_imgList(a_no);
		AreaModel main_img = areaService.main_img(a_no);
		
		mav.addObject("areaModel", areaModel);
		mav.addObject("area_imgList", area_imgList);
		mav.addObject("main_img", main_img);
		mav.setViewName("areaDetail");
		
		return mav;
	}
	
	
  
}
