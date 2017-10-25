<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订货单</title>
<sx:head extraLocales="en-us" />
<script type="text/javascript" src="js/main2.js"></script>
</head>
<body>
<p></p>
<p><font style="font-size: 10pt;">销售管理->订货单</font></p>
<s:form action="stockorderAction" method="post" theme="simple">

	<s:action name="stockorderAction!preFindStockorder" var="preFindStockorder" />
	<p></p>
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">订货单编号</td>
			<td width="20%"><s:textfield name="stockorder.code" /></td>
			<td align="right" width="10%">货物名称</td>
			<td width="20%"><s:select list="#preFindStockorder.merchandises"
				name="stockorder.merchandise.id" listKey="id" listValue="name"
				emptyOption="true" theme="simple" /></td>
			<td align="right" width="10%">销售商</td>
			<td width="20%"><s:select list="#preFindStockorder.clients"
				name="stockorder.client.id" listKey="id" listValue="name"
				emptyOption="true" theme="simple" /></td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">订货日期</td>
			<td><sx:datetimepicker name="stockorder.orderdate"
				displayFormat="yyyy-MM-dd" language="en-us" type="date" /></td>
			<td align="right">经手人</td>
			<td><s:select list="#preFindStockorder.employees" name="stockorder.employee.id"
				listKey="id" listValue="name" emptyOption="true" theme="simple" /></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px;">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><s:submit value="查找" method="findStockorder" /></td>
			<td width="10%"><input type="button" value="新增"
				onclick="replaceModulUrl('<%=basePath %>stockorderAction!preSaveStockorder.action');" /></td>
			<td width="10%"><input type="button" value="删除"
				onclick="deleteRecords('stockorderAction!deleteStockorder.action')" /></td>
			<td width="10%"><input type="reset" value="重置" /></td>
			<td width="60%">&nbsp;</td>
		</tr>
	</table>
	</div>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px">
	<table border="1" cellpadding="0" cellspacing="0" width="90%"
		style="text-align: center;">
		<tr>
			<td width="6%">选择</td>
			<td width="8%">修改</td>
			<td width="14%">订货单编号</td>
			<td width="14%">销售商</td>
			<td width="15%">货物名称</td>
			<td width="14%">货物数量</td>
			<td width="15%">订货日期</td>
			<td width="14%">经手人</td>
		</tr>
		<s:iterator var="stockorder" value="stockorders">
			<tr>
				<td><input name="stockorderId" type="checkbox"
					title="选中后可进行删除操作" value="<s:property value='#stockorder.id' />" /></td>
				<td><a
					href="stockorderAction!preUpdateStockorder.action?stockorder.id=<s:property value='#stockorder.id'/>">
				修改</a></td>
				<td><s:property value="#stockorder.code" /></td>
				<td><s:property value="#stockorder.client.name" /></td>
				<td><s:property value="#stockorder.merchandise.name" /></td>
				<td><s:property value="#stockorder.merchandisenumber" /></td>
				<td><s:property value="#stockorder.orderdate" /></td>
				<td><s:property value="#stockorder.employee.name" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:form>
</body>
</html>