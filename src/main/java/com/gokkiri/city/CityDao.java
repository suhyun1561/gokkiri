package com.gokkiri.city;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface CityDao {
	
	//������ ����Ʈ ����
	public List<CityModel> cityList();
	
	//������ �۾���
	public int cityWrite(CityModel cityModel);
	
	//���� ���ε�
	public void fileupload(String originalfileName, String saveFilename);

	//������ �󼼺���
	public CityModel cityDetail(int c_no);
	
	//������ �󼼺��� �Ҷ� �̹��� ����Ʈ�� �ҷ�����
	public List<CityModel> city_imgList(int c_no);
	
}
