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

	//������ ����Ʈ ����
	@Override
	public List<AreaModel> areaList(int a_cate) {

		return sqlSessionTemplate.selectList("area.areaList", a_cate);
	}
	
	//������ ����Ʈ - ���� �˻�
	@Override
	public List<AreaModel> areaSearch0(String searchKeyword, int a_cate) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("searchKeyword", "%" + searchKeyword + "%");
		hm.put("a_cate", a_cate);
		
		return sqlSessionTemplate.selectList("area.areaSearch0", hm);
		
	}

	//������ ����Ʈ - ���� �˻�
	@Override
	public List<AreaModel> areaSearch1(String searchKeyword, int a_cate) {
		
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("searchKeyword", "%" + searchKeyword + "%");
		hm.put("a_cate", a_cate);
		
		return sqlSessionTemplate.selectList("area.areaSearch1", hm);
		
	}

	//������ �۾���
	@Override
	public int areaWrite(AreaModel areaModel){
		return sqlSessionTemplate.insert("area.areaWrite", areaModel);
	}

	//���� ���ε�
	@Override
	public void fileupload(String originalFilename, String saveFilename, int a_img_index) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("a_img_org", originalFilename);
		hm.put("a_img_sav", saveFilename);
		hm.put("a_img_index", a_img_index);
		
		sqlSessionTemplate.insert("area.fileupload", hm);
	}

	//������ �� �󼼺���
	@Override
	public AreaModel areaDetail(int a_no) {
		return sqlSessionTemplate.selectOne("area.areaDetail", a_no);
	}

	//������ �󼼺��� �Ҷ� �̹��� ����Ʈ ���� �ҷ�����
	@Override
	public List<AreaModel> area_imgList(int a_no) {
		return sqlSessionTemplate.selectList("area.area_imgList", a_no);
	}

	//������ �󼼺��� �Ҷ� �̹��� �������� ���� �̹��� �ҷ�����
	@Override
	public AreaModel main_img(int a_no) {
		return sqlSessionTemplate.selectOne("area.main_img", a_no);
	}
	

}
