<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.ItemDataBeans"%>
<%@ page import="beans.ReviewDataBeans"%>
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

    <title>iteDetail</title>
    <%
    	ItemDataBeans idb = (ItemDataBeans)request.getAttribute("idb");
    	ArrayList<ReviewDataBeans>rdbList = (ArrayList<ReviewDataBeans>)request.getAttribute("rdbList");
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

	<div class="well">
		<div class="row">
			<div class="col-xs-6">
				<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive" alt="商品画像">
				<br>
				<a href="ItemAdd?itemId=<%=idb.getId()%>" class="btn btn-success"><font size="5">カートに入れる</font></a>
				<br>
				<br>
				<%if(idb.getValue()!=0){ %>
					<font size="4">ユーザ評価　<%=idb.getValue()%></font>
				<%}else{%>
					<font size="4">この商品はまだ評価されていません</font>
				<%}%>
			</div>
			<div class="col-xs-6">

				<div align="left"><font size="5"><%=idb.getName()%></font></div>
				<div align="right"><font size="5"><%=idb.getPrice()%>円</font></div>
				<br>
				<p class="break-word"><font size="5"><%=idb.getDetail()%></font></p>
				<br>
			</div>
		</div>
	</div>
	<a href="Index"><font size="4">戻る</font></a>
	<br>
	<br>

	<%if(!(rdbList == null)){%>

		<%for(ReviewDataBeans rdb : rdbList){%>
			<div class="panel panel-primary">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5"><%=rdb.getHead_comment()%></font></div>
	    			<font size="4">
	    				評価　<%for(int i=0;i<rdb.getItem_value();i++){%>★<%}%><%for(int i=0;i<5-rdb.getItem_value();i++){%>☆<%}%>
	    			</font>
	    			<br>
	    			<font size="4">
	    				名前　<%=rdb.getUser_name()%>
	    			</font>
	    		</div>
	    		<div class="panel-body">
	    			<p class="break-word">
	    				<font size="4">
	    					<%=rdb.getReview()%>
	    				</font>
	    			</p>
	    			<br>
	    			<div align="left"><%=rdb.getFormatCreate_date()%></div>
	    		</div>
	    		<div class="panel-footer">
	    		<%if(userId == rdb.getUser_id()){ %>
	    			<div align="right">
	    				<a href="ReviewEdit?reviewId=<%=rdb.getId()%>" class="btn btn-success btn-xs">編集</a>
	    				<a href="ReviewDelete?reviewId=<%=rdb.getId()%>" class="btn btn-danger btn-xs">削除</a>
	    			</div>
	    		<%}%>
	    		</div>
	   		 </div>
		<%}%>

	<%}else{%>
		<font size="4">この商品へのレビューはまだ投稿されていません。</font>
	<%} %>

	    <br>
	    <br>

	    <form action = "Review" method="POST">
	    <input type="hidden" name="itemId" value="<%=idb.getId()%>">

		<div class="panel panel-info">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">レビュー記入欄</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">見出しコメント</label>
	    			<div class="col-xs-9">
	    				<input type="text" class="form-control" name="head_comment" size="100" maxlength="50" placeholder="見出し" required>
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">レビュー内容</label>
	    			<div class="col-xs-10">
	    				<textarea class="form-control" name="review" cols="150" rows="5" placeholder="内容" required></textarea>
	    			</div>
	    		</div>
	    		<br>

	    		<br>

	    		<div class="form-group">
					<label class="col-xs-1 control-label">商品評価</label>
	    				<select name="item_value" required>
	    					<option value="5">5</option>
	    					<option value="4">4</option>
	    					<option value="3">3</option>
	    					<option value="2">2</option>
	    					<option value="1">1</option>
	   					</select>
	   			</div>
	   		</div>


	    	<div class="panel-footer">
	    		<button type="submit" class="btn btn-info bt-sm">送信</button>
	    	</div>
	    </div>
	    </form>


	    <br>

	    <a href="Index"><font size="4">戻る</font></a>



    </div> <!-- /container -->


  </body>
</html>
