<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作完成</title>

<script type="text/javascript">
	var time = 10;
	var intervalid;
	intervalid = setInterval("fun()", 1000);
	function fun() {
		if (time == 0) {
			window.location.href = "<s:property value='finish_Url'/>";
			clearInterval(intervalid);
		}
		document.getElementById("time").innerHTML = time;
		time--;
	}
</script>

</head>
<body>
	<div align="center">
		<font color="#f70075">操作完成！<span id="time">10</span>秒后自动返回到查询页面或点此<a
			href="<s:property value='finish_Url'/>">立即返回</a></font>
	</div>
</body>
</html>