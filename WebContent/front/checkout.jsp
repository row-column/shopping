<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="common/head.jsp" />
<script>
 $(document).ready(function() {
      $("#isRemark").click(function(){
    	  
	      if($("#isRemark").attr("checked")==true){
	    	  $("#remark").show();
	    	  $("#remarkAlertInfo").show();
	      }else{
	    	  $("#remark").hide();
	    	  $("#remarkAlertInfo").hide(); 
	      }
    	  
    	  
      });
      
      
      $("#addOrderBtn").click(function(){
    	  
    	  var consignee=$("#consignee").val();
    	  
    	  if(consignee.length==0&&consignee==''){
    		  $("#consigneeInfo").show();
    	  }
    	  
    	  $("#consignee").click(function(){
    		  $("#consigneeInfo").hide();
    	  });
    	  
 		  var address=$("#address").val();
    	  
    	  if(address.length==0&&address==''){
    		  $("#addressInfo").show();
    	  }
    	  
    	  $("#address").click(function(){
    		  $("#addressInfo").hide();
    	  });
    	  
 		  var mobile=$("#mobile").val();
    	  
    	  if(mobile.length==0&&mobile==''){
    		  $("#mobileInfo").show();
    	  }
    	  
    	  $("#mobile").click(function(){
    		  $("#mobileInfo").hide();
    	  });
    	  
 		  var email=$("#email").val();
    	  
    	  if(email.length==0&&email==''){
    		  $("#emailInfo").show();
    	  }
    	  
    	  $("#email").click(function(){
    		  $("#emailInfo").hide();
    	  });
    	  
 		 var zipCode=$("#zipCode").val();
    	  
    	  if(zipCode.length==0&&zipCode==''){
    		  $("#zipCodeInfo").show();
    	  }
    	  
    	  $("#zipCode").click(function(){
    		  $("#zipCodeInfo").hide();
    	  });
    	  
 		var paymentMethod=$("#paymentMethod").val();
    	  
    	  if(paymentMethod.length==0&&paymentMethod==''){
    		  $("#paymentMethodInfo").show();
    	  }
    	  
    	  $("#paymentMethod").click(function(){
    		  $("#paymentMethodInfo").hide();
    	  });
    	  
 		var shippingMethod=$("#shippingMethod").val();
    	  
    	  if(shippingMethod.length==0&&shippingMethod==''){
    		  $("#shippingMethodInfo").show();
    	  }
    	  
    	  $("#shippingMethod").click(function(){
    		  $("#shippingMethodInfo").hide();
    	  });
    	  
    	  var sendTypeCode=$("#sendTypeCode").val();
    	  if(sendTypeCode.length==0&&sendTypeCode==''){
    		  $("#sendTypeCodeInfo").show();
    	  }
    	  
    	  $("#sendTypeCode").click(function(){
    		  $("#sendTypeCodeInfo").hide();
    	  });
    	  
    	  var carrierCode=$("#carrierCode").val();
    	  if(carrierCode.length==0&&carrierCode==''){
    		  $("#carrierCodeInfo").show();
    	  }
    	  
    	  $("#carrierCode").click(function(){
    		  $("#carrierCodeInfo").hide();
    	  });
    	  
    	  var remark=$("#remark").val();
    	  if(consignee.length>0&&consignee!=''&&address.length>0&&address!=''&&mobile.length>0&&mobile!=''&&email.length>0&&email!=''&&email.length>0&&zipCode!=''&&zipCode.length>0&&zipCode!=''&&paymentMethod.length>0&&paymentMethod!=''&&shippingMethod.length>0&&shippingMethod!=''&&sendTypeCode.length>0&&sendTypeCode!=''&&carrierCode.length>0&&carrierCode!=''){
    		  
              jQuery.ajax({
  				type : "post",
  				url : "shoppingCartJson_checkout.action",
  				dataType : 'text',
  				data : {consignee:consignee,address:address,mobile:mobile,email:email,zipCode:zipCode,paymentMethod:paymentMethod,shippingMethod:shippingMethod,sendTypeCode:sendTypeCode,carrierCode:carrierCode,remark:remark},
  				success : function(json) {

  					if (json != null && json != '') {
  						var member = eval(json); //包数据解析为json 格式
  						var jsons = member.split("*");
  						if (jsons[0] == "true") {
  							alert('订单提交成功!');
  							window.self.location="index.action";
  						} else {
  							if (undefined != jsons[1]) {
  								alert(jsons[1]);
  							} else {
  								alert("加入失败！");
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
				<li class="last"><a href="#" class="colr bold">订单结算中心</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">

			<div class="static">
				<form id="orderForm" class="forms">
					<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th align="left"><font size="3">收货人信息</font></th>
							</tr>
							<tr>
								<th><span class="txt">收货人姓名：<font color="red">*</font>
								</span>
								</th>
								<td><input id="consignee" name="consignee" type="text"
									class="inputSize" /><span id="consigneeInfo"
									style="display: none"><font color='red'>请填写收件人</font>
								</span>
								</td>
							</tr>

							<tr>
								<th><span class="txt">地址：<font color="red">*</font>
								</span>
								</th>
								<td><input id="address" name="address" type="text"
									class="inputAddressSize" /><span id="addressInfo"
									style="display: none"><font color="red">请填写收货地址</font>
								</span>
								</td>
							</tr>
							<tr>
								<th><span class="txt">手机号码：<font color="red">*</font>
								</span>
								</th>
								<td><input id="mobile" name="mobile" type="text"
									class="inputSize" /><span id="mobileInfo" style="display: none"><font
										color="red">请填写手机号码</font>
								</span>
								</td>
							</tr>
							<tr>
								<th><span class="txt">电子邮件：<font color="red">*</font>
								</span>
								</th>
								<td><input id="email" name="email" type="text"
									class="inputSize" /><span id="emailInfo" style="display: none"><font
										color="red">请填写电子邮件</font>
								</span>
								</td>
							</tr>
							<tr>
								<th><span class="txt">邮编：<font color="red">*</font>
								</span>
								</th>
								<td><input id="zipCode" name="zipCode" type="text"
									class="inputSize" /><span id="zipCodeInfo"
									style="display: none"><font color="red">请填写邮编</font>
								</span>
								</td>
							</tr>
						</tbody>


					</table>

					<hr />


					<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th align="left"><font size="3">支付及配送信息</font></th>
							</tr>
							<tr>
								<th><span class="txt">支付方式：<font color="red">*</font>
								</span>
								</th>
								<td><select id="paymentMethod" name="paymentMethod">
										<option value="">请选择支付方式</option>
										<option value="1">货到付款</option>
										<option value="2">邮政付款</option>

								</select> <span id="paymentMethodInfo" style="display: none"><font
										color="red">请填写支付方式</font>
								</span></td>
							</tr>
							<tr>
								<th><span class="txt">送货日期：<font color="red">*</font>
								</span>
								</th>
								<td><select id="shippingMethod" name="shippingMethod">
										<option value="">请选择送货日期</option>
										<option value="1">只工作日送货（双休日、假日不用送）</option>
										<option value="2">工作日、双休日与假日均可送货</option>
										<option value="3">只双休日、假日送货（工作日不用送）</option>
								</select> <span id="shippingMethodInfo" style="display: none"><font
										color="red">请填写送货日期</font>
								</span></td>
							</tr>

							<tr>
								<th><span class="txt">配送类型：<font color="red">*</font>
								</span>
								</th>
								<td><select id="sendTypeCode" name="sendTypeCode">
										<option value="">请选择配送类别</option>
										<s:if test="sendTypeList.size>0">
											<s:iterator value="sendTypeList">
												<option value="<s:property value="sendTypeCode" />">
													<s:property value="sendTypeName" />
												</option>
											</s:iterator>

										</s:if>
								</select> <span id="sendTypeCodeInfo" style="display: none"><font
										color="red">请填写配送类别</font>
								</span></td>
							</tr>

							<tr>
								<th><span class="txt">承运商：<font color="red">*</font>
								</span>
								</th>
								<td><select id="carrierCode" name="carrierCode">
										<option value="">请选择承运商</option>
										<s:if test="carrierList.size>0">
											<s:iterator value="carrierList">
												<option value="<s:property value="carrierCode"/>">
													<s:property value="carrierName" />
												</option>
											</s:iterator>
										</s:if>
								</select> <span id="carrierCodeInfo" style="display: none"><font
										color="red">请填写承运商</font>
								</span></td>
							</tr>
						</tbody>


					</table>
					<hr />
					<div align="right">
						<a href="myShoppingCart.action"><strong>返回购物车</strong>
						</a>
					</div>
					<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th align="left"><font size="3"> 商品信息</font></th>
							</tr>
							<tr>
								<td>商品编号</td>
								<td>商品名称</td>
								<td>单价</td>
								<td>库存状态</td>
								<td>数量</td>
							</tr>
							<s:if test="shoppingCartList.size>0">
								<s:iterator value="shoppingCartList">
									<tr>
										<td><a
											href="detail.action?commodity.id=<s:property value="commodityId"/>"><s:property
													value="commodityCode" />
										</a>
										</td>
										<td><a
											href="detail.action?commodity.id=<s:property value="commodityId"/>"><s:property
													value="commodityName" />
										</a>
										</td>
										<td><s:property value="price" />
										</td>
										<td><s:if test="status==0">
				             		现货
				             </s:if> <s:else>
				             		无货
				             </s:else></td>
										<td><s:property value="commodityNum" />
										</td>
									</tr>
								</s:iterator>
							</s:if>
						</tbody>


					</table>
					<hr />
					<input type="checkbox" id="isRemark" /> 订单备注 <input id="remark"
						name="remark" type="text" style="display: none"
						class="inputAddressSize" />
					<div id="remarkAlertInfo" style="display: none">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="red">*提示</font>：请勿填写有关支付、收货、发票方面的信息。
					</div>
					<hr />
					<font size="3">结算信息</font>
					<div align="right">
						<strong>应付总额：</strong><font color="red">￥<s:property
								value="totalPrice" /> 元</font>
					</div>

					<hr />
					<div align="right">
						<a href="#" id="addOrderBtn" class="addOrderBtn">提交订单</a>
					</div>
				</form>


			</div>

		</div>
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="common/bottom.jsp" />
		<div class="clear"></div>
	</div>
</body>
</html>
