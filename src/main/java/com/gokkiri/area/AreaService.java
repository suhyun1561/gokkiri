package com.gokkiri.area;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class AreaService implements AreaDao{
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	//여행지 리스트 보기
	@Override
	public List<AreaModel> areaList() {
		return sqlSessionTemplate.selectList("area.areaList");
	}

	//여행지 글쓰기
	@Override
	public int areaWrite(AreaModel areaModel){
		return sqlSessionTemplate.insert("area.areaWrite", areaModel);
	}

	//파일 업로드
	@Override
	public void fileupload(String originalFilename, String saveFilename) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("a_img_org", originalFilename);
		hm.put("a_img_sav", saveFilename);
		
		sqlSessionTemplate.insert("area.fileupload", hm);
	}

	//여행지 글 상세보기
	@Override
	public AreaModel areaDetail(int a_no) {
		return sqlSessionTemplate.selectOne("area.areaDetail", a_no);
	}

	//여행지 상세보기 할때 이미지 리스트 같이 불러오기
	@Override
	public List<AreaModel> area_imgList(int a_no) {
		return sqlSessionTemplate.selectList("area.area_imgList", a_no);
	}
	

}
