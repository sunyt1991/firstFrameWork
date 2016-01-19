<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="/WEB-INF/jsp/common/meta.jsp"%>
		<title>firstFrameWork</title>
		<link rel="stylesheet" type="text/css" href="${ctx }/css/login/common.css" media="screen" />
		<script type="text/javascript" src="${ctx}/js/jquery/jquery.min.js"></script>
		<script>
			$(function(){});
			function refresh(obj) {
		        obj.src = "imageServlet?"+Math.random();
		    }
			function login(){
				var data = {
						"username" : $("#username").val(),
						"password" : $("#password").val(),
						"validCode" : $("#validCode").val()
				};
				var url="${ctx}/admin/login.action";
				$.post(url,data,function(json){
					if (json.statusCode == '200') {
						window.location.href = "${ctx}/frame/main.action";
					} else if (json.statusCode == '300') {
						alert(json.message);
					} else {
						alert(json);
					}
				},"json");
			}
		</script>
	</head>
	<body id="loginFrame">
		<div id="header">
			<div id="logo"><a title="" href="#"></a></div>
		</div>
		<div id="loginBox">
			<div id="loginBoxHeader"></div>
			<div id="loginBoxBody">
				<ul class="floatLeft">
  					<li>
  						<h4>账号登录</h4>
  					</li>
  						<li>
  							<p>用户名:</p>
  							<input id="username" class="textInput" maxLength=150 size=30 type="text" name="username" /> 
  						</li>
  						<li>
  							<p>密码:</p>
  							<input id="password" class="textInput" maxLength=80 size=30 type="password" name="password" /> 
  						</li>
  						<li>
  							<p>验证码:</p>
  							<input id="validCode" class="textInput" maxLength=80 size=16 type="text" name="validCode" onkeydown="if (event.keyCode==13) login();"/>
  							<img class="validateCode" title="点击更换" onclick="javascript:refresh(this);" src="imageServlet" /> 
  						</li>
  						<li class="highlight">
  							<input id="loginBtn" onclick="login()"; value="登录" type="submit" /> 
  						</li>
  				</ul>
				<div class="floatRight">一些测试</div>
				<br clear="all">
			</div>
			<div id="loginBoxFooter"></div>
		</div>
		<div id="footer">
			<a href="#"><img alt="#"  src="${ctx }/images/login/copyright.png" /></a> 
		</div>
	</body>
</html>
