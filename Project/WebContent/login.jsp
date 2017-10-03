<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title>login</title>

    <%
		String message = (String) request.getAttribute("message");
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

      	<form action="LoginResult" class="form-signin" method="POST">
        	<h2 class="form-signin-heading">ログイン</h2><div align="right"><a href="UserRegistration">新規登録</a></div>
        	<br>
        	<%if(message != null){ %>
        		<div align="center"><font size="3" color="red"><%=message %></font></div>
        	<%} %>
        	<label for="inputEmail" class="sr-only">ログインID</label>
        	<input type="text" name="login_id" class="form-control" placeholder="ログインID" required autofocus>
       		<br>
        	<label for="inputPassword" class="sr-only">パスワード</label>
        	<input type="password" name="login_password" class="form-control" placeholder="パスワード" required>
        	<br>
        	<br>
        	<button class="btn btn-lg btn-primary btn-block" type="submit">ログイン</button>
      	</form>

    </div> <!-- /container -->


  </body>
</html>
