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

    <title>reviewDeleteResult</title>
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


		<div class="panel panel-success">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">レビュー記入欄</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">見出しコメント</label>
	    			<div class="col-xs-9">
	    				<input type="text" class="form-control" name="head_comment" size="100" maxlength="50" value="<%=rdb.getHead_comment()%>" readonly>
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label">レビュー内容</label>
	    			<div class="col-xs-10">
	    				<textarea class="form-control" name="controller.review" cols="150" rows="5" readonly><%=rdb.getReview()%></textarea>
	    			</div>
	    		</div>
	    		<br>

	    		<br>

	    		<div class="form-group">
					<font size="4">評価　<%for(int i=0;i<rdb.getItem_value();i++){%>★<%}%><%for(int i=0;i<5-rdb.getItem_value();i++){%>☆<%}%></font>
	   			</div>
	   		</div>

	    </div>

	    <br>

	<div class="row">
		<div class="col-xs-2"></div>
		<div class="col-xs-5">
			<font size="5">を削除いたしました。</font>
		</div>
	</div>
	<br>
	<a href="ItemDetail?itemId=<%=rdb.getItem_id()%>" class="btn btn-warning"><font size="3">商品ページへ戻る</font></a>

</div> <!-- /container -->


  </body>
</html>
