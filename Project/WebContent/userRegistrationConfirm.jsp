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

    <title>signUp</title>
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

<% UserDataBeans udb = (UserDataBeans)request.getAttribute("udb"); %>

	<div class="container">

	<form action="UserRegistrationResult" method="POST">



	<br>
	<br>
	<br>
	<div class="panel panel-primary">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">新規登録</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ログインID</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="login_id" value="<%=udb.getLogin_id()%>" readonly>
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ユーザ名</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="name" value="<%=udb.getName()%>" readonly>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">住所</font></label>
	    			<div class="col-xs-7">
	    				<input type="text" class="form-control" name="address" value="<%=udb.getAddress()%>" readonly>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">誕生日</font></label>
	    			<div class="col-xs-3">
	    				<input type="date" class="form-control" name="birth_date" value="<%=udb.getBirth_date()%>" readonly>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">パスワード</font></label>
	    			<div class="col-xs-3">
	    				<input type="password" class="form-control" name="password" value="<%=udb.getPassword()%>" readonly>
	    			</div>
	    		</div>
			</div>

	    	<div class="panel-footer">
	    		<div align="center">
	    			上記の入力内容でよろしいでしょうか。
	    			<button type="submit" class="btn btn-primary bt-sm" name="confirm_button" value="cancel">キャンセル</button>
	    			<button type="submit" class="btn btn-primary bt-sm" name="confirm_button" value="regist">登録</button>
	    		</div>
	    	</div>
	    </div>
	    <br>
	    <br>
	</form>



    </div> <!-- /container -->


  </body>
</html>
