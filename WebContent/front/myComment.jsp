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
				<li class="last"><a href="#" class="colr bold">我的商品评价</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">
			<table border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td width="40%">
							<table border="0" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th><font color="red" size="3">商品信息</font><br />
										<br /></th>
									</tr>
									<tr>
										<td colspan="2">
											<div align="center">
												<a href="detail.action?id=<s:property value="commodityId"/>"><img
													src="images/static1.gif" align="middle" alt="" width="120"
													height="120" />
												</a>
											</div>
											<br />
										<br />
										</td>
									</tr>
									<tr>
										<th><span class="txt">商品名称：</span>
										</th>
										<td><s:property value="commodity.commodityName" />
										</td>
									</tr>
									<tr>
										<th><span class="txt">价格：</span>
										</th>
										<td><s:if
												test="commodity.newPrice!=null&&commodity.newPrice<commodity.price">
				                          	￥ <s:property value="commodity.newPrice" />
											</s:if> <s:else>
						                                                    ￥<s:property
													value="commodity.price" />
											</s:else></td>
									</tr>
									<tr>
										<th><span class="txt">评论数：</span>
										</th>
										<td><s:property value="commodity.commentCount" />条</td>
									</tr>
									<tr>
										<th><br />
										<br />
										</th>
									</tr>
									<tr>
										<th><hr /> <span class="txt"><a
												onclick="addToCart('<s:property value="commodity.id"/>')"
												class="buttonone">加入购物车</a>
										</span>
										</th>
									</tr>
								</tbody>

							</table></td>

						<td>
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
											class="inputAddressSize"
											value="<s:property value="comment.title"/>" /></td>
									</tr>

									<tr>
										<th><span class="txt">使用体会：<font color="red">*</font>
										</span>
										</th>
										<td>&nbsp;&nbsp;&nbsp;<textarea id="useExperience"
												name="comment.useExperience" rows="5" cols="50">
												<s:property value="comment.title" />
											</textarea></td>
									</tr>

									<tr>
										<th><span class="txt">优点：<font color="red">*</font>
										</span>
										</th>
										<td><input id="advantage" name="comment.advantage"
											type="text" class="inputAddressSize"
											value="<s:property value="comment.advantage"/>" />
										</td>
									</tr>
									<tr>
										<th><span class="txt">不足：<font color="red">*</font>
										</span>
										</th>
										<td><input id="shortcoming" name="comment.shortcoming"
											type="text" class="inputAddressSize"
											value="<s:property value="comment.shortcoming" default="暂时还没发现缺点哦！"/>" />
										</td>
									</tr>
								</tbody>


							</table></td>

					</tr>
				</tbody>


			</table>


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
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="common/bottom.jsp" />
		<div class="clear"></div>
	</div>
</body>
</html>
