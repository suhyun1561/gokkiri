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
<table width="850" border="1" cellspacing="0" cellpadding="2" align="center" class="table table-hover" >
 
	<thead>
		<tr> 
			<th colspan="3" align="center">일정 게시판</th>
		</tr>
	</thead>
	
	<tbody>
	<c:if test="${fn:length(scheduleList) le 0 }">
		<tr bgcolor="#FFFFFF"  align="center">
			<td colspan="5">등록된 게시물이 없습니다.</td>
		</tr>						
	</c:if>
	
   
      <c:set var="colNo" value="0"/>
      <c:forEach var="scheduleList" items="${scheduleList }" varStatus="stat">
		
		<c:choose>
		
			<c:when test="${colNo % 3 == 0 }">
			<tr>
			<td align="center">
				<a href="scheduleDetail.go?s_no=${scheduleList.s_no }">
					일정 이름 : <c:out value="${scheduleList.s_name}" /> <br/>
				</a>
				<c:set var="colNo" value="${colNo+1}"/>
			</td>
			</c:when>
			
			<c:when test="${colNo % 3 == 1 }">
			<td align="center">
				
				<a href="scheduleDetail.go?s_no=${scheduleList.s_no }">
					일정 이름 : <c:out value="${scheduleList.s_name}" /> <br/>
				</a>
				<c:set var="colNo" value="${colNo+1}"/>
			</td>
			</c:when>
			
			<c:when test="${colNo % 3 == 2 }">
			<td align="center">
				
				<a href="scheduleDetail.go?s_no=${scheduleList.s_no }">
					일정 이름 : <c:out value="${scheduleList.s_name}" /> <br/>
				</a>
				<c:set var="colNo" value="${colNo+1}"/>
			</td>
			</tr>
			</c:when>
		</c:choose>

       </c:forEach>
</tbody>
</table>
</div>

</center>

</body>
</html>