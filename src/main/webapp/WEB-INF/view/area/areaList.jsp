<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>

<div class="container">	
	
<table width="850" border="0" cellspacing="0" cellpadding="2" align="center" class="table table-hover" >
	
	<thead>
		<tr> 
			<th colspan="3"><center>������ ����Ʈ</center></th>
		</tr>
	</thead>

	<tbody>
	
	<c:if test="${fn:length(areaList) le 0 }">
		<tr align="center">
			<td colspan="3">��ϵ� �Խù��� �����ϴ�.</td>
		</tr>
	</c:if>
		
	<c:forEach var="areaList" items="${areaList }" varStatus="stat">
		
		<tr height="200">
			<td align="center" width="300">
				�̹���
			</td>
			
			<td align="left" width="1000">
				<a href="areaDetail.go?a_no=${areaList.a_no }">
					<h2><b>${areaList.a_name }</b></h2>
				</a>
				<br>
				<!-- ���� �̻��̸� ...���� ���̵��� �����ؾ��� -->
				${areaList.a_con }
				<br>
			</td>
			
			<td align="center" width="300">
				���÷��̽� ��, ����
			</td>
		</tr>
		
	</c:forEach>

	</tbody>
</table>

<!-- �۾��� ��ư �����ڿ��Ը� ���̵��� ���� -->
<input type="button" onclick="javascript:location.href='areaWriteForm.go'" value="�۾���"/>


</div>
</center>
</body>
</html>