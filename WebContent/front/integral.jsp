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
				<li><a href="index.action">首页</a>
				</li>
				<li class="last"><a href="#" class="colr bold">我的级别</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">
			<!-- Column 1 -->
			<div class="col1">
				<!-- Shop By Price -->
				<div class="byprice">
					<h5 class="colr">MY INTEGRAL</h5>
					<ul>
						<li><a href="myAccount.action">我的订单</a>
						</li>
						<li><a href="myConsumerRecords.action">我的消费记录</a>
						</li>
						<li><a href="myRecentlyViewed.action">我最近浏览</a>
						</li>
						<li><a href="myFavorites.action">我的收藏夹</a>
						</li>
						<li><a href="myIntegral.action">我的积分</a>
						</li>
						<li><a href="myInfo.action">账户信息</a>
						</li>
						<li><a href="updateUserPassword.action">修改密码</a>
						</li>
					</ul>
				</div>
				<div class="clear"></div>
				<div class="clear"></div>
			</div>
			<!-- Column 2 -->
			<div class="col2">
				<!-- My Account -->
				<div class="account">
					<h4 class="colr bold smallheading upper">
						<span class="arrow">MY INTEGRAL</span>
					</h4>
					<div class="accinner">

						<table border="0" cellpadding="1" cellspacing="1">
							<tbody>
								<tr>
									<th><strong>您当前的积分：<font color="red" size="3"><s:property
													value="#session.loginUser.integral" default="0" />
										</font>
									</strong>
									</th>
								</tr>
								<tr>
									<th></th>
									<td></td>
								</tr>
							</tbody>
						</table>


						<hr />
						<br />
						<div align="center">
							<s:if test="levelList.size>0">
								<s:iterator value="levelList">
									<s:if test="#session.loginUser.levelCode==levelCode">
										<span class="txt"><font color="green" size="3">注册会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">铁牌会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">铜牌会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">银牌会员</font>
										</span>
									</s:if>
									<s:elseif test="#session.loginUser.levelCode==levelCode">
										<span class="txt"><font color="green" size="3">注册会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">铁牌会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">铜牌会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">银牌会员</font>
										</span>
									</s:elseif>
									<s:elseif test="#session.loginUser.levelCode==levelCode">
										<span class="txt"><font color="green" size="3">注册会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">铁牌会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">铜牌会员</font>
										</span>
										<font size="5">————&gt;</font>
										<span class="txt"><font size="3">银牌会员</font>
										</span>
									</s:elseif>
									<s:elseif test="#session.loginUser.levelCode==levelCode">
										<span class="txt"><font color="green" size="3">注册会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">铁牌会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">铜牌会员</font>
										</span>
										<font color="red" size="5">————&gt;</font>
										<span class="txt"><font color="green" size="3">银牌会员</font>
										</span>
									</s:elseif>

								</s:iterator>

							</s:if>

						</div>

						<br /> <br />
						<hr />



					</div>

					<div class="clear"></div>

					<div class="clear"></div>
				</div>
			</div>

		</div>
		<div class="clear"></div>
		<hr />

		<div class="relateditems">
			<h6 class="bold colr relhead">根据您的购买记录，我们为您推荐</h6>
			<a href="#" class="leftarrow">&nbsp;</a>
			<ul>
				<li>
					<div class="thumb">
						<a href="detail.html"><img src="images/rel1.gif" alt="" />
						</a>
					</div>
					<div class="desc">
						<h6>
							<a href="detail.html" class="colr bold">Lorum Ipsum Dolor</a>
						</h6>
						<div class="rating">
							<div class="stars">
								<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
								<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
							</div>
							<a href="#" class="reviews">1 Review(s)</a>
						</div>
						<div class="prices">
							<p class="newprice colr bold">$58.00</p>
							<p class="oldprice">$88.00</p>
						</div>
						<div class="cartse">
							<a href="cart.html" class="buttonone">Add to Cart</a> <a href="#"
								class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
						</div>
					</div></li>
				<li>
					<div class="thumb">
						<a href="detail.html"><img src="images/rel1.gif" alt="" />
						</a>
					</div>
					<div class="desc">
						<h6>
							<a href="detail.html" class="colr bold">Lorum Ipsum Dolor</a>
						</h6>
						<div class="rating">
							<div class="stars">
								<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
								<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
							</div>
							<a href="#" class="reviews">1 Review(s)</a>
						</div>
						<div class="prices">
							<p class="newprice colr bold">$58.00</p>
							<p class="oldprice">$88.00</p>
						</div>
						<div class="cartse">
							<a href="cart.html" class="buttonone">Add to Cart</a> <a href="#"
								class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
						</div>
					</div></li>
				<li class="last">
					<div class="thumb">
						<a href="detail.html"><img src="images/rel1.gif" alt="" />
						</a>
					</div>
					<div class="desc">
						<h6>
							<a href="detail.html" class="colr bold">Lorum Ipsum Dolor</a>
						</h6>
						<div class="rating">
							<div class="stars">
								<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
								<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
							</div>
							<a href="#" class="reviews">1 Review(s)</a>
						</div>
						<div class="prices">
							<p class="newprice colr bold">$58.00</p>
							<p class="oldprice">$88.00</p>
						</div>
						<div class="cartse">
							<a href="cart.html" class="buttonone">Add to Cart</a> <a href="#"
								class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
						</div>
					</div></li>
			</ul>
			<a href="#" class="rightarrow">&nbsp;</a>
			<div class="clear"></div>

		</div>


	</div>
	<div class="clear"></div>
	<!-- Footer -->
	<jsp:include page="common/bottom.jsp" />
	<div class="clear"></div>
	</div>
</body>
</html>

<script>

	function removeFromFavorites(id){
		$("#"+id).hide();
		if(id!=''&&id.length>0){
			   jQuery.ajax({
					type : "post",
					url : "favoritesJson_deleteFavorites.action",
					dataType : 'text',
					data : {id:id},
					success : function(json) {

						if (json != null && json != '') {
							var member = eval(json); //包数据解析为json 格式
							var jsons = member.split("*");
							if (jsons[0] == "true") {
								//alert('删除成功!');
							} else {
								if (undefined != jsons[1]) {
									
									alert(jsons[1]);
									if('您还没有登录'==jsons[1]){
										window.self.location="toLogin.action";
									}
								} else {
									alert("删除失败！");
								}
							}
						} else {
							alert("异步处理异常，返回值为空！");
						}
					}
				});
			   
		   }
		
	}



</script>
