<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<form class="form-horizontal" role="form" method="post" action="registsuccess">
			<br><br>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="u.username" name="u.username"
						placeholder="请输入用户名">
				</div>
			</div><br>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="u.password" name="u.password"
						placeholder="请输入密码">
				</div>
			</div><br>
			<div class="form-group">
				<label for="password1" class="col-sm-2 control-label">确认密码</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="u.password1" 
						placeholder="请确认密码">
				</div>
			</div><br>
			
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-8">
					<input type="email" class="form-control" id="u.email" name="u.email"
						placeholder="请确认邮箱">
				</div>
			</div><br>
			<div class="form-group">
				<label for="content" class="col-sm-2 control-label">个人介绍</label>
				<div class="col-sm-8">
					<textarea class="form-control" rows="3" id="u.content " name="u.content"></textarea>
				</div>
			</div><br>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="myButton">注册</button>
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
							$("#hello").click(function(){
								window.location.href="/OldBook/hello";
							});
		</script>
</html>
