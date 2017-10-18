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

<title>BuyDetail</title>

<%
   	ArrayList<ItemDataBeans> buyItemList = (ArrayList<ItemDataBeans>) request.getAttribute("buyItemList");
	BuyDataBeans bdb = (BuyDataBeans) request.getAttribute("resultBdb");
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


		<div class="row">
	    	<div class="panel panel-primary">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5">購入履歴</font></div>
	    		</div>
	    		<table class="table table-striped">
	    			<thead>
	    				<th>購入日時</th>
	    				<th>配達方法</th>
	    				<th>合計金額</th>
	    			</thead>
	    			<tbody>
	    				<tr>
	    					<td><%=bdb.getFormatCreate_date()%></td>
	    					<td><%=bdb.getDelivery_method_name()%></td>
	    					<td><%=bdb.getTotal_price() + bdb.getDelivery_method_price()%>円</td>
	    				</tr>
	    			</tbody>

	    		</table>

	    	</div>
		</div>

		<br>
		<br>
		<br>

		<div class="row">
	    	<div class="panel panel-success">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5">購入商品詳細</font></div>
	    		</div>
	    		<table class="table table-hover">
	    			<thead>
	    				<th>商品名</th>
	    				<th>金額</th>
	    			</thead>
	    			<tbody>
	    			<%for(ItemDataBeans idb : buyItemList){%>
	    				<tr>
	    					<td><%=idb.getName()%></td>
	    					<td><%=idb.getPrice()%>円</td>
	    				</tr>
	    			<%}%>
	    			</tbody>

	    		</table>

	    	</div>
	    </div>

		<a href="UserData">戻る</a>



    </div> <!-- /container -->


  </body>
</html>
