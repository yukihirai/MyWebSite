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

    <title>HOME</title>

     <%
	    int userId = (int)session.getAttribute("userId");
     	ArrayList<ItemDataBeans> itemList = (ArrayList<ItemDataBeans>)request.getAttribute("itemList");
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

	<ul class="nav nav-pills nav-justified">
		<li class="active"><a href="">HOME</a>
      	<li><a href="Cart">CART</a></li>
      	<li><a href="UserData">YOUR DATA</a></li>
      	<li><a href="UserList">USERS DATA</a></li>
      	<%if(userId == 1){ %>
      		<li><a href="Master">商品登録</a></li>
      	<%}%>
    </ul>

    <br>
    <br>
    <br>
    <div align="right"><a href="Logout"><font size="3" color="red">ログアウト</font></a></div>
    	<div class="row">
      		<div class="col-xs-6"></div>
      		<div class="col-xs-4">
      		<form action="ItemSearchResult">
      			<div class="form-group">
	    			<label class="control-label">
	    				<font size="4"><button type="submit" class="btn btn-success btn-sm">検索</button></font>
	    			</label>
	    			<div class="col-xs-8">
	    				<input  type="text" class="form-control" name="searchWord" placeholder="検索ワード">
	    			</div>
	    		</div>
	    	</form>
      		</div>
	    </div>
	    <br>
	    <div align="center"><font size="5"></font></div>
	    <br>

		<div class="row">
			<%for(ItemDataBeans idb:itemList){ %>
			<div class="col-xs-3">
				<div class="well box">
					<a href="ItemDetail?itemId=<%=idb.getId()%>">
						<p class="textry"><font size="4"><%=idb.getName()%></font></p>
						<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5"><%=idb.getPrice()%>円</font></div>
				</div>
			</div>
			<%}%>
		</div>

    </div> <!-- /container -->


  </body>
</html>
