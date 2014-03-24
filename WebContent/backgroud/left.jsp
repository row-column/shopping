<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理页面</title>

<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<style>
body {
	font: 12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}

#container {
	width: 182px;
}

H1 {
	font-size: 12px;
	margin: 0px;
	width: 182px;
	cursor: pointer;
	height: 30px;
	line-height: 20px;
}

H1 a {
	display: block;
	width: 182px;
	color: #000;
	height: 30px;
	text-decoration: none;
	moz-outline-style: none;
	background-image: url(images/menu_bgS.gif);
	background-repeat: no-repeat;
	line-height: 30px;
	text-align: center;
	margin: 0px;
	padding: 0px;
}

.content {
	width: 182px;
	height: 26px;
}

.MM ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	display: block;
}

.MM li {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	list-style-type: none;
	display: block;
	text-decoration: none;
	height: 26px;
	width: 182px;
	padding-left: 0px;
}

.MM {
	width: 182px;
	margin: 0px;
	padding: 0px;
	left: 0px;
	top: 0px;
	right: 0px;
	bottom: 0px;
	clip: rect(0px, 0px, 0px, 0px);
}

.MM a:link {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:visited {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}

.MM a:active {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	color: #333333;
	background-image: url(images/menu_bg1.gif);
	background-repeat: no-repeat;
	height: 26px;
	width: 182px;
	display: block;
	text-align: center;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	text-decoration: none;
}

.MM a:hover {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	line-height: 26px;
	font-weight: bold;
	color: #006600;
	background-image: url(images/menu_bg2.gif);
	background-repeat: no-repeat;
	text-align: center;
	display: block;
	margin: 0px;
	padding: 0px;
	height: 26px;
	width: 182px;
	text-decoration: none;
}
</style>
</head>

<body>
	<table width="100%" height="280" border="0" cellpadding="0"
		cellspacing="0" bgcolor="#EEF2FB">
		<tr>
			<td width="182" valign="top">
				<div id="container">
					<s:property value="#session.employeeFunNavigationList"
						escape="false" />

					<!-- 					<h1 class="type">
						<a href="javascript:void(0)">员工&权限管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" />
								</td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="employee/employee_employeeMain.action"
								target="main">员工信息维护</a>
							</li>
							<li><a href="fun/fun_funMain.action" target="main">功能信息维护</a>
							</li>
							<li><a href="employeeFun/employeeFun_employeeFunMain.action"
								target="main">员工权限信息维护</a>
							</li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">商品&商品类别管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" />
								</td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="commodity/commodity_commodityMain.action" target="main">商品信息维护</a>
							</li>
							<li><a href="commodityCategory/commodityCategory_commodityCategoryMain.action" target="main">商品类别信息维护</a>
							</li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">用户&订单&消费记录管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" />
								</td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="user/user_userMain.action" target="main">用户信息维护</a>
							</li>
							<li><a href="level/level_levelMain.action" target="main">级别信息维护</a>
							</li>
							<li><a href="order/order_orderMain.action" target="main">订单信息维护</a>
							</li>
							<li><a href="consumer/consumer_consumerRecordsMain.action" target="main">消费记录信息维护</a>
							</li>
							<li><a href="comment/comment_commentMain.action" target="main">评价信息维护</a>
							</li>
						</ul>
					</div>

					<h1 class="type">
						<a href="javascript:void(0)">配送&配送类别管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" />
								</td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="send/send_sendMain.action" target="main">配送信息维护</a>
							</li>
							<li><a href="sendType/sendType_sendTypeMain" target="main">配送类别信息维护</a>
							</li>
							<li><a href="carrier/carrier_carrierMain" target="main">承运商信息维护</a>
							</li>

						</ul>
					</div> -->
					<h1 class="type">
						<a href="javascript:void(0)">个人信息管理</a>
					</h1>
					<div class="content">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td><img src="images/menu_topline.gif" width="182"
									height="5" /></td>
							</tr>
						</table>
						<ul class="MM">
							<li><a href="employee/employee_toUpdateEmployeeInfo.action"
								target="main">个人信息维护</a></li>
							<li><a
								href="employee/employee_toUpdateEmployeePassword.action"
								target="main">修改密码</a></li>
						</ul>
					</div>
					<!--   <h1 class="type"><a href="javascript:void(0)">其它参数管理</a></h1>
      <div class="content">
          <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><img src="images/menu_topline.gif" width="182" height="5" /></td>
            </tr>
          </table>
        <ul class="MM">
            <li><a href="http://www.865171.cn" target="main">管理设置</a></li>
          <li><a href="http://www.865171.cn" target="main">主机状态</a></li>
          <li><a href="http://www.865171.cn" target="main">攻击状态</a></li>
          <li><a href="http://www.865171.cn" target="main">登陆记录</a></li>
          <li><a href="http://www.865171.cn" target="main">运行状态</a></li>
        </ul>
      </div> 
      </div>-->
					<script type="text/javascript">
						var contents = document
								.getElementsByClassName('content');
						var toggles = document.getElementsByClassName('type');

						var myAccordion = new fx.Accordion(toggles, contents, {
							opacity : true,
							duration : 400
						});
						myAccordion.showThisHideOpen(contents[0]);
					</script>
				</div>
			</td>

		</tr>
	</table>
</body>
</html>
