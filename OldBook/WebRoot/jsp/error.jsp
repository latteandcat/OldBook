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
						
							<a type="button" class="btn hidden-sm dropdown-toggle" style="font-size:30px" id="dropdownMenu1" data-toggle="dropdown"><i
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
	<br>
	<div class="container"><br><br><br><br>
		<div class="row">
			<div class="col-sm-6">
				　　　　<img src="<%=request.getContextPath()%>/plugins/image/1.png"></img>
			</div>
			<div class="col-sm-6">
				　　<img src="<%=request.getContextPath()%>/plugins/image/4.png"></img>
			</div>
		</div><br><br><br><br>
		<div class="row">
			<div class="col-sm-6">
				　　　　<img src="<%=request.getContextPath()%>/plugins/image/2.png"></img>
			</div>
			<div class="col-sm-6">
				　　<img src="<%=request.getContextPath()%>/plugins/image/3.png"></img>
			</div>
		</div>
		<div class="row"><br><br><br><br><br><br>
			<div class="col-sm-6">
			</div>
			<div class="col-sm-6">
			<div><a id="comein" class="myButton"><img src="<%=request.getContextPath()%>/plugins/image/in.png"></img></a></div>
			</div>
		</div>
	</div>
	

	<!-- jQuery  -->
    <script src="<%=request.getContextPath()%>/plugins/js/jquery-3.1.1.js"></script>
    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.min.js"></script>
  </body>
  	<!-- 跳转 -->
<script type="text/javascript">
	$("#login").click(function() {
		window.location.href = "/OldBook/login";
	});
</script>
<script type="text/javascript">
	$("#regist").click(function() {
		window.location.href = "/OldBook/regist";
	});
</script>
<script type="text/javascript">
	$("#hello").click(function() {
		window.location.href = "/OldBook/hello";
	});
</script>
<script type="text/javascript">
	$("#comein").click(function() {
		window.location.href = "/OldBook/login";
	});
</script>
<script type="text/javascript">
		alert("您尚未登录，请登录！");
		window.location.href = "/OldBook/login";
</script>
</html>
