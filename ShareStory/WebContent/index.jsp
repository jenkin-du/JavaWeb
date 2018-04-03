<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>欢迎你 </title>

<!-- For-Mobile-Apps -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Classy Forms Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 






</script>
<!-- //For-Mobile-Apps -->

<!-- Style -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Default-JavaScript-File -->
<script type="text/javascript" src="js/jquery.min.js"></script>

<!-- Web-Fonts -->
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,500,600,700,800'
	rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700'
	rel='stylesheet' type='text/css'>
<!-- //Web-Fonts -->


</head>
<body>

	<%
		String reason = request.getParameter("reason");
		if (reason != null) {
			if (reason.equals("user_nonexsit")) {
	%>
	<script type="text/javascript">
		alert("用户名不存在！");
	</script>

	<%
		} else if (reason.equals("password_wrong")) {
	%>
	<script type="text/javascript">
		alert("密码错误！");
	</script>

	<%
		} else if (reason.equals("password_paradox")) {
	%>
	<script type="text/javascript">
		alert("两次密码不一致！");
	</script>

	<%
		}
		}
	%>
	<!-- <script type="text/javascript">
		alert("登录失败！");
	</script>
 -->
	<h1>分享你身边的故事</h1>

	<div class="container">

		<div class="tab">

			<div id="horizontalTab"
				style="display: block; width: 100%; margin: 0px;">
				<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
				<script type="text/javascript">
					$(document).ready(function() {
						$('#horizontalTab').easyResponsiveTabs({
							type : 'default', //Types: default, vertical, accordion
							width : 'auto', //auto or any width like 600px
							fit : true, // 100% fit in a container
							closed : 'accordion', // Start closed if in accordion view
							activate : function(event) { // Callback function if tab is switched
								var $tab = $(this);
								var $info = $('#tabInfo');
								var $name = $('span', $info);
								$name.text($tab.text());
								$info.show();
							}
						});

						$('#verticalTab').easyResponsiveTabs({
							type : 'vertical',
							width : 'auto',
							fit : true
						});
					});
				</script>

				<div class="tabs">

					<div class="tab-left">
						<ul class="resp-tabs-list">
							<li class="resp-tab-item">登录</li>
							<li class="resp-tab-item">注册</li>
							<!--<li class="resp-tab-item">Subscribe Form</li>
							<li class="resp-tab-item">Recover Form</li>
							<li class="resp-tab-item">Contact Form</li>-->
						</ul>
					</div>

					<div class="tab-right">
						<div class="resp-tabs-container">
							<div class="tab-1 resp-tab-content">
								<div class="w3l-sign-in">
									<h3>登录</h3>
									<form action="UserServlet" method="get">
										<input type="text" class="name" name="USER_NAME"
											placeholder="用户名" required="required"> <input
											type="password" class="password" name="PASSWORD"
											placeholder="密码" required="required"> <input
											type=hidden name="ACTION" value="LOGIN"> <input
											type=hidden name="SOURCE" value="WEB">
										<ul class="w3agile">
											<li><input type="checkbox" id="brand1" value="">
												<label for="brand1"><span></span>记住我</label></li>
										</ul>
										<input type="submit" value="登录" onclick="loginSubmit">
										<div class="clear"></div>
									</form>
								</div>
							</div>
							<div class="tab-1 resp-tab-content">
								<div class="register agileits">
									<h3>注册</h3>
									<form action="UserServlet" method="post">
										<input type="text" class="name" name=USER_NAME
											placeholder="用户名(2-5个汉字)" id="username" required="required"
											onblur="checkName()"> 
											
										<input type="password"
											class="password" id="password" name="PASSWORD"
											placeholder="密码(6-12个字符)" required="required"
											onblur="checkPassword()">
											
										 <input type="password"
											class="password" id="confirm_password"
											name="CONFIRM_PASSWORD" placeholder="确认密码"
											onblur="checkConfirmPassword()" required="required">
											
										<input type=hidden name="ACTION" value="REGISTER"> 
										<input type=hidden name="SOURCE" value="WEB">
										<!-- <input type="text" class="email" name="email" placeholder="邮箱"
											required=""> -->
										<!--	<input type="text" class="location" name="location" placeholder="Your Location" required="">-->
										<input type="submit" value="注册" onclick="register()">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="clear"></div>

			</div>

		</div>

	</div>

	</div>

	<!--<div class="footer">
		<p> &copy; 2017 Classy Forms Widget. All Rights Reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
	</div>-->

	<script type="text/javascript">
		/* function checkName(){
			
			var name=document.getElementById("username").value;
			if(name=="11"){
				alert("用户名不能为空");
			}else{
				 //用户名：  
		        var  usernameRegex =  /^[\u4e00-\u9fa5]{2,5}$/; 
		        if(!usernameRegex.test(name)){
		        	alert("用户名格式错误！");
		        	document.getElementById("username").value="";
		        }
			}			
		}
		
		function checkPassword(){
			
			var pasword=document.getElementById("password").value;
			if(pasword==""){
				alert("密码不能为空");
			}else{
				 //密码：  
		        var  passwordRegex =  /^\w{6,12}$/; 
		        if(!passwordRegex.test(pasword)){
		        	alert("密码格式错误！");
		        	document.getElementById("password").value="";
		        }
			}			
		}
		
		
		function checkConfirmPassword() {
			if(document.getElementById("password").value!=  
		        document.getElementById("confirm_password").value){
				alert("两次密码不一样！");
				document.getElementById("confirm_password").value="";
			}
			
		} */

		function register() {
			var name = document.getElementById("username").value;
			var pasword = document.getElementById("password").value;
			var confirm = document.getElementById("password").value;

			if (name == "" || password == "" || confirm == "") {
				alert("注册信息请填写玩！");
				return;
			}

			//用户名：  
			var usernameRegex = /^[\u4e00-\u9fa5]{2,5}$/;
			if (!usernameRegex.test(name)) {
				alert("用户名格式错误！");
				document.getElementById("username").value = "";
				return;
			}

			//密码：  
			var passwordRegex = /^\w{6,12}$/;
			if (!passwordRegex.test(pasword)) {
				alert("密码格式错误！");
				document.getElementById("password").value = "";
				return;
			}

			if (pasword != confirm) {
				alert("两次密码不一样！");
				document.getElementById("confirm_password").value = "";
			}
		}
	</script>

</body>
</html>