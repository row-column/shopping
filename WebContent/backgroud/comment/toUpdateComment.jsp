<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../css/jquery-ui-1.7.custom.css" rel="stylesheet"
	type="text/css" />
<script src="../js/jquery-1.3.2.min.js" type="text/javascript"></script>
<script src="../js/jquery-ui-1.7.custom.min.js" type="text/javascript"></script>

<script type="text/javascript">

	$(document).ready(function() {
		
		$("#updateBtn").click(function() {
			var title = $("#title").val();
			if (title.length == 0 || title == "") {
				alert("评价标题不能为空！");
				$("#title").focus();
				return false;
			}
			
			var advantage = $("#advantage").val();
			if (advantage.length == 0 || advantage == "") {
				alert("优点不能为空！");
				$("#advantage").focus();
				return false;
			}
			var shortcoming = $("#shortcoming").val();
			if (shortcoming.length == 0 || shortcoming == "") {
				alert("缺点不能为空！");
				$("#shortcoming").focus();
				return false;
			}
			var usageExperience = $("#usageExperience").val();
			if (usageExperience.length == 0 || usageExperience == "") {
				alert("使用体会不能为空！");
				$("#usageExperience").focus();
				return false;
			}
			
			var commodityCode = $("#commodityCode").val();
			if (commodityCode.length == 0 || commodityCode == "") {
				alert("商品代码不能为空！");
				$("#commodityCode").focus();
				return false;
			}


			var userCode = $("#userCode").val();
			if (userCode.length == 0 || userCode == "") {
				alert("评价人不能为空！");
				$("#userCode").focus();
				return false;
			}

			jQuery.ajax({
				type : "post",
				url : "commentJson_updateComment.action",
				dataType : 'text',
				data : $('#updateComment_form').serialize(),
				success : function(json) {

					if (json != null && json != '') {
						var member = json; //包数据解析为json 格式
						var jsons = member.split("*");
						 
						if (eval(jsons[0]) == "true") {
							alert('更新成功!');
							window.close();
							window.returnValue = true;
						} else {
							if (undefined != jsons[1]) {
								alert(jsons[1]);
							} else {
								alert("更新失败！");
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

<title>更新评价信息</title>

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
									<td class="left_txt">当前位置：更新评价</td>
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
												<td width="90%" valign="top"><span class="left_txt2">在这里，您可以更新新评价</span><span
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
												<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;评价信息设置</td>
											</tr>
										</table></td>

								</tr>
								<tr>
									<td>
										<form id="updateComment_form">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">标题<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="hidden" name="comment.id"
														value="<s:property value="comment.id" />" /> <input
														type="text" id="title" name="comment.title"
														value="<s:property value="comment.title" />" size="30"
														readonly="readonly" /></td>
												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">优点<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
															<textarea
															id="advantage" name="comment.advantage" cols="25"
															rows="5"><s:property value="comment.advantage" /></textarea>
													</td>
												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">缺点<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														<textarea id="shortcoming" name="comment.shortcoming" cols="25"
															rows="5"><s:property value="comment.shortcoming" />
														</textarea>
													</td>
												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">使用体会<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														<textarea id="usageExperience" name="comment.usageExperience"
															cols="25" rows="5"><s:property value="comment.usageExperience" />
														</textarea>
													</td>
												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">商品代码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="commodityCode"
														name="comment.commodityCode"
														value="<s:property value="comment.commodityCode" />"
														size="30" />
													</td>

												</tr>
												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">评价人<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="userCode" name="comment.userCode"
														value="<s:property value="comment.userCode" />" size="30" />
													</td>

												</tr>


												<tr>
													<td height="30" colspan="3">&nbsp;</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2"><input type="button" value="取消更新"
														id="cancelBtn" name="cancelBtn" />
														&nbsp;&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														&nbsp;&nbsp;&nbsp;<input type="button" value="提交更新"
														id="updateBtn" />
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