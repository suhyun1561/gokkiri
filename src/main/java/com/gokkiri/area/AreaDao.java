package com.gokkiri.area;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface AreaDao {
	
	//������ ����Ʈ ����
	public List<AreaModel> areaList();
	
	//������ �۾���
	public int areaWrite(AreaModel areaModel);
	
	//���� ���ε�
	public void fileupload(String originalfileName, String saveFilename);

	//������ �󼼺���
	public AreaModel areaDetail(int a_no);
	
	//������ �󼼺��� �Ҷ� �̹��� ����Ʈ�� �ҷ�����
	public List<AreaModel> area_imgList(int a_no);
	
}
