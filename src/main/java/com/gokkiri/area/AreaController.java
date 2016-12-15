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
	
	//������ ����Ʈ ����
	@RequestMapping("areaList.go")
	public ModelAndView areaList(HttpServletRequest request) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		List<AreaModel> areaList = areaService.areaList();
		
		mav.addObject("areaList", areaList);
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
				
				areaService.fileupload(originalFilename, saveFilename);
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
		
		mav.addObject("areaModel", areaModel);
		mav.addObject("area_imgList", area_imgList);
		mav.setViewName("areaDetail");
		
		return mav;
	}
	
	
  
}
