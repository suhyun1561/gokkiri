package com.gokkiri.city;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class CityService implements CityDao{
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	//도시 리스트 보기
	@Override
	public  List<CityModel> cityList() {
		return sqlSessionTemplate.selectList("city.cityList");
	}

	//도시 글쓰기
	@Override
	public int cityWrite(CityModel cityModel){
		return sqlSessionTemplate.insert("city.cityWrite", cityModel);
	}

	//파일 업로드
	@Override
	public void fileupload(String originalFilename, String saveFilename) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("c_img_org", originalFilename);
		hm.put("c_img_sav", saveFilename);
		
		sqlSessionTemplate.insert("city.fileupload", hm);
	}

	//도시 글 상세보기
	@Override
	public CityModel cityDetail(int c_no) {
		return sqlSessionTemplate.selectOne("city.cityDetail", c_no);
	}

	//도시 상세보기 할때 이미지 리스트 같이 불러오기
	@Override
	public List<CityModel> city_imgList(int c_no) {
		return sqlSessionTemplate.selectList("city.city_imgList", c_no);
	}
	

}
