<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
    <script>
    	$(function() {
    	  $('input[type=file]').after('<span></span>');

    	  // アップロードするファイルを選択
    	  $('input[type=file]').change(function() {
    	    var file = $(this).prop('files')[0];

    	    // 画像以外は処理を停止
    	    if (! file.type.match('image.*')) {
    	      // クリア
    	      $(this).val('');
    	      $('span').html('');
    	      return;
    	    }
    	 	// 新幅・高さ
    	    var new_w = 220;
    	    var new_h = 220;
    	 	// 画像表示
    	    var reader = new FileReader();
    	    reader.onload = function() {
    	      var img_src = $('<img>').attr('src', reader.result);

    	      var org_img = new Image();
    	      org_img.src = reader.result;
    	      org_img.onload = function() {
    	        // 元幅・高さ
    	        var org_w = this.width;
    	        var org_h = this.height;
    	        // 幅 ＜ 規定幅 && 高さ ＜ 規定高さ
    	        if (org_w < new_w && org_h < new_h) {
    	          // 幅・高さは変更しない
    	          new_w = org_w;
    	          new_h = org_h;
    	        } else {
    	          // 幅 ＞ 規定幅 || 高さ ＞ 規定高さ
    	          if (org_w > org_h) {
    	            // 幅 ＞ 高さ
    	            var percent_w = new_w / org_w;
    	            // 幅を規定幅、高さを計算
    	            new_h = Math.ceil(org_h * percent_w);
    	          } else if (org_w < org_h) {
    	            // 幅 ＜高さ
    	            var percent_h = new_h / org_h;
    	            // 高さを規定幅、幅を計算
    	            new_w = Math.ceil(org_w * percent_h);
    	          }
    	        }

    	        // リサイズ画像
    	        $('span').html($('<canvas>').attr({
    	          'id': 'canvas',
    	          'width': new_w,
    	          'height': new_h
    	        }));
    	        var ctx = $('#canvas')[0].getContext('2d');
    	        var resize_img = new Image();
    	        resize_img.src = reader.result;
    	        ctx.drawImage(resize_img, 0, 0, new_w, new_h);
    	      };
    	    }
    	    reader.readAsDataURL(file);
    	  });
    	});

    </script>

    <title>masterItemUpdate</title>

    <%
    	ItemDataBeans idb = (ItemDataBeans)request.getAttribute("idb");
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
	<form action="MasterItemUpdateConfirm" method="POST" enctype="multipart/form-data">

	<br>
	<br>
	<br>
	<div class="panel panel-warning">
	    	<div class="panel-heading">
	    		<div class="panel-title"><font size="5">商品情報更新</font></div>
	    	</div>

			<div class="panel-body">
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">商品名</font></label>
	    			<div class="col-xs-6">
	    				<input type="text" class="form-control" name="login_id" value="<%=idb.getName()%>" required>
	    			</div>
	    		</div>
	    		<br>

	    		<br>
	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">金額</font></label>
	    			<div class="col-xs-3">
	    				<input type="text" class="form-control" name="name" value="<%=idb.getPrice()%>" required>
	    			</div>
	    			<div class="col-xs-1">
	    				<font size="5">円</font>
	    			</div>
	    		</div>

	    		<br>
	    		<br>

	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">商品詳細</font></label>
	    			<div class="col-xs-9">
	    				<textarea class="form-control" name="review" cols="100" rows="5" placeholder="詳細" required><%=idb.getDetail()%></textarea>
	    			</div>
	    		</div>

	    		<br>
	    		<br>

	    		<div class="form-group">
	    			<label class="col-xs-2 control-label"><font size="4">商品画像</font></label>
	    			<div class="col-xs-3">
	    				<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive img-thumbnail" alt="商品画像">
	    			</div>
	    		</div>
			</div>

	    	<div class="panel-footer">
	    		<div align="center">
	    			<font size="4">上記の内容で更新いたしました。</font>
	    		</div>
	    	</div>
	    </div>
	    <br>
	    <br>
	    <a href="MasterItemList">戻る</a>

	</form>

    </div> <!-- /container -->


  </body>
</html>
