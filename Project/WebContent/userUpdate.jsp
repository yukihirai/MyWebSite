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

    <title>userUpdate</title>

     <%
    	UserDataBeans udb = (UserDataBeans)request.getAttribute("udb");
     	String message = (String) request.getAttribute("message");
     	String defaultMessage = (String)request.getAttribute("defaultMessage");
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

	<form action="UserUpdateConfirm" method="POST">

	<br>
	<br>
	<br>


	<div class="panel panel-primary">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">ユーザ情報更新</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ログインID</font></label>
	    			<div class="col-xs-3">
	    				<font size="4"><%=udb.getLogin_id()%></font>
	    				<input type="hidden" name="login_id" value="<%=udb.getLogin_id()%>">
	    				<input type="hidden" name="userId" value="<%=udb.getId()%>">
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">ユーザ名</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="name" value="<%=udb.getName()%>" required>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">住所</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="address" value="<%=udb.getAddress()%>" required>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">誕生日</font></label>
	    			<div class="col-xs-3">
	    				<input type="date" class="form-control" name="birth_date" value="<%=udb.getBirth_date()%>" required>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">パスワード</font></label>
	    			<div class="col-xs-3">
	    				<input type="password" class="form-control" name="password">
	    			</div>
	    			<div class="col-xs-4">
	    					<%if(message != null){ %>
        						<font size="3" color="red"><%=message%></font>
        					<%} %><br>
        					<%if (defaultMessage != null){ %>
        						<font size="3" color="blue"><%=defaultMessage%></font>
        					<%} %>
	    			</div>
	    		</div>
	    		<br>
	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">パスワード(確認)</font></label>
	    			<div class="col-xs-3">
	    				<input type="password" class="form-control" name="password_confirm">
	    			</div>
	    		</div>
			</div>

	    	<div class="panel-footer">
	    		<div align="center">
	    			<button type="submit" class="btn btn-primary bt-sm">更新</button>
	    		</div>
	    	</div>
	    </div>
	    </form>
	    <br>
	    <br>
	    <a href="UserList">戻る</a>



    </div> <!-- /container -->


  </body>
</html>
