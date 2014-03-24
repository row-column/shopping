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
				<li class="last"><a href="#" class="colr bold">我最近浏览过</a>
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
					<h5 class="colr">MY RECENTLY VIEWED</h5>
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
						<span class="arrow">Recently Recently Viewed</span>
					</h4>
					<div class="accinner">
						<div class="recentorders">
							<div class="account_table">
								<s:if test="recentlyViewedList.size>0">

									<ul class="headtable">
										<li class="orderCode colr bold">商品图片</li>
										<li class="commodityName colr bold">商品名称</li>
										<li class="date colr bold">商品浏览量</li>
										<li class="status colr bold">商品评价量</li>
										<li class="ordertotal colr bold">单价</li>
										<li class="status colr bold">商品状态</li>
										<li class="action colr bold">操作</li>
									</ul>
									<s:iterator value="recentlyViewedList" status="status">

										<s:if test="#status.even">
											<ul class="contable grey" id="<s:property value="id"/>">
												<li class="orderCode"><a
													href="detail.action?id=<s:property value="commodityId"/>">
														<s:if test="commodityPhoto!=null">
															<s:generator separator=";" val="commodityPhoto">
																<s:iterator status="status">
																	<s:if test="#status.index==0">
																		<img src="../commodityImages/<s:property/>" width="58"
																			height="58" />
																	</s:if>

																</s:iterator>

															</s:generator>

														</s:if> <s:else>
															<img src="../commodityImages/<s:property/>" width="121"
																height="121" />
														</s:else> </a>
												</li>
												<li class="commodityName"
													style="margin: 25px 0px 0px 0px; color: #333333;"><a
													href="detail.action?id=<s:property value="commodityId"/>"><s:property
															value="commodityName" />
												</a>
												</li>
												<li class="date"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:property
														value="viewedCount" />
												</li>
												<li class="status"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:property
														value="commentCount" />
												</li>
												<li class="ordertotal"
													style="margin: 25px 0px 0px 0px; color: #333333;">￥<s:property
														value="price" />
												</li>
												<li class="status"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:if
														test="status==0">
	                                       	有货
	                                   </s:if> <s:elseif test="status==1">
	                                                                                                          无货
	                                   </s:elseif></li>
												<li class="action"
													style="margin: 25px 0px 0px 0px; color: #333333;"><a
													href="#"
													onclick="removeFromRecentlyViewed('<s:property value="id"/>')"
													class="first">删除</a>
												</li>
											</ul>
										</s:if>
										<s:else>
											<ul class="contable" id="<s:property value="id"/>">
												<li class="orderCode"><a
													href="detail.action?id=<s:property value="commodityId"/>">
														<s:if test="commodityPhoto!=null">
															<s:generator separator=";" val="commodityPhoto">
																<s:iterator status="status">
																	<s:if test="#status.index==0">
																		<img src="../commodityImages/<s:property/>" width="58"
																			height="58" />
																	</s:if>

																</s:iterator>

															</s:generator>

														</s:if> <s:else>
															<img src="../commodityImages/<s:property/>" width="121"
																height="121" />
														</s:else> </a>
												</li>
												<li class="commodityName"
													style="margin: 25px 0px 0px 0px; color: #333333;"><a
													href="detail.action?id=<s:property value="commodityId"/>"><s:property
															value="commodityName" />
												</a>
												</li>
												<li class="date"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:property
														value="viewedCount" />
												</li>
												<li class="status"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:property
														value="commentCount" />
												</li>
												<li class="ordertotal"
													style="margin: 25px 0px 0px 0px; color: #333333;">￥<s:property
														value="price" />
												</li>
												<li class="status"
													style="margin: 25px 0px 0px 0px; color: #333333;"><s:if
														test="status==0">
	                                       	有货
	                                   </s:if> <s:elseif test="status==1">
	                                                                                                          无货
	                                   </s:elseif></li>
												<li class="action"
													style="margin: 25px 0px 0px 0px; color: #333333;"><a
													href="#"
													onclick="removeFromRecentlyViewed('<s:property value="id"/>')"
													class="first">删除</a>
												</li>
											</ul>
										</s:else>
									</s:iterator>
								</s:if>
								<s:else>
									<font class="myH5">暂无订单数据</font>
								</s:else>
							</div>
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
								<a href="cart.html" class="buttonone">Add to Cart</a> <a
									href="#" class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
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
								<a href="cart.html" class="buttonone">Add to Cart</a> <a
									href="#" class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
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
								<a href="cart.html" class="buttonone">Add to Cart</a> <a
									href="#" class="whishlist">&nbsp;</a> <a href="#" class="favo">&nbsp;</a>
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

	function removeFromRecentlyViewed(id){
		if(id!=''&&id.length>0){
			if (confirm("确认删除该商品?")) {
			   $("#"+id).hide();
			   jQuery.ajax({
					type : "post",
					url : "recentlyViewedJson_deleteRecentlyViewed.action",
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
		
	}



</script>

