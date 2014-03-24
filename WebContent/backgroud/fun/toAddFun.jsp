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
		
		$("#funCode").blur(function(){
			var funCode=$("#funCode").val();
			if(funCode!=null&&funCode.length>0){
				jQuery.ajax({
					type : "post",
					url : "funJson_checkFunCode.action",
					dataType : 'text',
					data : $('#addFun_form').serialize(),
					success : function(json) {

						if (json != null && json != '') {
							var result = eval(json); //包数据解析为json 格式
							if('ok'==result){
								$("#funCodeAlert").html("<font size='5' color='green'>√</font>");
								$("#funCodeInfo").html("");
							}else if('exist'==result){
								$("#funCodeInfo").html("<font color='red'>该功能代码已经存在</font>");	
								$("#funCodeAlert").html("<font size='5' color='red'>×</font>");
								$("#funCode").focus();
							
							}else{
								$("#funCodeInfo").html("<font  color='red'>"+result+"</font>");
							} 
							
						} else {
							alert("异步处理异常，返回值为空！");
						}
					}
				});
			}else{
				$("#funCodeAlert").html("<font size='5' color='red'>×</font>");
				$("#funCode").focus();
			}
				
			
		});
		$("#funCode").click(function(){
		    $("#funCode").val("");
		    $("#funCodeAlert").html("");
			$("#funCodeInfo").html("");
			
		});
		
		$("#funName").blur(function(){
			var funName = $("#funName").val();
			if (funName.length == 0 || funName == "") {
				$("#funNameAlert").html("<font size='5' color='red'>×</font>");
			}else{
				$("#funNameAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#funName").click(function(){
			$("#funNameAlert").html("");
			
		});
		
		$("#urlName").blur(function(){
			var urlName = $("#urlName").val();
			if (urlName.length == 0 || urlName == "") {
				$("#urlNameAlert").html("<font size='5' color='red'>×</font>");
			}else{
				$("#urlNameAlert").html("<font size='5' color='green'>√</font>");
				
			}
		});
		
		$("#urlName").click(function(){
			$("#urlNameAlert").html("");
			
		});
		$("#addBtn").click(function() {
			var funCode = $("#funCode").val();
			if (funCode.length == 0 || funCode == "") {
				$("#funCodeInfo").show();
				$("#funCodeAlert").html("<font size='5' color='red'>×</font>");
				$("#funCode").focus();
				return false;
			}else{
				$("#funCodeInfo").hide();
				$("#funCodeAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var funName = $("#funName").val();
			if (funName.length == 0 || funName == "") {
				$("#funNameAlert").html("<font size='5' color='red'>×</font>");
				$("#funName").focus();
				return false;
			}else{
				$("#funNameAlert").html("<font size='5' color='green'>√</font>");
				
			}
			var urlName = $("#urlName").val();
			if (urlName.length == 0 || urlName == "") {
				$("#urlNameInfo").show();
				$("#urlNameAlert").html("<font size='5' color='red'>×</font>");
				$("#urlName").focus();
				return false;
			}else{
				$("#urlNameAlert").html("<font size='5' color='green'>√</font>");
				
			}

			jQuery.ajax({
				type : "post",
				url : "funJson_addFun.action",
				dataType : 'text',
				data : $('#addFun_form').serialize(),
				success : function(json) {

					if (json != null && json != '') {
						var member = eval(json); //包数据解析为json 格式
						var jsons = member.split("*");
						 
						if (jsons[0] == "true") {
							alert('添加成功!');
							window.close();
							window.returnValue = true;
						} else {
							if (undefined != jsons[1]) {
								alert(jsons[1]);
							} else {
								alert("添加失败！");
							}
							window.close();
							window.returnValue = true;
						}
					} else {
						alert("异步处理异常，返回值为空！");
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

<title>添加功能信息</title>

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
									<td class="left_txt">当前位置：添加功能</td>
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
												<td width="90%" valign="top"><span class="left_txt2">在这里，您可以添加新功能</span><span
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
												<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;功能信息设置</td>
											</tr>
										</table></td>

								</tr>
								<tr>
									<td>
										<form id="addFun_form">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0" align="center">

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">功能代码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="funCode" name="fun.funCode" size="30" />
														<span id="funCodeAlert"></span>
														<div id="funCodeInfo"></div></td>
												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">功能名<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="funName" name="fun.funName" size="30" />
														<span id="funNameAlert"></span></td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">功能类型:&nbsp;&nbsp;&nbsp;</td>


													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="radio" name="fun.funType" value="0"
														checked="checked" />R <input type="radio"
														name="fun.funType" value="1" />RW</td>

												</tr>



												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">URL名<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="urlName" name="fun.urlName" size="30" />
														<span id="urlNameAlert"></span></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">URL参数:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="urlParam" name="fun.urlParam" size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">URL顺序<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="radio" name="fun.urlOrder" value="0"
														checked="checked" />升序 <input type="radio"
														name="fun.urlOrder" value="1" />降序</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">是否可用<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="radio" name="fun.isStatus" value="0"
														checked="checked" />是 <input type="radio"
														name="fun.isStatus" value="1" />否</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">父节点:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="parentCode" name="fun.parentCode"
														size="30" /></td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">所属系统<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><select
														name="fun.funSystem">
															<option value="1">员工&权限管理</option>
															<option value="2">商品&商品类别管理</option>
															<option value="3">用户&订单&消费记录管理</option>
															<option value="4">配送&配送类别管理</option>
													</select></td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">备注:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><textarea
															id="remark" name="fun.remark" cols="30" rows="5"></textarea>
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
														id="addBtn" /></td>

												</tr>
											</table>
										</form></td>
								</tr>



							</table>
						</td>
					</tr>
				</table>
			</td>
	</table>

</body>
</html>