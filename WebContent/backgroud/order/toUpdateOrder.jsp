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
		
		$("#updateBtn").click(function() {
			var orderCode = $("#orderCode").val();
			if (orderCode.length == 0 || orderCode == "") {
				alert("订单代码不能为空！");
				$("#orderCode").focus();
				return false;
			}

			var commodityCode = $("#commodityCode").val();
			if (commodityCode.length == 0 || commodityCode == "") {
				alert("商品代码不能为空！");
				$("#commodityCode").focus();
				return false;
			}
			
			var commodityCount = $("#commodityCount").val();
			if (commodityCount.length == 0 || commodityCount == "") {
				alert("商品数量不能为空！");
				$("#commodityCount").focus();
				return false;
			}
			
			var amount = $("#amount").val();
			if (amount.length == 0 || amount == "") {
				alert("商品金额不能为空！");
				$("#amount").focus();
				return false;
			}
			
			
			var userCode = $("#userCode").val();
			if (userCode.length == 0 || userCode == "") {
				alert("用户代码不能为空！");
				$("#userCode").focus();
				return false;
			}
			
			var consignee = $("#consignee").val();
			if (consignee.length == 0 || consignee == "") {
				alert("收件人不能为空！");
				$("#consignee").focus();
				return false;
			}
			var address = $("#address").val();
			if (address.length == 0 || address == "") {
				alert("收件地址不能为空！");
				$("#address").focus();
				return false;
			}
			
			var mobile = $("#mobile").val();
			if (mobile.length == 0 || mobile == "") {
				alert("手机号码不能为空！");
				$("#mobile").focus();
				return false;
			}
			
			var email = $("#email").val();
			if (email.length == 0 || email == "") {
				alert("E-Mail不能为空！");
				$("#email").focus();
				return false;
			}

			jQuery.ajax({
				type : "post",
				url : "orderJson_updateOrder.action",
				dataType : 'text',
				data : $('#updateOrder_form').serialize(),
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

<title>更新订单信息</title>

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
									<td class="left_txt">当前位置：更新订单</td>
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
												<td width="90%" valign="top"><span class="left_txt2">在这里，您可以更新新订单</span><span
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
												<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;订单信息设置</td>
											</tr>
										</table></td>

								</tr>
								<tr>
									<td>
										<form id="updateOrder_form">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">订单代码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="hidden" name="order.id"
														value="<s:property value="order.id"/>" /> <input
														type="text" id="orderCode" name="order.orderCode"
														value="<s:property value="order.orderCode"/>" size="30"
														readonly="readonly" /></td>
												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">商品代码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="commodityCode" name="order.commodityCode"
														value="<s:property value="order.commodityCode"/>"
														size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">商品数量<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="commodityCount"
														name="order.commodityCount"
														value="<s:property value="order.commodityCount"/>"
														size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">金额<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="amount" name="order.amount"
														value="<s:property value="order.amount"/>" size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">用户代码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="userCode" name="order.userCode"
														value="<s:property value="order.userCode"/>" size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">收件人<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="consignee" name="order.consignee"
														value="<s:property value="order.consignee"/>" size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">收货地址<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="address" name="order.address"
														value="<s:property value="order.address"/>" size="30" />
													</td>

												</tr>

												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">手机号码<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="mobile" name="order.mobile"
														value="<s:property value="order.mobile"/>" size="30" />
													</td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">email<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><input
														type="text" id="email" name="order.email"
														value="<s:property value="order.email"/>" size="30" />
													</td>

												</tr>



												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">订单状态<font color="red">*</font>:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2"><select
														name="order.status">

															<s:if test="order.status==1">
																<option value="1" selected="selected">处理中</option>
																<option value="2">已出库</option>
																<option value="3">配送中</option>
																<option value="4">完成</option>
															</s:if>
															<s:elseif test="order.status==2">
																<option value="1">处理中</option>
																<option value="2" selected="selected">已出库</option>
																<option value="3">配送中</option>
																<option value="4">完成</option>

															</s:elseif>
															<s:elseif test="order.status==3">
																<option value="1">处理中</option>
																<option value="2">已出库</option>
																<option value="3" selected="selected">配送中</option>
																<option value="4">完成</option>

															</s:elseif>

															<s:else>

																<option value="1">处理中</option>
																<option value="2">已出库</option>
																<option value="3">配送中</option>
																<option value="4" selected="selected">完成</option>

															</s:else>
													</select></td>

												</tr>


												<tr>
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">备注:&nbsp;&nbsp;&nbsp;</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														<textarea id="remark" name="order.remark" cols="25" rows="5"><s:property value="order.remark" />
														</textarea>
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