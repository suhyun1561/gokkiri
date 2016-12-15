<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

function areaList(){
	if(confirm("리스트로 이동하시겠습니까?") == true){
		location.href='areaList.go';
	}else{
		return;
	}
}
</script>
</head>
<body>
<center>
<br><br><br>

<form:form commandName="areaModel" action="areaWrite.go" enctype="multipart/form-data"	method="post">

	<table border="1" width="800">

		<tbody>
			<tr>
				<th width="150" style="text-align: center">여행지 이름</th>
				<td><input type="text" name="a_name" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">여행지 주소</th>
				<td><input type="text" name="a_addr" ><input type="button" name="주소찾기" /></td>
				<!-- 주소찾기검색 해야함 -->
			</tr>
			
			<tr>
				<th style="text-align: center">카테고리</th>
				<td><input type="radio" name="a_cate" value="0" >관광지&nbsp;&nbsp;
					<input type="radio" name="a_cate" value="1" >맛집
				</td>
			</tr>
			
			<tr>
				<th style="text-align: center">여행지 가는 방법</th>
				<td><input type="text" name="a_way" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">여행지 전화번호</th>
				<td><input type="text" name="a_tel" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">여행지 영업시간</th>
				<td><input type="text" name="a_hours" ></td>
				<!-- 시간 클릭해서 입력 String으로 되는것 해야함 -->
			</tr>
			
			<tr>
				<th style="text-align: center">여행지 웹사이트</th>
				<td><input type="text" name="a_web"></td>
			</tr>

			<tr>
				<th style="text-align: center">여행지 상세설명</th>
				<td>
					<textarea rows="10" cols="100"  name="a_con" ></textarea>
				</td>
			</tr>
			
			<tr>
				<th style="text-align: center">사진 첨부파일</th>
				<td><input id="files-upload" type="file" name="file" multiple>
				
				<ul id="file-list"> 
					<li class="no-items">(파일이 선택되지 않음)</li> 
				</ul>
				
<!-- 파일 업로드 스크립트 -->
<script>
    var filesUpload = document.getElementById("files-upload"),
        fileList = document.getElementById("file-list");
     
    function traverseFiles (files) {
      var li,
          file,
          fileInfo;
      fileList.innerHTML = "";
         
      for (var i=0, il=files.length; i<il; i++) {
        li = document.createElement("li");
        file = files[i];
        fileInfo = "<div><strong>Name:</strong> " + file.name + "</div>";
        fileInfo += "<div><strong>Size:</strong> " + file.size + " bytes</div>";
        fileInfo += "<div><strong>Type:</strong> " + file.type + "</div>";
        li.innerHTML = fileInfo;
        fileList.appendChild(li);
      };
    };
     
    filesUpload.onchange = function () {
      traverseFiles(this.files);
    };
</script>

  				</td>
			</tr>
			
		</tbody>
		
	</table>
	
	<input type="button" onclick="this.form.submit();" value="등록하기" />
	<input type="button" onclick="areaList()" value="취소" />

</form:form>

<br><br><br>
</center>
</body>
</html>