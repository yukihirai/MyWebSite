<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.UserDataBeans" %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>userList</title>
    <%
    ArrayList<UserDataBeans> udbList = (ArrayList<UserDataBeans>)request.getAttribute("udbList");
    int userId = (int)request.getAttribute("userId");
    %>


    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

		<ul class="nav nav-pills nav-justified">
			<li><a href="Index">HOME</a>
			<li><a href="Cart">CART</a></li>
			<li><a href="UserData">YOUR DATA</a></li>
			<li class="active"><a href="">USERS DATA</a></li>
			<%if(userId == 1){ %>
      			<li><a href="Master">商品登録</a></li>
      		<%}%>
		</ul>

		<br>
		<br>
		<br>

		<form action="UserSearch" method="POST">

		<div class="panel panel-primary">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">ユーザ検索項目</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ログインID</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="login_id" placeholder="sample">
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ユーザ名</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="name" placeholder="名無しのごんべ" >
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">誕生日</font></label>
	    			<div class="col-xs-3">
	    				<input type="date" class="form-control" name="fromBirth" >
	    			</div>
	    			<div class="col-xs-1"><font size="5">～</font></div>
	    			<div class="col-xs-3">
	    				<input type="date" class="form-control" name="toBirth" >
	    			</div>
	    		</div>
			</div>

	    	<div class="panel-footer">
	    		<div align="center">
	    			<button type="submit" class="btn btn-primary bt-sm">検索</button>
	    		</div>
	    	</div>
	    </div>

	    </form>

		<div class="panel panel-primary">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">ユーザ一覧</font></div>
	    	</div>
	    	<table class="table table-hover">
	    		<thead>
	    			<th>ログインID</th>
	    			<th>ユーザ名</th>
	    			<th>生年月日</th>
	    			<th></th>
	    		</thead>
	    		<tbody>
	    		<%
	    			for(UserDataBeans udb:udbList){
	    				if(userId == 1){
	    		%>
	    			<tr>
	    				<td><%=udb.getLogin_id()%></td>
	    				<td><%=udb.getName()%></td>
	    				<td><%=udb.getFormatBirth_Date()%></td>
	    				<td>
	    					<a href="UserDetail?userId=<%=udb.getId()%>" class="btn btn-primary btn-xs">詳細</a>
	    					<a href="UserUpdate?userId=<%=udb.getId()%>" class="btn btn-warning btn-xs">更新</a>
	    					<a href="UserDelete?userId=<%=udb.getId()%>" class="btn btn-danger btn-xs">削除</a>
	    				</td>
	    			</tr>
	    		<%}else{ %>
	    			<tr>
	    				<td><%=udb.getLogin_id()%></td>
	    				<td><%=udb.getName()%></td>
	    				<td><%=udb.getFormatBirth_Date()%></td>
	    				<td>
	    					<a href="UserDetail?userId=<%=udb.getId()%>" class="btn btn-primary btn-xs">詳細</a>
	    					<%if(userId == udb.getId()){ %>
	    						<a href="UserUpdate?userId=<%=udb.getId()%>" class="btn btn-warning btn-xs">更新</a>
	    					<%} %>
	    				</td>
	    			</tr>
	    			<%} %>
	    		<%} %>
	    		</tbody>

	    	</table>

	    </div>

    </div> <!-- /container -->


  </body>
</html>
