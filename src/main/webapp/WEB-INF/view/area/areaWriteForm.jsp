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
	if(confirm("����Ʈ�� �̵��Ͻðڽ��ϱ�?") == true){
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
				<th width="150" style="text-align: center">������ �̸�</th>
				<td><input type="text" name="a_name" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">������ �ּ�</th>
				<td><input type="text" name="a_addr" ><input type="button" name="�ּ�ã��" /></td>
				<!-- �ּ�ã��˻� �ؾ��� -->
			</tr>
			
			<tr>
				<th style="text-align: center">ī�װ�</th>
				<td><input type="radio" name="a_cate" value="0" >������&nbsp;&nbsp;
					<input type="radio" name="a_cate" value="1" >����
				</td>
			</tr>
			
			<tr>
				<th style="text-align: center">������ ���� ���</th>
				<td><input type="text" name="a_way" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">������ ��ȭ��ȣ</th>
				<td><input type="text" name="a_tel" ></td>
			</tr>
			
			<tr>
				<th style="text-align: center">������ �����ð�</th>
				<td><input type="text" name="a_hours" ></td>
				<!-- �ð� Ŭ���ؼ� �Է� String���� �Ǵ°� �ؾ��� -->
			</tr>
			
			<tr>
				<th style="text-align: center">������ ������Ʈ</th>
				<td><input type="text" name="a_web"></td>
			</tr>

			<tr>
				<th style="text-align: center">������ �󼼼���</th>
				<td>
					<textarea rows="10" cols="100"  name="a_con" ></textarea>
				</td>
			</tr>
			
			<tr>
				<th style="text-align: center">���� ÷������</th>
				<td><input id="files-upload" type="file" name="file" multiple>
				
				<ul id="file-list"> 
					<li class="no-items">(������ ���õ��� ����)</li> 
				</ul>
				
<!-- ���� ���ε� ��ũ��Ʈ -->
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
	
	<input type="button" onclick="this.form.submit();" value="����ϱ�" />
	<input type="button" onclick="areaList()" value="���" />

</form:form>

<br><br><br>
</center>
</body>
</html>