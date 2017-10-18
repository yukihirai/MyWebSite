<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.BuyDataBeans"%>
<%@ page import="beans.ItemDataBeans"%>
<%@ page import="beans.DeliveryMethodDataBeans"%>
<%@ page import="java.util.ArrayList"%>
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

<title>buyConfilm</title>

<%
   	BuyDataBeans bdb = (BuyDataBeans)session.getAttribute("bdb");
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


	    	<div class="panel panel-primary">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5">購入確認</font></div>
	    		</div>
	    		<div class="panel-body">
	    			<table class="table table-hover">
	    				<thead>
	    					<th>商品金額</th>
	    					<th>配送料</th>
	    					<th>合計金額</th>
	    				</thead>
	    				<tbody>
	    					<tr>
	    						<td><%=bdb.getTotal_price()%>円</td>
	    						<td><%=bdb.getDelivery_method_price()%>円</td>
	    						<td><%=bdb.getTotal_price()+bdb.getDelivery_method_price()%>円</td>
	    					</tr>
	    				</tbody>
	    			</table>
	    		</div>
			</div>


	<div class="row">
		<div class="col-xs-3"></div>
		<div class="col-xs-3">
			<a href="BuyResult" class="btn btn-success">購入</a>
		</div>
		<div class="col-xs-3">
			<a href="Cart" class="btn btn-danger">戻る</a>
		</div>
	</div>


    </div> <!-- /container -->


  </body>
</html>
