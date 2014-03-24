<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/jquery-ui-1.7.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui-1.7.custom.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		
		$("#employeeCode").blur(function(){
			var employeeCode=$("#employeeCode").val();
			if(employeeCode.length>0&&employeeCode!=''){
			jQuery.ajax({
				type : "post",
				url : "employeeJson_checkEmployeeCode.action",
				dataType : 'text',
				data : $('#addEmployee_form').serialize(),
				success : function(json) {

					if (json != null && json != '') {
						var result = eval(json); //包数据解析为json 格式
						if('ok'==result){
							$("#employeeCodeAlert").html("<font size='5' color='green'>√</font>");
							$("#employeeCodeInfo").html("");
						}else if('exist'==result){
							$("#employeeCodeInfo").html("<font color='red'>该账号已经存在</font>");	
							$("#employeeCodeAlert").html("<font size='5' color='red'>×</font>");
							$("#employeeCode").focus();
						
						}else{
							$("#employeeCodeInfo").html("<font  color='red'>"+result+"</font>");
							$("#employeeCode").focus();
						} 
						
					} else {
						alert("异步处理异常，返回值为空！");
					}
				}
			});
				
			}else{
				$("#employeeCodeAlert").html("<font size='5' color='red'>×</font>");
				$("#employeeCode").focus();
			}
		});
		$("#employeeCode").click(function(){
			$("#employeeCode").val("");
			$("#employeeCodeInfo").html("");
			
		});
		
		$("#employeeName").blur(function(){
			var employeeName = $("#employeeName").val();
			if (employeeName.length == 0 || employeeName == "") {
				$("#employeeNameAlert").html("<font size='5' color='red'>×</font>");
			}else{
				$("#employeeNameAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#employeeName").click(function(){
			$("#employeeNameAlert").html("");
			
		});
		
		$("#password").blur(function(){
			var password = $("#password").val();
			if (password.length == 0 || password == "") {
				$("#passwordAlert").html("<font size='5' color='red'>×</font>");
			}else{
				$("#passwordAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#password").click(function(){
			$("#passwordAlert").html("");
			
		});
		
		$("#mobile").blur(function(){
			var mobile = $("#mobile").val();
			if (mobile.length == 0 || mobile == "") {
				$("#mobileAlert").html("<font size='5' color='red'>×</font>");
			}else{
				 var reg =/^((\+86)|(86))?(1)\d{10}$/;
                 if(!mobile.match(reg))
                 {
                     $("#mobile").focus();
                     $("#mobileAlert").html("<font size='5' color='red'>×</font>");
                     return false;
                 }else{
					$("#mobileAlert").html("<font size='5' color='green'>√</font>");
                	 
                 }
			}
		});
		
		$("#mobile").click(function(){
			$("#mobileAlert").html("");
			
		});
		$("#email").blur(function(){
			var email = $("#email").val();
			if (email.length == 0 || email == "") {
				$("#emailAlert").html("<font size='5' color='red'>×</font>");
			}else{
				 var pattern =/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
                 if(!pattern.exec(email))
                  {
                       $("#email").focus();
                       $("#emailAlert").html("<font size='5' color='red'>×</font>");
                      return false;
                  }else{
	    				$("#emailAlert").html("<font size='5' color='green'>√</font>");
                	  
                  }
			}
		});
		
		$("#email").click(function(){
			$("#emailAlert").html("");
			
		});
		
		$("#idCard").blur(function(){
			var idCard = $("#idCard").val();
			if (idCard.length == 0 || idCard == "") {
				$("#idCardAlert").html("<font size='5' color='red'>×</font>");
				//$("#idCard").focus();
			}else{
				
			    var pattern =/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                if(!pattern.exec(idCard))
                 {
                      $("#idCard").focus();
                      $("#idCardAlert").html("<font size='5' color='red'>×</font>");
                     return false;
                 }else{
	    				$("#idCardAlert").html("<font size='5' color='green'>√</font>");
               	  
                 }
				
			}
		});
		
		$("#idCard").click(function(){
			$("#idCardAlert").html("");
			
		});
		
		$("#birthday").blur(function(){
			var birthday = $("#birthday").val();
			if (birthday.length == 0 || birthday == "") {
				$("#birthdayAlert").html("<font size='5' color='red'>×</font>");
				//$("#birthday").focus();
			}else{
				$("#birthdayAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#birthday").click(function(){
			$("#birthdayAlert").html("");
			
		});
		
		$("#address").blur(function(){
			var address = $("#address").val();
			if (address.length == 0 || address == "") {
				$("#addressAlert").html("<font size='5' color='red'>×</font>");
				//$("#address").focus();
			}else{
				$("#addressAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#address").click(function(){
			$("#addressAlert").html("");
			
		});
		
		
		$("#addBtn").click(function() {
			var employeeCode = $("#employeeCode").val();
			if (employeeCode.length == 0 || employeeCode == "") {
				$("#employeeCodeInfo").show();
				$("#employeeCodeAlert").html("<font size='5' color='red'>×</font>");
				$("#employeeCode").focus();
				return false;
			}else{
				$("#employeeCodeInfo").hide();
				$("#employeeCodeAlert").html("<font size='5' color='green'>√</font>");
				
			}


			var employeeName = $("#employeeName").val();
			if (employeeName.length == 0 || employeeName == "") {
				$("#employeeNameAlert").html("<font size='5' color='red'>×</font>");
				$("#employeeName").focus();
				return false;
			}else{
				$("#employeeNameAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var password = $("#password").val();
			if (password.length == 0 || password == "") {
				$("#passwordAlert").html("<font size='5' color='red'>×</font>");
				$("#password").focus();
				return false;
			}else{
				$("#passwordAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var mobile = $("#mobile").val();
			if (mobile.length == 0 || mobile == "") {
				
				$("#mobileAlert").html("<font size='5' color='red'>×</font>");
				$("#mobile").focus();
				return false;
			}else{
				 var reg =/^((\+86)|(86))?(1)\d{10}$/;
                 if(!mobile.match(reg))
                 {
                     $("#mobile").focus();
                     $("#mobileAlert").html("<font size='5' color='red'>×</font>");
                     return false;
                 }else{
					$("#mobileAlert").html("<font size='5' color='green'>√</font>");
                	 
                 }
				
				
			}
			var email = $("#email").val();
			if (email.length == 0 || email == "") {
				$("#emailAlert").html("<font size='5' color='red'>×</font>");
				$("#email").focus();
				return false;
			}else{
				 var pattern =/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
                 if(!pattern.exec(email))
                  {
                       $("#email").focus();
                       $("#emailAlert").html("<font size='5' color='red'>×</font>");
                      return false;
                  }else{
	    				$("#emailAlert").html("<font size='5' color='green'>√</font>");
                	  
                  }
				
			}
			var idCard = $("#idCard").val();
			if (idCard.length == 0 || idCard == "") {
				$("#idCardAlert").html("<font size='5' color='red'>×</font>");
				$("#idCard").focus();
				return false;
			}else{
			    var pattern =/(^\d{15}$)|(^\d{17}([0-9]|X)$)/;
                if(!pattern.exec(idCard))
                 {
                      $("#idCard").focus();
                      $("#idCardAlert").html("<font size='5' color='red'>×</font>");
                     return false;
                 }else{
	    				$("#idCardAlert").html("<font size='5' color='green'>√</font>");
                 }
				
			}
			var birthday = $("#birthday").val();
			if (birthday.length == 0 || birthday == "") {
				$("#birthdayAlert").html("<font size='5' color='red'>×</font>");
				$("#birthday").focus();
				return false;
			}else{
				$("#birthdayAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var address = $("#address").val();
			if (address.length == 0 || address == "") {
				$("#addressAlert").html("<font size='5' color='red'>×</font>");
				$("#address").focus();
				return false;
			}else{
				$("#addressAlert").html("<font size='5' color='green'>√</font>");
				
			}

			 jQuery.ajax({
				type : "post",
				url : "employeeJson_addEmployee.action",
				dataType : 'text',
				data : $('#addEmployee_form').serialize(),
				success : function(json) {

					if (json != null && json != '') {
						var member = json; //包数据解析为json 格式
						var jsons = member.split("*");
						if (eval(jsons[0]) == "true") {
							alert('添加成功!');
							window.close();
							window.returnValue = true;
						} else {
							if (undefined != jsons[1]) {
								alert(jsons[1]);
							} else {
								alert("添加失败！");
							}
							//window.returnValue = false;
							window.close();
							window.returnValue = true;
						}
					} else {
						alert("异步处理异常，返回值为空！");
						//window.returnValue = false;
					}
				}
			});
		});

		$("#cancelBtn").click(function() {
			window.close();
			window.returnValue = false;

		});
	});
</script>
<style type="text/css">
.ui-datepicker {
	width: 17em;
	padding: .2em .2em 0;
	font-size: 15px;
} /*覆盖了jquery-ui-1.8.13.custom.css中的.ui-datepicker，用于调整大小*/
</style>


<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #F8F9FA;
}
-->
</style>

<title>添加员工信息</title>

<link href="../images/skin.css" rel="stylesheet" type="text/css" />
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="17" height="29" valign="top"
				background="../images/mail_leftbg.gif"><img
				src="../images/left-top-right.gif" width="17" height="29" /></td>
			<td width="935" height="29" valign="top"
				background="../images/content-bg.gif"><table width="100%"
					height="31" border="0" cellpadding="0" cellspacing="0"
					class="left_topbg" id="table2">
					<tr>


					</tr>
				</table></td>
			<td width="16" valign="top" background="../images/mail_rightbg.gif"><img
				src="../images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td height="71" valign="middle"
				background="../images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9"><table width="100%"
					height="138" border="0" cellpadding="0" cellspacing="0">

					<tr>
						<td height="13" valign="top">&nbsp;</td>
					</tr>
					<tr>
						<td valign="top"><table width="98%" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td class="left_txt">当前位置：添加员工</td>
								</tr>

								<tr>
									<td height="20"><table width="100%" height="1" border="0"
											cellpadding="0" cellspacing="0" bgcolor="#CCCCCC">
											<tr>
												<td></td>
											</tr>
										</table></td>
								</tr>
								<tr>
									<td>
										<table width="100%" height="55" border="0" cellpadding="0"
											cellspacing="0">

											<tr>
												<td width="10%" height="55" valign="middle"><img
													src="../images/title.gif" width="54" height="55"></td>
												<td width="90%" valign="top"><span class="left_txt2">在这里，您可以添加新员工</span><span
													class="left_txt3">！</span><br>
												</td>
											</tr>
										</table></td>
								</tr>
								<tr>

									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><table width="100%" height="31" border="0"
											cellpadding="0" cellspacing="0" class="nowtable">
											<tr>
												<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;员工信息设置</td>
											</tr>
										</table></td>

								</tr>
								<tr>
									<td>
										<form id="addEmployee_form" enctype="multipart/form-data">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0" align="left">

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">员工号<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="employeeCode" name="employee.employeeCode"
														size="30" /> <span id="employeeCodeAlert"></span>
														<div id="employeeCodeInfo"></div></td>
												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">员工名<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="employeeName" name="employee.employeeName"
														size="30" /> <span id="employeeNameAlert"></span></td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">密码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="password" id="password" name="employee.password"
														size="30" /> <span id="passwordAlert"></span></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">性别<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="radio" name="employee.sex" value="0"
														checked="checked" />男 <input type="radio"
														name="employee.sex" value="1" />女</td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">手机号码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="mobile" name="employee.mobile" size="30" />
														<span id="mobileAlert"></span></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">email<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="email" name="employee.email" size="30" />
														<span id="emailAlert"></span></td>

												</tr>



												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">身份证号码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="idCard" name="employee.idCard" size="30" />
														<span id="idCardAlert"></span></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">生日<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="birthday" name="employee.birthday"
														size="30" style="width: 100px; height: 18px"
														onFocus="WdatePicker({isShowClear:true,readOnly:true,lang:'<s:property value="datePickerLocale"/>'})"
														readonly /> <span id="birthdayAlert"></span></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">地址<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="address" name="employee.address" size="30" />
														<span id="addressAlert"></span></td>

												</tr>
												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">头像<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="file" id="employeePhoto"
														name="employee.employeePhoto" value="上传" size="30" />
													</td>

												</tr>
												<tr>
													<td height="30" colspan="3">&nbsp;</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2"><input type="button" value="取消添加"
														id="cancelBtn" name="cancelBtn" />
														&nbsp;&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														&nbsp;&nbsp;&nbsp;<input type="button" value="提交添加"
														id="addBtn" />
													</td>

												</tr>
											</table>
										</form>
									</td>
								</tr>



							</table>
						</td>
					</tr>
				</table>
			</td>
	</table>

</body>
</html>