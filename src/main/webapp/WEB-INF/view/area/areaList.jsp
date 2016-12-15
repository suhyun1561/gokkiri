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
			<th colspan="3"><center>여행지 리스트</center></th>
		</tr>
	</thead>

	<tbody>
	
	<c:if test="${fn:length(areaList) le 0 }">
		<tr align="center">
			<td colspan="3">등록된 게시물이 없습니다.</td>
		</tr>
	</c:if>
		
	<c:forEach var="areaList" items="${areaList }" varStatus="stat">
		
		<tr height="200">
			<td align="center" width="300">
				이미지
			</td>
			
			<td align="left" width="1000">
				<a href="areaDetail.go?a_no=${areaList.a_no }">
					<h2><b>${areaList.a_name }</b></h2>
				</a>
				<br>
				<!-- 몇자 이상이면 ...으로 보이도록 수정해야함 -->
				${areaList.a_con }
				<br>
			</td>
			
			<td align="center" width="300">
				핫플레이스 수, 평점
			</td>
		</tr>
		
	</c:forEach>

	</tbody>
</table>

<!-- 글쓰기 버튼 관리자에게만 보이도록 수정 -->
<input type="button" onclick="javascript:location.href='areaWriteForm.go'" value="글쓰기"/>


</div>
</center>
</body>
</html>