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
		
		$("#uploadBtn").click(function() {
		   var photo= $("#photo").val();
		   if (photo.length == 0 || photo == "") {
				$("#commodityPhotoAlert").html("<font size='5' color='red'>×</font>");
				$("#photo").focus();
				return false;
			}else{
				$("#commodityPhotoAlert").html("<font size='5' color='green'>√</font>");
				
			}
		  
		});
		
		$("#cancelBtn").click(function() {
			window.self.location="commodity_commodityMain.action";

		});
		
		$("#newBtn").bind("click", function(){
			 $("#myTable").append("<tr><td width=\"50%\" height=\"30\" align=\"right\" bgcolor=\"#f2f2f2\"class=\"left_txt2\"><input  type=\"checkbox\" />商品图片<font color=\"red\">*</font>:&nbsp;&nbsp;&nbsp;</td><td width=\"50%\" height=\"30\" bgcolor=\"#f2f2f2\"><input type=\"file\" id=\"photo\" name=\"photo\" value=\"请选择文件\"  size=\"30\" /> <span id=\"commodityPhotoAlert\"></span></td></tr>");
		 }); 
			 
		$("#removeBtn").bind("click", function(){
			 $("input:checked").parent().parent().remove(); 
	     }); 
			 
        

	});
	
     function removeCommodityPhoto(id){
    	 if (confirm("确认该图片?")) {
    		 
	     	$("#"+id).hide();
	    	 var pid=$("#pid").val();
	     	var commodityPhoto = $("#pic"+id).val();
    		 
             jQuery.post('commodityJson_removeCommodityPhoto.action', {id:pid,removeCommodityPhoto:commodityPhoto}, function(json) {
                 if (json != null && json != '') {
                     var result = eval(json);           //包数据解析为json 格式
                     if (result != "true") {
                         alert(result);
                     } 
                 } else {
                     alert("异步处理异常，返回值为空!");
                 }
             });
         }
  			
     }
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

<title>更新商品图片信息</title>

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
						<td valign="top">
					<tr>
						<td class="left_txt">当前位置：更新商品图片</td>
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
									<td width="90%" valign="top"><span class="left_txt2">在这里，您可以更新商品图片</span><span
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
									<td class="left_bt2">&nbsp;&nbsp;&nbsp;&nbsp;商品信息设置</td>
								</tr>
							</table></td>

					</tr>
					<tr>



						<td>

							<form id="uploadCommodityPhoto_form"
								action="uploadCommodityPhoto.action" method="post"
								enctype="multipart/form-data">
								<table id="myTable" border="0" cellpadding="0" cellspacing="0"
									align="center">
									<tbody>
										<s:if test="commodityPhotosList.size>0">

											<tr>
												<td><font size="3">商品图片</font></td>
												<td><font size="3">操作</font></td>
											</tr>
											<s:iterator value="commodityPhotosList" var="commodityPhoto" status="status">

												<tr id="<s:property value="#status.index"/>"
													style="display: ">
													<td><img
														src='../../commodityImages/<s:property value ="commodityPhoto" />'
														width="100" height="100"></img>
														<input type="hidden" id="pic<s:property value="#status.index"/>" value="<s:property value="commodityPhoto"/>" /> 
														</td>
														
													<td><font color='red'><a href="#"
															onclick="removeCommodityPhoto(<s:property value="#status.index"/>)">删除</a>
													</font>
													</td>
												</tr>

												<tr>
													<td>
														<hr />
													</td>
												</tr>
											</s:iterator>

										</s:if>

										<s:else>

											<div>暂时没有图片</div>


										</s:else>
										<tr>
											<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
												class="left_txt2"></td>

											<td width="50%" height="30" bgcolor="#f2f2f2" align="right">
												<input type="hidden" id="pid" name="id"
												value="<s:property value="id"/>" /> <input type="button"
												id="newBtn" value="添加" /> <input type="button"
												id="removeBtn" value="移除" /></td>
										</tr>
										<!-- <tr>
													
													<td width="50%" height="30" align="right" bgcolor="#f2f2f2"
														class="left_txt2">
														<input type="checkbox" />
														商品图片<font color="red">*</font>:&nbsp;&nbsp;&nbsp;
													</td>

													<td width="50%" height="30" bgcolor="#f2f2f2">
														<input type="file" id="photo" name="photo" value="上传"  size="30" />
														 <span id="commodityPhotoAlert"></span>
													</td>
											</tr>
											-->

									</tbody>


								</table>

								<hr />
								<table border="0" cellpadding="0" cellspacing="0" align="center">
									<tbody>
										<tr>
											<td  height="30" align="right" bgcolor="#f2f2f2"
												class="left_txt2"><input type="button" value="取消上传"
												id="cancelBtn" name="cancelBtn" /> &nbsp;&nbsp;&nbsp;&nbsp;
											</td>

											<td height="30" bgcolor="#f2f2f2">
												&nbsp;&nbsp;&nbsp;<input type="submit" value="提交上传"
												id="uploadBtn" /></td>

										</tr>
									</tbody>
								</table>

							</form></td>


					</tr>
				</table>
			</td>
	</table>

</body>
</html>