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
<title>进货单</title>
<sx:head extraLocales="en-us" />
<script type="text/javascript" src="js/main2.js"></script>
</head>
<body>
<p></p>
<p><font style="font-size: 10pt;">进货管理->进货单</font></p>
<s:form action="stockinAction" method="post" theme="simple">
<s:action name="stockinAction!preFindStockin"  var="preFindStockin"/>
	<p></p>
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">进货单编号</td>
			<td width="20%"><s:textfield name="stockin.code" /></td>
			<td align="right" width="10%">货物名称</td>
			<td width="20%">
				<s:select list="#preFindStockin.merchandises"
				name="aa" listKey="id" listValue="name"
				emptyOption="true" theme="simple" />
				 
				</td>
			<td align="right" width="10%">供应商</td>
			<td width="20%"><s:select list="#preFindStockin.clients"
				name="bb" listKey="id" listValue="name"
				emptyOption="true" theme="simple" /></td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td align="right">进货日期</td>
			<td><sx:datetimepicker name="cc"
				displayFormat="yyyy-MM-dd" language="en-us" type="date" /></td>
			<td align="right">经手人</td>
			<td><s:select list="#preFindStockin.employees" name="dd"
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
			<td width="10%"><s:submit value="查找" method="findStockin" /></td>
			<td width="10%"><input type="button" value="新增"
				onclick="replaceModulUrl('<%=basePath %>stockinAction!preSaveStockin.action');" /></td>
			<td width="10%"><input type="button" value="删除"
				onclick="deleteRecords('stockinAction!deleteStockin.action')" /></td>
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
			<td width="5%">选择</td>
			<td width="6%">修改</td>
			<td width="10%">进货单编号</td>
			<td width="14%">供应商</td>
			<td width="9%">货物名称</td>
			<td width="8%">货物数量</td>
			<td width="13%">货物单价(元)</td>
			<td width="13%">货物金额(元)</td>
			<td width="12%">进货日期</td>
			<td width="10%">经手人</td>
		</tr>
		<s:iterator var="stockin" value="stockins">
			<tr>
				<td><input name="stockinId" type="checkbox" title="选中后可进行删除操作"
					value="<s:property value='#stockin.id' />" /></td>
				<td><a
					href="stockinAction!preUpdateStockin.action?stockin.id=<s:property value='#stockin.id'/>">
				修改</a></td>
				<td><s:property value="#stockin.code" /></td>
				<td><s:property value="#stockin.client.name" /></td>
				<td><s:property value="#stockin.merchandise.name" /></td>
				<td><s:property value="#stockin.amount" /></td>
				<td><s:property value="#stockin.price" /></td>
				<td><s:property value="#stockin.money" /></td>
				<td><s:property value="#stockin.stockindate" /></td>
				<td><s:property value="#stockin.employee.name" /></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:form>
</body>
</html>