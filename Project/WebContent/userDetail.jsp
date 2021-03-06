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

    <title>YOURDETAIL</title>
    <%
    	UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
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

	<br>
	<br>
	<br>
	<div class="well">
		<div class="row">
			<div class="row">
				<div class="col-xs-1"></div>
				<h1 class="col-xs-3 bg-primary h2">ログインID</h1>
				<div class="col-xs-2"></div>
				<h2 class="col-xs-3 bg-primary h2">ユーザ名</h2>
				<div class="col-xs-3"></div>
			</div>

			<div class="row">
	    		<div class="col-xs-1"></div>
	    		<p class="col-xs-3 break-word"><font size="5"><%=udb.getLogin_id()%></font></p>
	    		<div class="col-xs-2"></div>
	    		<p class="col-xs-3 break-word"><font size="5"><%=udb.getName()%></font></p>
	    		<div class="col-xs-3"></div>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<h3 class="col-xs-3 bg-primary h2">生年月日</h3>
	    		<div class="col-xs-2"></div>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<p class="col-xs-4 break-word"><font size="5"><%=udb.getFormatBirth_Date()%></font></p>
	    		<div class="col-xs-2"></div>
	    		<p class="col-xs-4 break-word"><font size="5"></font></p>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<h4 class="col-xs-4 bg-primary h2">登録日</h4>
	    		<div class="col-xs-1"></div>
	    		<h5 class="col-xs-4 bg-primary h2">更新日</h5>
	    	</div>

	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<div class="col-xs-4"><font size="5"><%=udb.getFormatCreate_date()%></font></div>
	    		<div class="col-xs-1"></div>
	    		<div class="col-xs-4"><font size="5"><%=udb.getFormatupdate_date()%></font></div>
	    	</div>
	    </div>
	</div>
	    <br>
	    <br>
	    <a href="UserList">戻る</a>



    </div> <!-- /container -->


  </body>
</html>
