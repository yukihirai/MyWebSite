<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="beans.ItemDataBeans"%>
<%@ page import=" java.util.ArrayList"%>
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

    <title>ItemSearchresult</title>

    <%
		ArrayList<ItemDataBeans> itemList = (ArrayList<ItemDataBeans>) request.getAttribute("itemList");
		String searchWord = (String) session.getAttribute("searchWord");
		int pageMax = (int) request.getAttribute("pageMax");
		int pageNum = (int) request.getAttribute("pageNum");
		int itemCount = (int) request.getAttribute("itemCount");
	%>

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

    <br>
    <br>
    <br>
		<div class="form-group">
		<form action="ItemSearchResult">
			<div class="col-xs-4"></div>
	   		<label class="col-xs-1 control-label"><a href=""><button type="submit" class="btn btn-parimary">検索</button></a></label>
	   		<div class="col-xs-4">
	   			<input type="text" class="form-control" name="searchWord" size="100" maxlength="50" placeholder="検索ワード">
	   		</div>
	   	</form>
	   	</div>
	   	<br>
	   	<br>

	   	<div class="row">
	   		<div align="center"><font size="5">検索結果</font></div>
	   		<div align="center"><font size="5"><%=itemCount%>件</font></div>
	   	</div>

	   	<div align="left"><a href="Index"><font size="4">TOPページに戻る</font></a></div>

	   	<br>
	   	<br>

	    <div class="row">
	    <%
	    	int i = 0;
	    	for(ItemDataBeans idb : itemList){
	    		i++;

	    %>
	    	<div class="col-xs-3">
	    		<div class="well box">
	    			<a href="ItemDetail?itemId=<%=idb.getId()%>&page_num=<%=pageNum%>">
	    				<p class="textry"><font size="4"><%=idb.getName()%></font></p>
	    				<img src="pic/<%=idb.getFilm_name()%>" class="img-responsive img-thumbnail" alt="商品画像">
					</a>
					<div align="right"><font size="5"><%=idb.getPrice()%>円</font></div>

	    		</div>
	    	</div>
	    	<%if(i%4==0){%>
	    </div>
	    <div class="row">
	    	<%}%>
	    	<%}%>
	    </div>

	   <br>
	   <br>
	   <div class="row">
	   		<div align="center">
	   			<ul class="pagination">
	   				<%
					if (pageNum == 1) {
					%>
					<li class="disabled"></li>
					<%
						} else {
					%>
					<li><a href="<%="ItemSearchResult?searchWord=" + searchWord + "&page_num=" + (pageNum - 1)%>">＜</a></li>
					<%
						}
					%>
					<%
						for (int j = pageNum - 5; j <= pageNum + 5; j++) {
					%>
					<%
						if (j <= 0) {
								j = 1;
							}
					%>
					<li <%if (pageNum == j) {%> class="active" <%}%>><a href="<%="ItemSearchResult?searchWord=" + searchWord + "&page_num=" + j%>"><%=j%></a></li>
					<%
						if (pageMax <= j) {
								break;
							}
					%>
					<%
						}
					%>
					<%
						if (pageNum == pageMax || pageMax == 0) {
					%>
					<li class="disabled"></li>
					<%
						} else {
					%>
					<li><a href="<%="ItemSearchResult?searchWord=" + searchWord + "&page_num=" + (pageNum + 1)%>">＞</a></li>
					<%
						}
					%>
	   			</ul>
	   		</div>
	   </div>
    </div> <!-- /container -->


  </body>
</html>
