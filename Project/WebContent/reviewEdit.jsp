<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.ReviewDataBeans"%>
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

    <title>reviewEdit</title>
    <%
    	ReviewDataBeans rdb = (ReviewDataBeans)request.getAttribute("rdb");
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
	<form action="ReviewEditResult" method="POST">

		<div class="panel panel-success">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">レビュー記入欄</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">見出しコメント</label>
	    			<div class="col-xs-9">
	    				<input type="text" class="form-control" name="head_comment" size="100" maxlength="50" value="<%=rdb.getHead_comment()%>" required>
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">レビュー内容</label>
	    			<div class="col-xs-10">
	    				<textarea class="form-control" name="controller.review" cols="150" rows="5" required><%=rdb.getReview()%></textarea>
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
	    		<button type="submit" class="btn btn-success bt-sm">更新</button>
	    	</div>
	    </div>
	    <input type="hidden" name="reviewId" value="<%=rdb.getId()%>">
	    <input type="hidden" name="itemId" value="<%=rdb.getItem_id()%>">

	    <br>
	    </form>

	    <a href="ItemDetail"><font size="4">戻る</font></a>



    </div> <!-- /container -->


  </body>
</html>
