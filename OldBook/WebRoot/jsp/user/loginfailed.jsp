<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<% Object msg = session.getAttribute("msg");
 %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>旧书館 ---用旧书交換時光  </title>
    <!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- css -->
    <link href="<%=request.getContextPath()%>/plugins/css/hello.css" rel="stylesheet">
  </head>
  <body style="background-image: url('<%=request.getContextPath()%>/plugins/image/back.png');background-color:#333;">
	<header class="masthead">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<h1>
						<a id="hello">旧书館</a> 
						<p class="lead">用旧书交換時光</p>
					</h1>
				</div><br><br>
				<div class="col-sm-6">
					<div class="pull-right hidden-sm dropdown">
						
							<a type="button"class="btn dropdown-toggle" style="font-size:30px" id="dropdownMenu1" data-toggle="dropdown"><i
								class="glyphicon glyphicon-user"></i> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						
						<ul class="dropdown-menu pull-right" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="regist">注册</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="login">登录</a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</header>
	<div class="form container offsetHalf block" style="height:700px;">
		<form class="form-horizontal" role="form" method="post" action="loginsuccess">
			<br><br><br><br><br><br>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" onblur="check1()"  name="username" id="username"
						placeholder="请输入用户名">
				</div>
			</div>
			<br><br>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-9">
					<input type="password" class="form-control" onblur="check2()" name="password" id="password"
						placeholder="请输入密码">
				</div>
			</div>
			<br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> 请记住我
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button name="Submits" type="submit"  class="myButton">登录</button>
				</div>
			</div>
		</form>


	</div>

	<!-- jQuery  -->
    <script src="<%=request.getContextPath()%>/plugins/js/jquery-3.1.1.js"></script>
    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.min.js"></script>
  </body>
  	<!-- 跳转 -->
	<script type="text/javascript">
							$("#login").click(function(){
								window.location.href="/OldBook/login";
							});
		</script>
	<script type="text/javascript">
							$("#regist").click(function(){
								window.location.href="/OldBook/regist";
							});
		</script>
			<script type="text/javascript">
							$("#regist2").click(function(){
								window.location.href="/OldBook/regist";
							});
		</script>
		<script type="text/javascript">
							$("#hello").click(function(){
								window.location.href="/OldBook/hello";
							});
		</script>
		<script type="text/javascript">
function check1(){
	var username = document.getElementById("username").value;
		if(username==""){
			alert("用户名不能为空！");
		}else if(username.indexOf(' ')>=0){
			document.getElementById("username").value="";
			alert("用户名不能含有空格！");
		}
	}

function check2(){
	var password = document.getElementById("password").value;
		if(password==""){
			alert("密码不能为空！");
		}else if(password.indexOf(' ')>=0){
			document.getElementById("password").value="";
			alert("密码不能含有空格!");
		}
}


		</script>
		<script type="text/javascript">
				alert("<%=msg%>");
				window.history.go(-1);
		</script>
</html>
