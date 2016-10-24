<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="bootstraphead.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Movie_store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- start plugins -->
	<script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
	<!-- <link href='http://fonts.useso.com/css?family=Roboto+Condensed:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'> -->

  </head>
  
  <body>
<div class="container">
	<div class="container_wrap">
		<div class="header_top">
		    <div class="col-sm-3 logo"><a href="index_input.action"><img src="images/logo.png" alt=""/></a></div>
		    <div class="col-sm-6 nav">
			  <ul>
				 <li> <span class="simptip-position-bottom simptip-movable" data-tooltip="comic"><a href="movie.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="movie"><a href="movie.jsp"> </a> </span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="video"><a href="movie.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="game"><a href="movie.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="tv"><a href="movie.jsp"> </a></span></li>
				 <li><span class="simptip-position-bottom simptip-movable" data-tooltip="more"><a href="movie.jsp"> </a></span></li>
			 </ul>
			</div>
			<!-- 登录后的头像------------------ -->
			<div class="col-sm-3 header_right">
			  	<ul class="header_right_box">
			  	
			  	<s:if test="#session.loginUser == null">
					<li><p><a href="regist_inputLogin.action">Login</a></p></li>
				</s:if>
				<s:else>
            		<li><p><s:property value="#session.loginUser.AAccount"/></a></p></li>
            		<li><a href="regist_Logout.action">
            		<button class="btn btn-warning"><font class="glyphicon glyphicon-log-out"></font> Logout</button></a>
            		</li>
       			</s:else> 
       			
				 <div class="clearfix"> </div>
			 	 </ul>
			</div>
			
			<!-- ------------------------------- -->
			<div class="clearfix"> </div>
	      </div>
	      
	      
	      <div class="content">
      	     <div class="register"> 
		  	 
		  	 
		  	 
		  	 <!-- 注册表单 -->
		  	 <form action="regist_registAccount.action" method="post" class="col-md-4">
			  	<div class="form-group">
			  	  	<label for="name">Username</label>
			    	<input type="text" class="form-control" placeholder="Username" name="AAccount">
			  	</div>
		  	 	
		  	 	<div class="form-group">
			  	  	<label for="name">Password</label>
			    	<input type="password" class="form-control" placeholder="Password" name="APassword">
			  	</div>
		  	 
		  	 <button type="submit" class="btn btn-danger"><font class="glyphicon glyphicon-plane"></font> Submit</button>
		  	 </form>
		  	 <!-- ------------------------------ -->
		  	 
		  	 
		  	 
				<div class="clearfix"> </div>
				<div class="register-but">
				</div>
		   </div>
           </div>
    </div>
</div>



<div class="container"> 
 <footer id="footer">
 	<div id="footer-3d">
		<div class="gp-container">
			<span class="first-widget-bend"> </span>
		</div>		
	</div>
    <div id="footer-widgets" class="gp-footer-larger-first-col">
		<div class="gp-container">
            <div class="footer-widget footer-1">
            	<div class="wpb_wrapper">
					<img src="images/f_logo.png" alt=""/>
				</div> 
	          <br>
	          <p>It is a long established fact that a reader will be distracted by the readable content of a page.</p>
			  <p class="text">There are many variations of passages of Lorem Ipsum available, but the majority have suffered.</p>
			 </div>
			 <div class="footer_box">
			  <div class="col_1_of_3 span_1_of_3">
					<h3>Categories</h3>
					<ul class="first">
						<li><a href="#">Dance</a></li>
						<li><a href="#">History</a></li>
						<li><a href="#">Specials</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Information</h3>
					<ul class="first">
						<li><a href="#">New products</a></li>
						<li><a href="#">top sellers</a></li>
						<li><a href="#">Specials</a></li>
					</ul>
		     </div>
		     <div class="col_1_of_3 span_1_of_3">
					<h3>Follow Us</h3>
					<ul class="first">
						<li><a href="#">Facebook</a></li>
						<li><a href="#">Twitter</a></li>
						<li><a href="#">Youtube</a></li>
					</ul>
					<div class="copy">
				      <p>Copyright &copy; 2015.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			        </div>
		     </div>
		    <div class="clearfix"> </div>
	        </div>
	        <div class="clearfix"> </div>
		</div>
	</div>
  </footer>
</div>		
</body>
</html>














