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

<br/><br/>

<!-- ///////////////////////��� �޴���///////////////////////////// -->
<input type="button" onclick="" value="Ȩ" />&nbsp;&nbsp;
<!-- ������ ī�װ� ���� - ������(a_cate : 0)/����(a_cate : 1) -->
<input type="button" onclick="javascript:location.href='areaList.go?a_cate=0'" value="������" />&nbsp;&nbsp;
<input type="button" onclick="javascript:location.href='areaList.go?a_cate=1'" value="����" />&nbsp;&nbsp;
<input type="button" onclick="" value="�������� ����" />
<!-- ///////////////////////��� �޴��� ��///////////////////////////// -->

<br/><br/>

<!-- ///////////////////////�˻�///////////////////////////// -->
<form action="areaList.go">
	<c:if test="${param.a_cate == 0 }">
		<input type="radio" value="0" name="a_cate" checked="checked">������&nbsp;&nbsp;
		<input type="radio" value="1" name="a_cate">����&nbsp;&nbsp;
	</c:if>
	<c:if test="${param.a_cate == 1 }">
		<input type="radio" value="0" name="a_cate">������&nbsp;&nbsp;
		<input type="radio" value="1" name="a_cate" checked="checked">����&nbsp;&nbsp;
	</c:if>
	<select name="searchNum" id="searchNum">
		<option value="0">�̸�</option>
		<option value="1">����</option>
	</select>
	<input type="text" name="searchKeyword" />
	<input type="submit" value="�˻�" />
</form>

<!-- �˻�� �Է��� ��쿡��(�˻��� �����̸� ���X) -->
<c:if test="${fn:length(searchKeyword) gt 1 && searchKeyword != ''}">
<font color="red">*<c:out value="${searchKeyword}" /> ��(��) �˻��� ���</font>
</c:if>
<!-- ///////////////////////�˻� ��///////////////////////////// -->

<br/><br/>

<div class="container">	

<table width="850">
	<tr>
		<td align="left">
			�� �Խñ� <c:out value="${ totalCount }" />��
		</td>
		<td align="right">
			<!-- �۾��� ��ư �����ڿ��Ը� ���̵��� ���� -->
			<input type="button" onclick="javascript:location.href='areaWriteForm.go'" value="�۾���"/>
		</td>
	</tr>
</table>
	
<table width="850" border="0" cellspacing="0" cellpadding="2" align="center" class="table table-hover" >
	
	<!-- param.a_cate == 0 �̸� ������ -->
	<c:if test="${param.a_cate == 0}">
	<thead>
		<tr> 
			<th colspan="3"><center>������ ����Ʈ</center></th>
		</tr>
	</thead>
	</c:if>
	<!-- param.a_cate == 1 �̸� ���� -->
	<c:if test="${param.a_cate == 1}">
	<thead>
		<tr> 
			<th colspan="3"><center>���� ����Ʈ</center></th>
		</tr>
	</thead>
	</c:if>

	<tbody>
	
	<c:if test="${fn:length(areaList) le 0 }">
		<tr align="center">
			<td colspan="3">��ϵ� �Խù��� �����ϴ�.</td>
		</tr>
	</c:if>
		
	<c:forEach var="areaList" items="${areaList }" varStatus="stat">
		
		<tr height="200">
			<td align="center" width="300">
				<a href="areaDetail.go?a_no=${areaList.a_no }">
				<img src="../resources/area_img/${areaList.a_img_sav }" width="250" height="200" />
				</a>
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
				${areaList.a_count } / ����
			</td>
		</tr>
		
	</c:forEach>

	</tbody>
</table>


</div>
</center>
</body>
</html>