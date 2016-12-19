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
	
	//������ ����Ʈ ����
	@RequestMapping("areaList.go")
	public ModelAndView areaList(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<AreaModel> areaList = null;
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		//�˻� ����
		if(searchKeyword != null){
			searchKeyword = new String(searchKeyword.getBytes("8859_1"), "euc-kr");
			int searchNum = Integer.parseInt(request.getParameter("searchNum"));
			a_cate = Integer.parseInt(request.getParameter("a_cate"));
			
			if(searchNum == 0)
				//���� �˻�
				areaList = areaService.areaSearch0(searchKeyword, a_cate);
			else if(searchNum == 1)
				//���� �˻�
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
	
	//������ �۾��� �� �̵�
	@RequestMapping("areaWriteForm.go")
	public ModelAndView areaWriteForm(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("areaWriteForm");
		return mav;
	}
	
	//������ �۾���
	@RequestMapping("areaWrite.go")
	public ModelAndView areaWrite(HttpServletRequest request, MultipartHttpServletRequest multipartHttpServletRequest, AreaModel areaModel) throws Exception{
		
		//�ٹٲ�
		String a_con = areaModel.getA_con().replaceAll("\r\n", "<br/>");
		areaModel.setA_con(a_con);
		
		//÷�������� ������ �۾��� ���
		areaService.areaWrite(areaModel);
		
		//÷������ ��ϡ���
		
		File dir = new File(uploadPath);		
		//uploadPath ��ο� ������ ������ ���� ����
		if(!dir.isDirectory()){
			dir.mkdir();
		}
	
		
		//�ֿܼ� uploadPath ���
		System.out.println("uploadPath : "+ uploadPath);
		
		//�Ѿ�� ������ ����Ʈ�� ����
		List<MultipartFile> mf = multipartHttpServletRequest.getFiles("file");
		if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")){	//÷�������� ������
		
		}else{	//÷�������� ������
			
			for(int i=0; i<mf.size(); i++){
				//���� �ߺ��� ó��
				String genId = UUID.randomUUID().toString();
				//���� ���ϸ�
				String originalFilename = mf.get(i).getOriginalFilename();
				//����Ǵ� ���� �̸�
				String saveFilename = genId + "." + FilenameUtils.getExtension(originalFilename);
				//����� ���ϰ�� + ���� �̸�
				String savePath = uploadPath + saveFilename;
				//���� ����
				mf.get(i).transferTo(new File(savePath));
				
				//����Ʈ���� ������ ù��° �̹����� �ε��� �ο�
				if(i==0){
				a_img_index = 1;
				}
				
				areaService.fileupload(originalFilename, saveFilename, a_img_index);
			}
			
		}
	
		//�۾��� �󼼺���� �����ϱ�
		return new ModelAndView("redirect:areaList.go");
	}
	
	//������ �� �󼼺���
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
