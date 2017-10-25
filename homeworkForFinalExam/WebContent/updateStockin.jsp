<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货单</title>
<sx:head extraLocales="en-us" />
<script type="text/javascript" src="js/main2.js"></script>
<script type="text/javascript">
var hiddenPrice;
var hiddenMoney;
var textMerchandise;//货物
var textPrice;//单价
var textAmount;//数量
var textMoney;//金额
//初始化
function init(){
	hiddenPrice = document.getElementById("hiddenPrice");
	hiddenMoney = document.getElementById("hiddenMoney");
	textMerchandise = document.getElementById("merchandise");
	textPrice = document.getElementById("price");
	textAmount = document.getElementById("amount");
	textMoney = document.getElementById("money");
}
function out_merchandise(){
	var chk = false;
	if(trimString(textMerchandise.value) != ""){
		stockinAction.findMerchandisePriceById(textMerchandise.value,showMerchandisePrice);
		show_message("msg_merchandise","1","输入正确！");
		chk = true;
	}else{
		show_message("msg_merchandise","0","货物名称不能为空！");
	}
	return chk;
}
function showMerchandisePrice(price){
	textPrice.value = price;
	hiddenPrice.value = price;
	var exp = /[^\d]/;
	if(!isNaN(price)&&!exp.test(textAmount.value)){
		textMoney.value = textAmount.value * price;
		hiddenMoney.value = textAmount.value * price;
	}
}
function out_amount(){
	var chk = false;
	var exp = /[^\d]/;
	if(!exp.test(textAmount.value) && textAmount.value>0 && textAmount.value<999){
		textMoney.value = textAmount.value * textPrice.value;
		hiddenMoney.value = textAmount.value * textPrice.value;
		show_message("msg_amount","1","输入正确！");
		chk = true;
	}else{
		show_message("msg_amount","0","进货数量必须输入大于0小于999的整型数字形式！");
	}
	return chk;
}
function formSubmit(){
	var chk = false;
	var chkRetMerchandise = out_merchandise();
	var chkRetAmount = out_amount();
	var chkRetStockindate = out_pickerDate('stockindate','msg_stockindate','进货日期不能为空!');
	var chkRetEmployee = out_chkEmpty('employee','msg_employee','经手人不能为空！');
	var chkRetClient = out_chkEmpty('client','msg_client','供应商不能为空！');
	if(chkRetMerchandise && chkRetAmount && chkRetStockindate && chkRetEmployee && chkRetClient){
		chk = true;
	}
	return chk;
}
dojo.event.topic.subscribe("/value",function(textEntered,date,widget){
	out_pickerDate('stockindate','msg_stockindate','进货日期不能为空!');
});
window.onload = init;
</script>
</head>
<body>
<p></p>
<p><font style="font-size: 10pt;">进货管理->进货单->修改</font></p>
<s:form action="stockinAction" method="post" theme="simple"
	onsubmit="return formSubmit();">
	<s:hidden name="stockin.price" id="hiddenPrice" />
	<s:hidden name="stockin.money" id="hiddenMoney" />
	<s:hidden name="stockin.id" />
	<p></p>
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">进货单编号</td>
			<td width="20%"><s:textfield name="stockin.code" disabled="true" /></td>
			<td align="right" width="10%">货物名称</td>
			<td width="20%"><s:select list="merchandises"
				name="stockin.merchandise.id" listKey="id" listValue="name"
				emptyOption="true" theme="simple" id="merchandise"
				onfocus="show_message('msg_merchandise','2','请选择货物名称！');"
				onblur="out_merchandise()" /></td>
			<td align="right" width="10%">进货数量</td>
			<td width="20%"><s:textfield name="stockin.amount" id="amount"
				onfocus="show_message('msg_amount','2','请输入进货数量！');"
				onblur="out_amount()" /></td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
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
			<td align="right">进货日期</td>
			<td><sx:datetimepicker label="" name="stockin.stockindate"
				displayFormat="yyyy-MM-dd" language="en-us" type="date"
				id="stockindate" required="true" valueNotifyTopics="/value" /></td>
			<td align="right">供应商</td>
			<td><s:select list="clients" name="stockin.client.id"
				listKey="id" listValue="name" emptyOption="true" theme="simple"
				id="client" onfocus="show_message('msg_client','2','请选择供应商名称！');"
				onblur="out_chkEmpty('client','msg_client','供应商不能为空!')" /></td>
			<td align="right">经手人</td>
			<td><s:select list="employees" name="stockin.employee.id"
				listKey="id" listValue="name" emptyOption="true" theme="simple"
				id="employee"
				onfocus="show_message('msg_employee','2','请选择经手人名称！');"
				onblur="out_chkEmpty('employee','msg_employee','经手人不能为空!')" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show;" id="msg_stockindate"
				class="box_div_right">&nbsp;</div>
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
		<tr>
			<td align="right">货物单价(元)</td>
			<td><s:textfield name="stockin.price" id="price" disabled="true" /></td>
			<td align="right">货物金额(元)</td>
			<td><s:textfield name="stockin.money" id="money" disabled="true" /></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px;">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><s:submit value="保存" method="updateStockin" /></td>
			<td width="10%"><input type="button" value="返回"
				onclick="history.go(-1);" /></td>
			<td width="80%">&nbsp;</td>
		</tr>
	</table>
	</div>
</s:form>
</body>
</html>