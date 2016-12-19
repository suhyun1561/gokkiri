package com.gokkiri.area;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface AreaDao {
	
	//������ ����Ʈ ����
	public List<AreaModel> areaList(int a_cate);
	
	//������ ����Ʈ - ���� �˻�
	public List<AreaModel> areaSearch0(String searchKeyword, int a_cate);
	
	//������ ����Ʈ - ���� �˻�
	public List<AreaModel> areaSearch1(String searchKeyword, int a_cate);
	
	//������ �۾���
	public int areaWrite(AreaModel areaModel);
	
	//���� ���ε�
	public void fileupload(String originalfileName, String saveFilename, int a_img_index);

	//������ �󼼺���
	public AreaModel areaDetail(int a_no);
	
	//������ �󼼺��� �Ҷ� �̹��� ����Ʈ�� �ҷ�����
	public List<AreaModel> area_imgList(int a_no);
	
	//������ �󼼺��� �Ҷ� �̹��� �������� ���� �̹��� �ҷ�����
	public AreaModel main_img(int a_no);
	
}
