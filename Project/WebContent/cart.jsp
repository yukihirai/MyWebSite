<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.ItemDataBeans"%>
<%@page import="java.util.ArrayList"%>
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

    <title>cart</title>

	<%
	    int userId = (int)session.getAttribute("userId");
     	ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");
     	String message = (String)request.getAttribute("message");
     %>

     <style type="text/css">
    p.break-word{word-wrap:break-word;}
    p.textry{
  		width: 250px;
  		white-space: nowrap;
  		overflow: hidden;
 		text-overflow: ellipsis;
  		-o-text-overflow: ellipsis; /* Opera9,10対応 */
	}

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
    <form action="CartItemDelete" method="POST">

	<ul class="nav nav-pills nav-justified">
		<li><a href="Index">HOME</a>
      	<li class="active"><a href="">CART</a></li>
      	<li><a href="UserData">YOUR DATA</a></li>
      	<li><a href="UserList">USERS DATA</a></li>
      	<%if(userId == 1){ %>
      		<li><a href="Master">商品登録</a></li>
      	<%}%>
	</ul>

	<br>
	<br>
	<br>
	<div align="center">
		<font size="5">買い物かご</font><br>
		<font size="4" color="red"><%=message%></font>
	</div>

		<br>
		<div class="row">
			<div align="center"><a href="BuyConfilm" class="btn btn-primary"><font size="5">購入画面へ</font></a></div>
			<div align="right"><button class="btn btn-danger" type="submit" name="action">削除</button></div>
			<br>
		</div>

		<div class="row">
		<%
		int i = 0;
		for(ItemDataBeans idb : cart){
			i++;
		%>
			<div class="col-xs-3">
				<div class="well box">
						<p class="textry"><font size="4"><%=idb.getName()%></font></p>
						<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive img-thumbnail" alt="商品画像">
					<div align="right"><font size="5"><%=idb.getPrice()%>円</font></div>
					<div align="center">
						<input type="checkbox" id="<%=i%>" name="delete_item_id_list" value="<%=idb.getId()%>" />
					</div>
				</div>
			</div>
		<%
			if(i % 4 == 0){
		%>
		</div>
		<div class="row"></div>
		<%
			}
		%>
		<%
			}
		%>
	</form>

    </div> <!-- /container -->


  </body>
</html>
