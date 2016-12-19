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

<!-- ///////////////////////상단 메뉴바///////////////////////////// -->
<input type="button" onclick="" value="홈" />&nbsp;&nbsp;
<!-- 여행지 카테고리 선택 - 관광지(a_cate : 0)/맛집(a_cate : 1) -->
<input type="button" onclick="javascript:location.href='areaList.go?a_cate=0'" value="관광지" />&nbsp;&nbsp;
<input type="button" onclick="javascript:location.href='areaList.go?a_cate=1'" value="맛집" />&nbsp;&nbsp;
<input type="button" onclick="" value="여행일정 보기" />
<!-- ///////////////////////상단 메뉴바 끝///////////////////////////// -->

<br/><br/>

<!-- ///////////////////////검색///////////////////////////// -->
<form action="areaList.go">
	<c:if test="${param.a_cate == 0 }">
		<input type="radio" value="0" name="a_cate" checked="checked">관광지&nbsp;&nbsp;
		<input type="radio" value="1" name="a_cate">맛집&nbsp;&nbsp;
	</c:if>
	<c:if test="${param.a_cate == 1 }">
		<input type="radio" value="0" name="a_cate">관광지&nbsp;&nbsp;
		<input type="radio" value="1" name="a_cate" checked="checked">맛집&nbsp;&nbsp;
	</c:if>
	<select name="searchNum" id="searchNum">
		<option value="0">이름</option>
		<option value="1">내용</option>
	</select>
	<input type="text" name="searchKeyword" />
	<input type="submit" value="검색" />
</form>

<!-- 검색어를 입력한 경우에만(검색어 공백이면 출력X) -->
<c:if test="${fn:length(searchKeyword) gt 1 && searchKeyword != ''}">
<font color="red">*<c:out value="${searchKeyword}" /> 를(을) 검색한 결과</font>
</c:if>
<!-- ///////////////////////검색 끝///////////////////////////// -->

<br/><br/>

<div class="container">	

<table width="850">
	<tr>
		<td align="left">
			총 게시글 <c:out value="${ totalCount }" />개
		</td>
		<td align="right">
			<!-- 글쓰기 버튼 관리자에게만 보이도록 수정 -->
			<input type="button" onclick="javascript:location.href='areaWriteForm.go'" value="글쓰기"/>
		</td>
	</tr>
</table>
	
<table width="850" border="0" cellspacing="0" cellpadding="2" align="center" class="table table-hover" >
	
	<!-- param.a_cate == 0 이면 관광지 -->
	<c:if test="${param.a_cate == 0}">
	<thead>
		<tr> 
			<th colspan="3"><center>관광지 리스트</center></th>
		</tr>
	</thead>
	</c:if>
	<!-- param.a_cate == 1 이면 맛집 -->
	<c:if test="${param.a_cate == 1}">
	<thead>
		<tr> 
			<th colspan="3"><center>맛집 리스트</center></th>
		</tr>
	</thead>
	</c:if>

	<tbody>
	
	<c:if test="${fn:length(areaList) le 0 }">
		<tr align="center">
			<td colspan="3">등록된 게시물이 없습니다.</td>
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
				<!-- 몇자 이상이면 ...으로 보이도록 수정해야함 -->
				${areaList.a_con }
				<br>
			</td>
			
			<td align="center" width="300">
				${areaList.a_count } / 평점
			</td>
		</tr>
		
	</c:forEach>

	</tbody>
</table>


</div>
</center>
</body>
</html>