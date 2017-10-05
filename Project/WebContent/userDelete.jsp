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

    <title>userDelete</title>

    <%
    	UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
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

    	<form action="UserDeleteResult" method="POST">

		<div class="row bg-danger">
      		<div class="row">
      			<div class="col-xs-1"></div>
      			<div class="col-xs-3">
      				<font size="5">ログインID</font>
      			</div>
      			<div class="col-xs-4">
      				<font size="5"><%=udb.getLogin_id()%></font>
      				<input type="hidden" name="userId" value="<%=udb.getId()%>"
      			</div>
	    	</div>
	    	<br>
	    	<br>
	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<div class="col-xs-5">
	    			<font size="5">を削除してもよろしいですか</font>
	    		</div>
	    	</div>
	    	<br>
	    	<div class="row">
	    		<div class="col-xs-1"></div>
	    		<div class="col-xs-2">
	    			<button type="submit" class="btn btn-primary bt-sm" name="confirm_button" value="cancel">キャンセル</button>
	    			<button type="submit" class="btn btn-danger bt-sm" name="confirm_button" value="delete">削除</button>
	    		</div>
	    	</div>
	    </div>

		</form>
    </div> <!-- /container -->


  </body>
</html>
