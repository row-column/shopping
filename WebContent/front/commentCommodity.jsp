<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="common/head.jsp" />

<body>
	<!-- Wrapper -->
	<div id="wrapper_sec">
		<!-- Header -->
		<!--navigation part   -->
		<jsp:include page="common/navigation.jsp" />
		<div class="clear"></div>
		<div id="crumb">
			<ul>
				<li><a href="#">首页</a>
				</li>
				<li class="last"><a href="#" class="colr bold">商品评价</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">

			<div class="static">
				<form id="comment_form">
					<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th align="left"><font color="red" size="3">发表评价</font><br />
								</th>
							</tr>
							<tr>
								<th><span class="txt">标题：<font color="red">*</font>
								</span>
								</th>
								<td><input id="title" name="comment.title" type="text"
									value="<s:property value="comment.title"/>"
									class="inputAddressSize" /><span id="titleInfo"
									style="display: none"><font color="red">请填写标题</font>
								</span> <input name="comment.commodityId" type="hidden"
									value="<s:property value="commodityId" />" /></td>
							</tr>

							<tr>
								<th><span class="txt">使用体会：<font color="red">*</font>
								</span>
								</th>
								<td>&nbsp;&nbsp;&nbsp;<textarea id="usageExperience"
										name="comment.usageExperience" rows="5" cols="50"><s:property value="comment.usageExperience" /></textarea>
										<span id="usageExperienceInfo" style="display: none"><font
										color="red">请填写使用体会</font>
								</span></td>
							</tr>

							<tr>
								<th><span class="txt">优点：<font color="red">*</font>
								</span>
								</th>
								<td><input id="advantage" name="comment.advantage"
									type="text" value="<s:property value="comment.advantage"/>"
									class="inputAddressSize" /><span id="advantageInfo"
									style="display: none"><font color="red">请填写有点</font>
								</span>
								</td>
							</tr>
							<tr>
								<th><span class="txt">不足：<font color="red">*</font>
								</span>
								</th>
								<td><input id="shortcoming" name="comment.shortcoming"
									type="text" class="inputAddressSize"
									value="<s:property value="comment.advantage" default="暂时还没发现缺点哦！" />" /><span
									id="shortcomingInfo" style="display: none"><font
										color="red">请填写不足</font>
								</span>
								</td>
							</tr>
						</tbody>


					</table>
				</form>
				<hr />
				<hr />
				<hr />
				<s:if test="null==comment">
					<div align="right">
						<a href="#" id="addCommentBtn" class="addOrderBtn">提交</a>
					</div>
				</s:if>
				<div align="right">
					<a href="javascript:history.go(-1);" class="addOrderBtn">返回</a>
				</div>


			</div>

		</div>
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="common/bottom.jsp" />
		<div class="clear"></div>
	</div>
</body>
</html>
<script language="javascript">
$(document).ready(function() {
     
	$("#shortcoming").click(function(){
 		  $("#shortcoming").attr("value","");
 	  });
 	  
     $("#addCommentBtn").click(function(){
   	  
   	  var title=$("#title").val();
   	  
   	  if(title.length==0&&title==''){
   		  $("#titleInfo").show();
   	  }
   	  
   	  $("#title").click(function(){
   		  $("#titleInfo").hide();
   	  });
   	  
	 var usageExperience=$("#usageExperience").val();
   	  
   	  if(usageExperience.length==0&&usageExperience==''){
   		  $("#usageExperienceInfo").show();
   	  }
   	  
   	  $("#usageExperience").click(function(){
   		  $("#usageExperienceInfo").hide();
   	  });
   	  
	  var advantage=$("#advantage").val();
   	  
   	  if(advantage.length==0&&advantage==''){
   		  $("#advantageInfo").show();
   	  }
   	  
   	  $("#advantage").click(function(){
   		  $("#advantageInfo").hide();
   	  });
   	  
	  var shortcoming=$("#shortcoming").val();
   	  
   	  if(shortcoming.length==0&&shortcoming==''){
   		  $("#shortcomingInfo").show();
   	  }
   	  
   	  $("#shortcoming").click(function(){
   		  $("#shortcoming").attr("value","");
   		  $("#shortcomingInfo").hide();
   	  });
   	  
   	  
   	  if(title.length>0&&title!=''&&usageExperience.length>0&&usageExperience!=''&&shortcoming.length>0&&shortcoming!=''){
   		  
             jQuery.ajax({
 				type : "post",
 				url : "commentJson_addComment.action",
 				dataType : 'text',
 				data : $('#comment_form').serialize(),
 				success : function(json) {

 					if (json != null && json != '') {
 						var member = eval(json); //包数据解析为json 格式
 						var jsons = member.split("*");
 						if (jsons[0] == "true") {
 							alert('评价成功!');
 							window.self.reload();
 						} else {
 							if (undefined != jsons[1]) {
 								if('login'==jsons[1]){
 									alert('请还没有登录，请登录');
 									window.self.location="toLogin.action";
 								}else{
 									alert(jsons[1]);
 								}
 							} else {
 								alert("评价失败！");
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
