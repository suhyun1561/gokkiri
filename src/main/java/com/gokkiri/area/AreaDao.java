package com.gokkiri.area;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface AreaDao {
	
	//여행지 리스트 보기
	public List<AreaModel> areaList(int a_cate);
	
	//여행지 리스트 - 제목 검색
	public List<AreaModel> areaSearch0(String searchKeyword, int a_cate);
	
	//여행지 리스트 - 내용 검색
	public List<AreaModel> areaSearch1(String searchKeyword, int a_cate);
	
	//여행지 글쓰기
	public int areaWrite(AreaModel areaModel);
	
	//파일 업로드
	public void fileupload(String originalfileName, String saveFilename, int a_img_index);

	//여행지 상세보기
	public AreaModel areaDetail(int a_no);
	
	//여행지 상세보기 할때 이미지 리스트도 불러오기
	public List<AreaModel> area_imgList(int a_no);
	
	//여행지 상세보기 할때 이미지 갤러리의 메인 이미지 불러오기
	public AreaModel main_img(int a_no);
	
}
