<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
/* 이미지 슬라이드 css */
li {
    list-style: none;
}
a {
    text-decoration: none;
    color: #000;
}
#gallery {
    width: 700px;
    margin: 30px auto;
    margin: 0;
    padding: 0;
}
#gallery h1 {
    text-align: center;
}
#photo {
    text-align: center;
    margin: 0;
    padding: 0;
}
#gallery ul {
    width: 800px;
    margin: 0 auto;
    overflow: hidden;
    padding: 0;
}
#photo_list ul li {
    width: 100px;
    float: left;
    text-align: center;
}
#photo_list {
    width: 300px;
    margin: 10px auto;
    overflow: hidden;
}
.btn_wrap {
    text-align: center;
}
.btn_wrap a {
    font-weight: bold;
}
/* 이미지 슬라이드 css 끝 */
</style>

<script>
/* 이미지 슬라이드 스크립트 */
window.onload = function() {
    var list_zone = document.getElementById("inner_list");
    var list_a = list_zone.getElementsByTagName("a"); // 썸네일 이미지

    for (var i=0; i<list_a.length; i++) { 
        // 썸네일 이미지 클릭하면..
        list_a[i].onclick = function() {
            var ph = document.getElementById("photo").children[0]; // 큰 이미지!
            //썸네일이 가지고 있는 큰 이미지 href값을 전달!
            ph.src = this.href; // this === list_a
            return false; // <a>를 클릭했을 때 링크가 되지 않도록!
        }
    }

    var m_num = 0;

    // 다음 버튼 클릭시 이벤트
    var n_btn = document.getElementById("next_btn");
    n_btn.onclick = function() {
        if (m_num >= list_a.length-3) { // 썸네일 3개는 화면상에 남아있어야 함! // 끝으로
            return false; // 보이는 썸네일 3개를 제외하고 끝까지 가면 이벤트 정지
        }
        m_num++;
        list_zone.style.marginLeft = -100 * m_num + "px"; // -이동
        return false; // <a>를 클릭했을 때 링크가 되지 않도록!
    }

    // 이전 버튼 클릭시 이벤트
    var b_btn = document.getElementById("before_btn");
    b_btn.onclick = function() {
        if (m_num <= 0) { // 처음으로
            return false; // 보이는 썸네일 3개를 제외하고 끝까지 가면 이벤트 정지
        }
        m_num--;
        list_zone.style.marginLeft = -100 * m_num + "px"; // +이동
        return false; // <a>를 클릭했을 때 링크가 되지 않도록!
    }
};
/* 이미지 슬라이스 스크립트 끝 */
</script>
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

<table width="1000">
	<tr>
		<td align="right">
			<input type="button" value="수정" />&nbsp;
			<input type="button" value="삭제" />
		</td>
	</tr>
	<tr>
		<td align="left"><h2>${areaModel.a_name }</h2></td>
	</tr>
</table>

<!-- 이미지 슬라이드 -->
<div id="gallery">
   <p id="photo">
       <img src="../resources/area_img/${main_img.a_img_sav }" width="700" alt=""/>
    </p>
<br>
    <div id="photo_list">
        <ul id="inner_list">
        <c:forEach var="area_imgList" items="${area_imgList }" varStatus="stat">
            <li><a href="../resources/area_img/${area_imgList.a_img_sav }">
            	<img src="../resources/area_img/${area_imgList.a_img_sav }" alt="${stat.index}" width="120" /></a></li>
        </c:forEach>
        </ul>
    </div>
    <p class="btn_wrap">
        <a href="#" id="before_btn" style="text-decoration:none"><font size="5" color="gray">&lt;</font></a>&nbsp;&nbsp;
        <a href="#" id="next_btn" style="text-decoration:none"><font size="5" color="gray">&gt;</font></a>
    </p>
</div>
<!-- 이미지 슬라이드 끝 -->




</center>
</body>
</html>