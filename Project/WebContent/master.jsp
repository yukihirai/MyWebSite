<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    <title>master</title>

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
    <ul class="nav nav-pills nav-justified">
		<li><a href="Index">HOME</a>
      	<li><a href="cart.html">CART</a></li>
      	<li><a href="UserData">YOUR DATA</a></li>
      	<li><a href="UserList">USERS DATA</a></li>
      	<li class="active"><a href="">商品登録</a></li>
    </ul>

    <br>

    	<div class="row">
    		<div class="col-xs-2"></div>
    		<div class="col-xs-8 bg-info">
    			<div align="center"><font size="7">管理者用商品マスタ</font></div>
    		</div>
    	</div>
    	<br>

    	<div class="well">
    		<div class="row">
    			<div class="col-xs-1"></div>
    			<div class="col-xs-4">
    				<a href="MasterItemList" class="btn btn-success"><font size="5">商品一覧</font></a>
    			</div>
    			<div class="col-xs-1"></div>
    			<div class="col-xs-4">
    				<a href="MasterItemRegistration" class="btn btn-warning"><font size="5">商品新規登録</font></a>
    			</div>
			</div>
			<br>

			<div class="row">
				<div class="col-xs-1"></div>
				<div class="col-xs-4">
					<div class="break-word"><font size="5">登録されている商品の一覧を表示します。名前による検索も可能です。また、すべての商品を参照・更新・削除できます。</font></div>
				</div>
				<div class="col-xs-1"></div>
				<div class="col-xs-4">
					<div class="break-word"><font size="5">新規商品を登録します。登録項目は、商品名・商品詳細・商品価格・商品画像です。</font></div>
				</div>
			</div>
		</div>



    </div> <!-- /container -->


  </body>
</html>
