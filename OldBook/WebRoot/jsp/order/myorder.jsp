<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Object name = session.getAttribute("username");
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
    <link href="<%=request.getContextPath()%>/plugins/css/index.css" rel="stylesheet">
  </head>
  <body>
  	<div class="head">
  		<div class="container" style="width:100%;">
  		<div class="col-sm-4 "><a id="index" href="/OldBook/index"><span class="glyphicon glyphicon-book yellow"></span>旧书館</a> --- 用旧书交換時光</div>
  		<div class="col-sm-8 ">
  			<div class="pull-right hidden-sm dropdown">
  						<a type="button" class="btn dropdown-toggle" title="发布旧书" style="font-size:20px" id="addbook"><i
								class="glyphicon glyphicon-plus"></i>发布旧书
							</a>	
						欢迎您,<%=name %>
							<a type="button" class="btn dropdown-toggle" style="font-size:20px" id="dropdownMenu1" data-toggle="dropdown"><i
								class="glyphicon glyphicon-user"></i> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</a>
						<ul class="dropdown-menu pull-right" role="menu"
							aria-labelledby="dropdownMenu1">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="mymes">我的信息</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="mybooks">我的书库</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="myorder">我的订单</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="oldorder">历史订单</a></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								id="logout">退出</a></li>
						</ul>
					</div>
  		</div>
  		</div>
  	</div>
  	<div class="container">
  		<br>
  		<div class="row mymes">
  		未完成订单 —— 我买的书　<a class="updatemes" id="mysale">我卖的书</a>
  		<hr style="width:1200px;height:1px;border:none;border-top:1px solid #555555;">
  		</div>
		<br>
		<div style="margin:0 auto;color:white;height:500px; width:1025px; font-size:18px;background-image: url('<%=request.getContextPath()%>/plugins/image/xixi.png');">
			<br>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>编号</th>
						<th>书名</th>
						<th>破损度</th>
						<th>价格</th>
						<th>发布时间</th>
						<th>发布人</th>
						<th>下单时间</th>
						<th>是否支付</th>
						<th>是否收货</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.mybuy" status="sta" >
						<!-- mybooks 存储在了Root区域 -->
							<tr>
								<td><s:property value="#sta.count" /></td>
								<td><s:property value="book.bookname" /></td>
								<td><s:property value="book.damage" /></td>
								<td><s:property value="book.price" /></td>
								<td><s:property value="book.addtime" /></td>
								<td><s:property value="salername" /></td>
								<td><s:property value="ordertime" /></td>
								<s:if test="moneystatus == 0">
									<td><a href="javascript:paymoney(<s:property value="id" />,<s:property value="book.price" />)" title="点击支付"><i class="glyphicon glyphicon-usd">点击支付</i></a></td>
								</s:if>
								<s:else>
									<td>已支付</td>
								</s:else>
								<s:if test="status == 0">
								<td>未收货</td>
								</s:if>
								<s:else>
								<td>已收货</td>
								</s:else>
								<td><a href="javascript:overorder(<s:property value="id" />)" title="确认收货"><i class="glyphicon glyphicon-ok"></i></a>　<a href="javascript:cancelorder(<s:property value="id" />)" title="取消订单"><i class="glyphicon glyphicon-remove"></i></a></td>
							</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<div class=" bottom">
	<hr style="width:1170px;height:1px;border:none;border-top:1px solid #555555;">
		©2017/6/6 SSH大作业   201577G0649 张世文  旧书館 ---用旧书交換時光
	</div>
    <!-- jQuery  -->
    <script src="<%=request.getContextPath()%>/plugins/js/jquery-3.1.1.js"></script>
    <!-- Bootstrap -->
    <script src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.min.js"></script>
  </body>
<script type="text/javascript">
	$("#addbook").click(function() {
		window.location.href = "/OldBook/addbook";
	});
</script>
<script type="text/javascript">
	$("#mymes").click(function() {
		window.location.href = "/OldBook/mymes";
	});
</script>
<script type="text/javascript">
	$("#mybooks").click(function() {
		window.location.href = "/OldBook/mybooks";
	});
</script>
<script type="text/javascript">
	$("#myorder").click(function() {
		window.location.href = "/OldBook/myorder";
	});
</script>
<script type="text/javascript">
	$("#oldorder").click(function() {
		window.location.href = "/OldBook/oldorder";
	});
</script>
<script type="text/javascript">
	$("#mysale").click(function() {
		window.location.href = "/OldBook/mysale";
	});
</script>
<script type="text/javascript">
	$("#logout").click(function() {
		window.location.href = "/OldBook/hello";
	});
</script>
<script type="text/javascript">
	function paymoney(id,price){
		var mymessage=confirm("您确认要支付"+price+"吗？");
		 if(mymessage==true){
		 	window.location.href = "/OldBook/payorder?oid="+id;
		 }else{
		 	window.location.href = "/OldBook/myorder";
		 }
	}
	function overorder(id){
		var mymessage=confirm("确认收到书籍吗？");
		 if(mymessage==true){
		 	window.location.href = "/OldBook/overorder?oid="+id;
		 }else{
		 	window.location.href = "/OldBook/myorder";
		 }
	}
	function cancelorder(id){
		var mymessage=confirm("您确定要取消订单吗？");
		 if(mymessage==true){
		 	window.location.href = "/OldBook/cancelorder?oid="+id;
		 }else{
		 	window.location.href = "/OldBook/myorder";
		 }
	}
</script>
</html>