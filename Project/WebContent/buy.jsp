<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

 <title>buy</title>

 <%
	ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
	ArrayList<DeliveryMethodDataBeans> dmdbList = (ArrayList<DeliveryMethodDataBeans>) request.getAttribute("dmdbList");
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
	<form action="BuyConfirm" method="POST">


	    	<div class="panel panel-primary">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5">購入商品確認</font></div>
	    		</div>
	    		<div class="panel-body">
	    			<table class="table table-hover">
	    				<thead>
	    					<th>商品名</th>
	    					<th>金額</th>
	    				</thead>
	    				<tbody>
	    				<%for(ItemDataBeans idb : cart){%>
	    					<tr>
	    						<td><%=idb.getName()%></td>
	    						<td><%=idb.getPrice()%>円</td>
	    					</tr>
	    				<%}%>
	    				</tbody>

	    			</table>
	    		</div>
			</div>

			<div class="panel panel-success">
	    		<div class="panel-heading">
	    			<div class="panel-title"><font size="5">配達方法の確認</font></div>
	    		</div>
	    		<div class="panel-body">
	    			<table class="table table-hover">
	    				<thead>
	    					<th></th>
	    					<th>配達方法</th>
	    				</thead>
	    				<tbody>
	    					<tr>
	    						<td></td>
	    						<td>
	    							<select  class="form-control" name="delevary_method_id">
	    								<%for(DeliveryMethodDataBeans dmdb : dmdbList){%>
	    									<option value="<%=dmdb.getId()%>"><%=dmdb.getName()%></option>
	    								<%}%>
	    							</select>
	    						</td>
	    					</tr>
	    				</tbody>
	    			</table>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-3">
					<a href="Cart" class="btn btn-warning btn-xs"><font size="4">戻る</font></a>
				</div>
				<div class="col-xs-3">
					<button class="btn btn-success btn-xs" type="submit" name="action"><font size="4">購入</font></a>
				</div>
			</div>
	</form>

    </div> <!-- /container -->


  </body>
</html>
