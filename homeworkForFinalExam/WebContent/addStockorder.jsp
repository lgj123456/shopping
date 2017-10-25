<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订货单</title>
<sx:head extraLocales="en-us" />
<script type="text/javascript" src="js/main2.js"></script>
<script type="text/javascript" src="dwr/util.js"></script>
<script type="text/javascript" src="dwr/engine.js"></script>
<script type="text/javascript" src="dwr/interface/stockorderAction.js"></script>
<script type="text/javascript">
var textCode;//编号
var textAmount;//数量
var codeChk = false;
//初始化
function init(){
	textCode = document.getElementById("code");
	textAmount = document.getElementById("amount");
	textCode.focus();
}
function out_code(){		
	codeChk = false;
	if(trimString(textCode.value).length>0 && trimString(textCode.value).length<12){
		stockorderAction.findStockorderByCode(textCode.value,callback);
	}else{
		show_message("msg_code","0","订货单编号不能为空且不能超过11位长度！");
		codeChk = false;
	}
}
function callback(ret){
	if(ret > 0){
		show_message("msg_code","0","输入的订货单编号["+textCode.value+"]重复请重新输入！");
		codeChk = false;
	}else{
		show_message("msg_code","1","输入正确!");
		codeChk = true;
	}
}
function out_amount(){
	var chk = false;
	var exp = /[^\d]/;
	if(!exp.test(textAmount.value) && textAmount.value>0 && textAmount.value<999){
		show_message("msg_amount","1","输入正确！");
		chk = true;
	}else{
		show_message("msg_amount","0","货物数量必须输入大于0小于999的整型数字形式！");
	}
	return chk;
}
function formSubmit(){
	var chk = false;
	var chkRetAmount = out_amount();
	var chkRetOrderdate = out_pickerDate('orderdate','msg_orderdate','订货日期不能为空!');
	var chkRetMerchandise = out_chkEmpty('merchandise','msg_merchandise','商品不能为空！');
	var chkRetClient = out_chkEmpty('client','msg_client','销售商不能为空！');
	var chkRetEmployee = out_chkEmpty('employee','msg_employee','经手人不能为空！');	
	if(codeChk && chkRetAmount && chkRetOrderdate && chkRetMerchandise && chkRetClient && chkRetEmployee ){
		chk = true;
	}
	return chk;
}
dojo.event.topic.subscribe("/value",function(textEntered,date,widget){
	out_pickerDate('orderdate','msg_orderdate','订货日期不能为空!');
});
window.onload = init;
</script>
</head>
<body>
<p></p>
<p><font style="font-size: 10pt;">销售管理->订货单->新增</font></p>
<s:form action="stockorderAction" method="post" theme="simple"
	onsubmit="return formSubmit();">
	<p></p>
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">订货单编号</td>
			<td width="20%"><s:textfield name="stockorder.code" id="code"
				onfocus="show_message('msg_code','2','请输入订货单编号！');"
				onblur="out_code()" /></td>
			<td align="right" width="10%">货物名称</td>
			<td width="20%"><s:select list="merchandises"
				name="stockorder.merchandise.id" listKey="id" listValue="name"
				emptyOption="true" theme="simple" id="merchandise"
				onfocus="show_message('msg_merchandise','2','请选择货物名称！');"
				onblur="out_chkEmpty('merchandise','msg_merchandise','货物名称不能为空!')" /></td>
			<td align="right" width="10%">货物数量</td>
			<td width="20%"><s:textfield name="stockorder.merchandisenumber"
				id="amount" onfocus="show_message('msg_amount','2','请输入货物数量！');"
				onblur="out_amount()" /></td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_code" class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_merchandise"
				class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_amount" class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">订货日期</td>
			<td><sx:datetimepicker label="" name="stockorder.orderdate"
				displayFormat="yyyy-MM-dd" language="en-us" type="date"
				id="orderdate" required="true" valueNotifyTopics="/value" /></td>
			<td align="right">销售商</td>
			<td><s:select list="clients" name="stockorder.client.id"
				listKey="id" listValue="name" emptyOption="true" theme="simple"
				id="client" onfocus="show_message('msg_client','2','请选择销售商名称！');"
				onblur="out_chkEmpty('client','msg_client','销售商不能为空!')" /></td>
			<td align="right">经手人</td>
			<td><s:select list="employees" name="stockorder.employee.id"
				listKey="id" listValue="name" emptyOption="true" theme="simple"
				id="employee"
				onfocus="show_message('msg_employee','2','请选择经手人名称！');"
				onblur="out_chkEmpty('employee','msg_employee','经手人不能为空!')" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_orderdate" class="box_div_right">&nbsp;</div>
			</td>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_client" class="box_div_right">&nbsp;</div>
			</td>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_employee" class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px;">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><s:submit value="保存" method="saveStockorder" /></td>
			<td width="10%"><input type="button" value="返回"
				onclick="history.go(-1);" /></td>
			<td width="80%">&nbsp;</td>
		</tr>
	</table>
	</div>
</s:form>
</body>
</html>