package com.gokkiri.city;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface CityDao {
	
	//여행지 리스트 보기
	public List<CityModel> cityList();
	
	//여행지 글쓰기
	public int cityWrite(CityModel cityModel);
	
	//파일 업로드
	public void fileupload(String originalfileName, String saveFilename);

	//여행지 상세보기
	public CityModel cityDetail(int c_no);
	
	//여행지 상세보기 할때 이미지 리스트도 불러오기
	public List<CityModel> city_imgList(int c_no);
	
}
