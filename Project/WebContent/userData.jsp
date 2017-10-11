<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.UserDataBeans"%>
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

    <title>YOURDATA</title>

    <%
		UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
    	int userId = (int)session.getAttribute("userId");
	%>

    <style type="text/css">
    p.break-word{word-wrap:break-word;}
    </style>

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
      	<li><a href="cart.html">CART</a></li>
      	<li class="active"><a href="">YOUR DATA</a></li>
      	<li><a href="UserList">USERS DATA</a></li>
      	<%if(userId == 1){ %>
      		<li><a href="Master">商品登録</a></li>
      	<%}%>
      </ul>

      <br>
      <br>
      <br>
		<div class="well">
			<div class="row">
				<div class="col-xs-1"></div>
				<h1 class="col-xs-3 bg-primary h2">名前</h1>
				<div class="col-xs-2"></div>
				<h2 class="col-xs-5 bg-primary h2">住所</h2>
				<div class="col-xs-1"></div>
			</div>

			<div class="row">
	    		<div class="col-xs-1"></div>
	    		<p class="col-xs-3 break-word"><font size="5"><%=udb.getName() %></font></p>
	    		<div class="col-xs-2"></div>
	    		<p class="col-xs-5 break-word"><font size="5"><%=udb.getAddress() %></font></p>
	    		<div class="col-xs-1"></div>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<h3 class="col-xs-3 bg-primary h2">ログインID</h3>
	    		<div class="col-xs-2"></div>
	    		<h4 class="col-xs-3 bg-primary h2">誕生日</h4>
	   			<div class="col-xs-1"></div>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<p class="col-xs-3 break-word"><font size="5"><%=udb.getLogin_id() %></font></p>
	   			<div class="col-xs-2"></div>
	    		<p class="col-xs-3 break-word"><font size="5"><%=udb.getFormatBirth_Date()%></font></p>
	    	</div>
	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<h3 class="col-xs-5 bg-primary h2">登録日</h3>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<p class="col-xs-5 break-word"><font size="5"><%=udb.getFormatCreate_date()%></font></p>
	    	</div>
	    </div>
	    <br>
	    <br><div align="right"><a href="UserUpdate?userId=<%=udb.getId()%>" class="btn btn-primary">更新</a></div>
	    <br>
	    <br>

	    <div class="panel panel-primary">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">購入履歴</font></div>
	    	</div>
	    	<table class="table table-striped">
	    		<thead>
	    			<th></th>
	    			<th>購入日時</th>
	    			<th>配達方法</th>
	    			<th>合計金額</th>
	    		</thead>
	    		<tbody>
	    			<tr>
	    				<td><a href="buyDetail.html" class="btn btn-primary btn-xs">詳細</a></td>
	    				<td>1111年22月33日44時55分66</td>
	    				<td>日時指定配送</td>
	    				<td>1796円</td>
	    			</tr>
	    		</tbody>

	    	</table>

	    </div>



    </div> <!-- /container -->


  </body>
</html>
