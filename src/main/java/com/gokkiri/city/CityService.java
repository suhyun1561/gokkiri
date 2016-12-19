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

	//���� ����Ʈ ����
	@Override
	public  List<CityModel> cityList() {
		return sqlSessionTemplate.selectList("city.cityList");
	}

	//���� �۾���
	@Override
	public int cityWrite(CityModel cityModel){
		return sqlSessionTemplate.insert("city.cityWrite", cityModel);
	}

	//���� ���ε�
	@Override
	public void fileupload(String originalFilename, String saveFilename) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("c_img_org", originalFilename);
		hm.put("c_img_sav", saveFilename);
		
		sqlSessionTemplate.insert("city.fileupload", hm);
	}

	//���� �� �󼼺���
	@Override
	public CityModel cityDetail(int c_no) {
		return sqlSessionTemplate.selectOne("city.cityDetail", c_no);
	}

	//���� �󼼺��� �Ҷ� �̹��� ����Ʈ ���� �ҷ�����
	@Override
	public List<CityModel> city_imgList(int c_no) {
		return sqlSessionTemplate.selectList("city.city_imgList", c_no);
	}
	

}
