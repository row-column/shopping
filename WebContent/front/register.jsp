<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="common/head.jsp" />

<script>
 $(document).ready(function() {
	 
	 $("#userCode").blur(function(){
			var userCode=$("#userCode").val();
			if(userCode.length>0&&userCode!=null){
				if(userCode!=null&&userCode.length>0){
					jQuery.ajax({
						type : "post",
						url : "userJson_checkUserCode.action",
						dataType : 'text',
						data : $('#registerUser').serialize(),
						success : function(json) {

							if (json != null && json != '') {
								var result = json; //包数据解析为json 格 式 
								  if('exist'==eval(result)){
									  $("#userCodeInfo").html("<font size='3' color='red'>×</font>");
									  $("#userCode").focus();
								  }
								
							} else {
								alert("异步处理异常，返回值为空！");
							}
						}
					});
				}
			}
			
			
		});
	 
	
	 $("#userCode").click(function(){
		 $("#userCodeInfo").html("");
     });
	 
	 $("#confirmPassword").blur(function(){
		 
		//check confirm password 
         var confirmPassword=$("#confirmPassword").val();
         var confirmPasswordInfo=$("#confirmPasswordInfo");
         if(confirmPassword.length==0||confirmPassword==""){
        	 confirmPasswordInfo.html("<font color='red'>请输入确认密码</font>");
         }else{
        	 if(confirmPassword!=$("#password").val()){
            	 confirmPasswordInfo.html("<font color='red'>确认密码与密码不正确</font>"); 
             }else {
            	 confirmPasswordInfo.html(""); 
             } 
         }
		 
	 });
	 
	 
     $("#register").click(function(){
    	 //check user code 
    	 var userCode=$("#userCode").val();
         var userCodeInfo=$("#userCodeInfo");
         if(userCode.length==0||userCode==""){
        	 userCodeInfo.html("<font color='red'>请输入用户名</font>");
         }
         $("#userCode").click(function(){
        	 userCodeInfo.html("");
         });
         
         //check password 
         var password=$("#password").val();
         var passwordInfo=$("#passwordInfo");
         if(password.length==0||password==""){
        	 passwordInfo.html("<font color='red'>请输入密码</font>");
         }
         $("#password").click(function(){
        	 passwordInfo.html("");
         });
         
         //check confirm password 
         var confirmPassword=$("#confirmPassword").val();
         var confirmPasswordInfo=$("#confirmPasswordInfo");
         if(confirmPassword.length==0||confirmPassword==""){
        	 confirmPasswordInfo.html("<font color='red'>请输入确认密码</font>");
         }else{
        	 if(confirmPassword!=$("#password").val()){
            	 confirmPasswordInfo.html("<font color='red'>确认密码与密码不正确</font>"); 
             } 
         }
         
        
         $("#confirmPassword").click(function(){
        	 confirmPasswordInfo.html("");
         });
         
         //check email 
         var email=$("#email").val();
         var emailInfo=$("#emailInfo");
         if(email.length==0||email==""){
        	 emailInfo.html("<font color='red'>请输入E-Mail</font>");
         }else {
        	 var pattern =/^[a-zA-Z0-9_\-]{1,}@[a-zA-Z0-9_\-]{1,}\.[a-zA-Z0-9_\-.]{1,}$/;
             if(!pattern.exec(email))
              {
                   emailInfo.html("<font color='red'>E-Mail格式不正确</font>");
                   $("#email").focus();
                  return false;
              }else{
    				$("#emailAlert").html("");
              }
         }
         $("#email").click(function(){
        	 emailInfo.html("");
         });
         
         if(userCode.length>0&&userCode!=""&&password.length>0&&password!=""&&confirmPassword.length>0&&confirmPassword!=""&&email.length>0&&email!=""){
        	 jQuery.ajax({
 				type : "post",
 				url : "register.action",
 				dataType : 'text',
 				data : $('#registerUser').serialize(),
 				success : function(json) {

 					if (json != null && json != '') {
 						var member = json; //包数据解析为json 格式
 						var jsons = member.split("*");
 						 
 						if (eval(jsons[0]) == "true") {
 							alert('注册成功!');
 							window.self.location="toLogin.action";
 						} else {
 							if (undefined != jsons[1]) {
 								alert(jsons[1]);
 							} else {
 								alert("注册失败！");
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
				<li><a href="index.action">首页</a>
				</li>
				<li class="last"><a href="#" class="colr bold">注册</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">
			<!-- Column 3 -->
			<div class="col3">
				<h4 class="colr bold lognhead upper">
					<span class="arrow">Costumer Register</span>
				</h4>
				<div class="login">
					<div class="innersec">
						<div class="signin">
							<p class="under">如果你已经有账户，请直接去登录。</p>
							<form id="registerUser">
								<ul class="forms">
									<li class="txt bold">用户名<font color="red"> *</font>
									</li>
									<li class="inputfield"><input id="userCode"
										name="user.userCode" type="text" class="bar" />
										<div id="userCodeInfo" /></li>

								</ul>
								<ul class="forms">
									<li class="txt bold">密码 <font color="red"> *</font>
									</li>
									<li class="inputfield"><input id="password"
										name="user.password" type="password" class="bar" />
										<div id="passwordInfo" /></li>

								</ul>
								<ul class="forms">
									<li class="txt bold">确认密码 <font color="red"> *</font>
									</li>
									<li class="inputfield"><input id="confirmPassword"
										name="confirmPassword" type="password" class="bar" />
										<div id="confirmPasswordInfo" /></li>

								</ul>
								<ul class="forms">
									<li class="txt bold">邮箱 <font color="red"> *</font>
									</li>
									<li class="inputfield"><input id="email" name="user.email"
										type="text" class="bar" />
										<div id="emailInfo" /></li>

								</ul>
								<p class="right colr under">
									<font color="red"> *</font>必须字段
								</p>
								<div class="clear"></div>
								<ul class="forms">
									<li class="txt bold">&nbsp;</li>
									<li class="inputfield"><a href="#"
										class="forgot left colr under">忘记密码?</a> <a href="#"
										id="register" class="buttonone">注册</a></li>
								</ul>


							</form>

						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="clear"></div>

		</div>
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="common/bottom.jsp" />
		<div class="clear"></div>
	</div>
</body>
</html>
