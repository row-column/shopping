<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<link href="../css/jquery-ui-1.7.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui-1.7.custom.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		
		//当原密码输入框 光标离开的 时候 出发该事件
		$("#oldPassword").blur(function(){
			//取得原密码
			var oldPassword=$("#oldPassword").val();
			//取得用户账号
			var employeeCode=$("#employeeCode").val();
			if(oldPassword.length>0&&oldPassword!=''&&employeeCode.length>0&&employeeCode!=''){
			jQuery.ajax({
				type : "post",
				url : "employeeJson_checkEmployeePassword.action",
				dataType : 'text',
				data : {"employeeCode":employeeCode,"password":oldPassword },
				success : function(json) {

					if (json != null && json != '') {
						var result = eval(json); //包数据解析为json 格式
						if('true'==result){
							$("#oldPasswordAlert").html("<font size='5' color='green'>√</font>");
						}else if('false'==result){
							$("#oldPasswordAlert").html("<font size='5' color='red'>× 原密码不正确</font>");
							$("#oldPassword").focus();
							return false;
						}else{
							$("#oldPasswordAlert").html("<font  color='red'>"+result+"</font>");
						} 
						
					} else {
						alert("异步处理异常，返回值为空！");
					}
				}
			});
				
			}else{
				$("#oldPasswordAlert").html("<font size='5' color='red'>×</font>");
				$("#oldPassword").focus();
			}
		});
		$("#oldPassword").click(function(){
			$("#oldPasswordAlert").html("");
			
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
		
		$("#confirmPassword").blur(function(){
			var confirmPassword = $("#confirmPassword").val();
			if (confirmPassword.length == 0 || confirmPassword == "") {
				$("#confirmPasswordAlert").html("<font size='5' color='red'>×</font>");
			}else{
				if(confirmPassword!=$("#password").val()){
					$("#confirmPasswordAlert").html("<font size='5' color='red'>新密码和确认密码不一致</font>");
					$("#confirmPassword").focus();
				}else{
					$("#confirmPasswordAlert").html("<font size='5' color='green'>√</font>");
				}
				
			}
		});
		
		$("#confirmPassword").click(function(){
			$("#confirmPasswordAlert").html("");
			
		});
		
		
		
		
		$("#modifyBtn").click(function() {
			var oldPassword = $("#oldPassword").val();
			if (oldPassword.length == 0 || oldPassword == "") {
				$("#oldPasswordAlert").html("<font size='5' color='red'>×</font>");
				$("#oldPassword").focus();
				return false;
			}else{
				$("#oldPasswordAlert").html("<font size='5' color='green'>√</font>");
				
			}


			var password = $("#password").val();
			if (password.length == 0 || password == "") {
				$("#passwordAlert").html("<font size='5' color='red'>×</font>");
				$("#password").focus();
				return false;
			}else{
				$("#passwordAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var confirmPassword = $("#confirmPassword").val();
			if (confirmPassword.length == 0 || confirmPassword == "") {
				$("#confirmPasswordAlert").html("<font size='5' color='red'>×</font>");
				$("#confirmPassword").focus();
				return false;
			}else{
				if(confirmPassword!=$("#password").val()){
					$("#confirmPasswordAlert").html("<font size='5' color='red'>新密码和确认密码不一致</font>");
					$("#confirmPassword").focus();
					return false;
				}else{
					$("#confirmPasswordAlert").html("<font size='5' color='green'>√</font>");
				}
			}
			var employeeCode=$("#employeeCode").val();
			if(employeeCode.length>0&&employeeCode!=''&&oldPassword.length>0&&oldPassword!=''
				&&password.length>0&&password!=''&&confirmPassword.length>0&&confirmPassword!=''){
				
				 jQuery.ajax({
						type : "post",
						url : "employeeJson_updateEmployeePassword.action",
						dataType : 'text',
						data : {"employeeCode":employeeCode,"password":password},
						success : function(json) {

							if (json != null && json != '') {
								var member = eval(json); //包数据解析为json 格式
								if (member == "true") {
									alert('修改密码成功!');
									window.location ="employee_toUpdateEmployeePassword.action";
								} else {
									if (undefined != jsons[1]) {
										alert(member);
									} else {
										alert("密码修改失败！");
									}
								}
							} else {
								alert("异步处理异常，返回值为空！");
							}
						}
					});

			}

	});
	});
</script>

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

<title>个人信息管理</title>

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

						<td height="31"><div class="titlebt">个人信息管理</div></td>
					</tr>
				</table></td>
			<td width="16" valign="top" background="../images/mail_rightbg.gif"><img
				src="../images/nav-right-bg.gif" width="16" height="29" /></td>
		</tr>
		<tr>
			<td height="71" valign="middle"
				background="../images/mail_leftbg.gif">&nbsp;</td>
			<td valign="top" bgcolor="#F7F8F9">


				<form id="updateEmployeePassword_form">
					<table width="100%" height="138" border="0" cellpadding="0"
						cellspacing="0">

						<tr>
							<td height="13" valign="top">&nbsp;</td>
						</tr>
						<tr>
							<td valign="top"><table width="98%" border="0"
									align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td class="left_txt">当前位置：个人信息</td>
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
										<td><table width="100%" height="55" border="0"
												cellpadding="0" cellspacing="0">

												<tr>
													<td width="10%" height="55" valign="middle"><img
														src="../images/title.gif" width="54" height="55"></td>
													<td width="90%" valign="top"><span class="left_txt2">在这里，您可以更改您个人密码</span><span
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
													<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;个人信息设置</td>
												</tr>
											</table></td>

									</tr>
									<tr>
										<td>

											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">

												<tr>

													<td height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">员工号：</td>
													<td width="5%" bgcolor="#f2f2f2">&nbsp;</td>
													<td width="34%" height="30" bgcolor="#f2f2f2"><input
														type="hidden" id="employeeCode" name="employeeCode"
														value="<s:property value="#session.employeeCode" />" /> <input
														type="text"
														value="<s:property value="#session.employeeCode" />"
														disabled="disabled" size="30" />
													</td>
													<td width="34%" height="30" bgcolor="#f2f2f2"
														class="left_txt">&nbsp;</td>
												</tr>

												<tr>
													<td height="30" align="right" class="left_txt2">原密码：</td>
													<td>&nbsp;</td>
													<td height="30"><input type="password"
														id="oldPassword" name="oldPassword" size="30" />
													</td>
													<td height="30" class="left_txt">&nbsp;<span
														id="oldPasswordAlert"></span></td>
												</tr>

												<tr>
													<td height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">新密码：</td>
													<td bgcolor="#f2f2f2">&nbsp;</td>
													<td height="30" bgcolor="#f2f2f2"><input
														type="password" id="password" name="password" size="30" />
													</td>
													<td height="30" bgcolor="#f2f2f2" class="left_txt">&nbsp;<span
														id="passwordAlert"></span></td>
												</tr>
												<tr>
													<td height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">确认密码：</td>
													<td bgcolor="#f2f2f2">&nbsp;</td>
													<td height="30" bgcolor="#f2f2f2"><input
														type="password" id="confirmPassword"
														name="confirmPassword" size="30" />
													</td>
													<td height="30" bgcolor="#f2f2f2" class="left_txt">&nbsp;<span
														id="confirmPasswordAlert"></span></td>
												</tr>


											</table>


											<table width="100%" height="99" border="0" cellpadding="0"
												cellspacing="0">

												<tr align="left">
													<td width="50%" height="30" align="center"><input
														type="reset" value="取消设置" name="B12" />
													</td>
													<td width="50%" height="30"><input type="button"
														id="modifyBtn" value="提交修改" name="B1" />
													</td>

												</tr>
											</table>
										</td>
									</tr>

								</table>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>

</body>
