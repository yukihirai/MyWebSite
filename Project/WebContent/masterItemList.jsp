<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
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

    <title>masterItemList</title>

    <%
    	ArrayList<ItemDataBeans> idbList = (ArrayList<ItemDataBeans>)request.getAttribute("idbList");
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

	<form action="ItemSearch" method="POST">

		<br>
		<br>
		<br>
		<br>

		<div align="right"><a href="Master"><font size="4">戻る</font></a></div>
		<br>
		<br>
		<div class="row">
      		<div class="col-xs-6"></div>
      		<div class="form-group">
	    			<label class="control-label">
	    				<font size="4"><button type="submit" class="btn btn-success btn-sm">検索</button></font>
	    			</label>
	    			<div class="col-xs-3">
	    				<input  type="text" class="form-control" name="searchWord" placeholder="検索ワード">
	    			</div>
	    	</div>
	    </div>
	    <br>

		<div class="panel panel-success">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">登録商品一覧</font></div>
	    	</div>
	    	<div class="panel-body">
	    		<table class="table table-hover">
	    			<thead>
	    				<th>商品名</th>
	    				<th>金額</th>
	    				<th></th>
	    			</thead>
	    			<tbody>
	    			<%
	    				for(ItemDataBeans idb:idbList){
	    			%>
	    				<tr>
	    					<td><%=idb.getName()%></td>
	    					<td><%=idb.getPrice()%>円</td>
	    					<td>
	    						<a href="MasterItemDetail?itemId=<%=idb.getId()%>" class="btn btn-success btn-xs">詳細</a>
	    						<a href="MasterItemUpdate?itemId=<%=idb.getId()%>" class="btn btn-warning btn-xs">更新</a>
	    						<a href="masterItemDelete.html" class="btn btn-danger btn-xs">削除</a>
	    					</td>
	    				</tr>
					<%}%>
	    			</tbody>
	    		</table>
			</div>
	    </div>
	</form>

    </div> <!-- /container -->


  </body>
</html>
