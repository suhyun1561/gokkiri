<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
/* �̹��� �����̵� css */
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
/* �̹��� �����̵� css �� */
</style>

<script>
/* �̹��� �����̵� ��ũ��Ʈ */
window.onload = function() {
    var list_zone = document.getElementById("inner_list");
    var list_a = list_zone.getElementsByTagName("a"); // ����� �̹���

    for (var i=0; i<list_a.length; i++) { 
        // ����� �̹��� Ŭ���ϸ�..
        list_a[i].onclick = function() {
            var ph = document.getElementById("photo").children[0]; // ū �̹���!
            //������� ������ �ִ� ū �̹��� href���� ����!
            ph.src = this.href; // this === list_a
            return false; // <a>�� Ŭ������ �� ��ũ�� ���� �ʵ���!
        }
    }

    var m_num = 0;

    // ���� ��ư Ŭ���� �̺�Ʈ
    var n_btn = document.getElementById("next_btn");
    n_btn.onclick = function() {
        if (m_num >= list_a.length-3) { // ����� 3���� ȭ��� �����־�� ��! // ������
            return false; // ���̴� ����� 3���� �����ϰ� ������ ���� �̺�Ʈ ����
        }
        m_num++;
        list_zone.style.marginLeft = -100 * m_num + "px"; // -�̵�
        return false; // <a>�� Ŭ������ �� ��ũ�� ���� �ʵ���!
    }

    // ���� ��ư Ŭ���� �̺�Ʈ
    var b_btn = document.getElementById("before_btn");
    b_btn.onclick = function() {
        if (m_num <= 0) { // ó������
            return false; // ���̴� ����� 3���� �����ϰ� ������ ���� �̺�Ʈ ����
        }
        m_num--;
        list_zone.style.marginLeft = -100 * m_num + "px"; // +�̵�
        return false; // <a>�� Ŭ������ �� ��ũ�� ���� �ʵ���!
    }
};
/* �̹��� �����̽� ��ũ��Ʈ �� */
</script>
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

<table width="1000">
	<tr>
		<td align="right">
			<input type="button" value="����" />&nbsp;
			<input type="button" value="����" />
		</td>
	</tr>
	<tr>
		<td align="left"><h2>${areaModel.a_name }</h2></td>
	</tr>
</table>

<!-- �̹��� �����̵� -->
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
<!-- �̹��� �����̵� �� -->




</center>
</body>
</html>