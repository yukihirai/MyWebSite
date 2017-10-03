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

    <title>HOME</title>
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
      	<li><a href="cart.html">CART</a></li>
      	<li><a href="UserData">YOUR DATA</a></li>
      	<li><a href="userList.html">USERS DATA</a></li>
    </ul>

    <br>
    <br>
    <br>
    	<div class="row">
      		<div class="col-xs-6"></div>
      		<div class="col-xs-4">
      			<input type="text" class="form-control" name="serchWord" placeholder="検索ワード">
      			<br>
      			<a href="searchResult.html"><div align="right"><button type="submit" class="btn btn-primary btn-xs">検索</button></div></a>
      		</div>
	    </div>
	    <br>
	    <div align="center"><font size="5"></font></div>
	    <br>

		<div class="row">
			<div class="col-xs-3">
				<div class="well box">
					<a href="itemDetail.html">
						<p class="textry"><font size="4">豚ちゃん蚊取り線香</font></p>
						<img src="pic/豚ちゃん蚊取り線香.jpg" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5">1296円</font></div>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="well box">
					<a href=".html">
						<p class="textry"><font size="4">猫の置物</font></p>
						<img src="pic/猫の置物.jpg" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5">798円</font></div>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="well box">
					<a href=".html">
						<p class="textry"><font size="4">ハロウィン人形（3体セット）</font></p>
						<img src="pic/ハロウィン人形.jpg" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5">9800円</font></div>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="well box">
					<a href=".html">
						<p class="textry"><font size="4">2人掛けカジュアルソファークッション付き</font></p>
						<img src="pic/ソファー.jpg" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5">11400円</font></div>
				</div>
			</div>
		</div>

    </div> <!-- /container -->


  </body>
</html>
