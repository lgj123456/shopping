<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工档案</title>
<sx:head extraLocales="en-us" />
<script type="text/javascript" src="js/main2.js"></script>
<script type="text/javascript">
function formSubmit(){
	var chk = false;
	var chkRetName = out_chkMaxLength('name','msg_name','名称小于10位且不能为空!',10);
	var chkRetDate = out_pickerDate('p_date','msg_date','日期不能为空!');
	var chkRetSex = out_chkEmpty('sex','msg_sex','性别不能为空！');
	var chkRetPhone = out_chkPhone('phone','msg_phone','电话只能输入11位或12位数字!');
	var chkRetEmail = out_chkEmail('email','msg_email','Email小于30位且不能为空!',30);
	if(chkRetName && chkRetDate && chkRetSex && chkRetPhone && chkRetEmail){
		chk = true;
	}
	return chk;
}
dojo.event.topic.subscribe("/value",function(textEntered,date,widget){
	out_pickerDate('p_date','msg_date','日期不能为空!');
});
</script>
</head>
<body>
<p></p>
<p><font style="font-size: 10pt;">档案管理->员工档案->修改</font></p>
<s:form action="employeeAction" method="post" theme="simple"
	onsubmit="return formSubmit();">
	<s:hidden name="employee.id" />
	<p></p>
	<table border="0" cellpadding="1" cellspacing="1" width="95%">
		<tr>
			<td align="right" width="10%">员工编号</td>
			<td width="20%"><s:textfield name="employee.code"
				disabled="true" /></td>
			<td align="right" width="10%">员工名称</td>
			<td width="20%"><s:textfield name="employee.name" id="name"
				onfocus="show_message('msg_name','2','请输入名称！');"
				onblur="out_chkMaxLength('name','msg_name','名称小于10位且不能为空!',10)" />
			</td>
			<td align="right" width="10%">出生日期</td>
			<td width="20%"><sx:datetimepicker label=""
				name="employee.birthday" displayFormat="yyyy-MM-dd" language="en-us"
				type="date" id="p_date" required="true" valueNotifyTopics="/value" />
			</td>
			<td width="10%">&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_code"
				class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_name"
				class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_date"
				class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">员工性别</td>
			<td><s:select label="员工性别" name="employee.sex"
				list="#{true:'男',false:'女'}" heme="simple" emptyOption="true"
				id="sex" onfocus="show_message('msg_sex','2','请选择性别！');"
				onblur="out_chkEmpty('sex','msg_sex','性别不能为空！')" /></td>
			<td align="right">员工电话</td>
			<td><s:textfield name="employee.telephone" id="phone"
				onfocus="show_message('msg_phone','2','请输入电话11位或12位数字！');"
				onblur="out_chkPhone('phone','msg_phone','电话只能输入11位或12位数字!')" /></td>
			<td align="right">员工Email</td>
			<td><s:textfield name="employee.email" id="email"
				onfocus="show_message('msg_email','2','请输入Email！');"
				onblur="out_chkEmail('email','msg_email','Email小于30位且不能为空!',30)" /></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_sex"
				class="box_div_right">&nbsp;</div>
			</td>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_phone"
				class="box_div_right">&nbsp;</div>
			</td>
			<td align="right">&nbsp;</td>
			<td>
			<div style="display: show; color: red;" id="msg_email"
				class="box_div_right">&nbsp;</div>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<p></p>
	<div style="margin-left: 30px; margin-right: 0px;">
	<table border="0" cellpadding="0" cellspacing="0" width="95%">
		<tr>
			<td width="10%"><s:submit value="保存" method="updateEmployee" /></td>
			<td width="10%"><input type="button" value="返回"
				onclick="history.go(-1);" /></td>
			<td width="80%">&nbsp;</td>
		</tr>
	</table>
	</div>
</s:form>
</body>
</html>