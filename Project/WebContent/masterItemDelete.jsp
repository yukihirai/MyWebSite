<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.ItemDataBeans" %>
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

    <title>masterItemDelete</title>

    <%
    	ItemDataBeans idb = (ItemDataBeans)request.getAttribute("idb");
    	String message = (String)request.getAttribute("message");
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
    <form action="MasterItemDeleteResult" method="POST">

	<div class="row bg-danger">
		<br>
		<div class="row">
			<div class="col-xs-1"></div>
			<div class="col-xs-5">
				<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive" alt="商品画像">
				<br>
				<br>
				<br>
				<%if(idb.getValue()==0){%>
				<font size="4">この商品はまだ評価されていません。</font>
				<%}else{%>
				<font size="4"><%=idb.getValue()%></font>
				<%}%>
			</div>

			<div class="col-xs-5">
				<div align="left"><font size="5"><%=idb.getName()%></font></div>
				<div align="right"><font size="5"><%=idb.getPrice()%>円</font></div>
				<br>
				<p class="break-word"><font size="5"><%=idb.getDetail()%></font></p>
				<br>
			</div>
			<div class="col-xs-1"></div>
		</div>
	</div>
	<br>
	<br>

	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-5">
			<font size="5">上記を削除してもよろしいですか</font>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-2">
			<input type="hidden" name="itemId" value="<%=idb.getId()%>">
			<input type="hidden" name="name" value="<%=idb.getName()%>">
			<input type="hidden" name="price" value="<%=idb.getPrice()%>">
			<input type="hidden" name="detail" value="<%=idb.getDetail()%>">
			<input type="hidden" name="film_name" value="<%=idb.getFilm_name()%>">
			<button type="submit" class="btn btn-primary bt-sm" name="result_button" value="cancel">キャンセル</button>
	    	<button type="submit" class="btn btn-danger bt-sm" name="result_button" value="delete">削除</button>
		</div>
	</div>
	</form>

    </div> <!-- /container -->


  </body>
</html>
