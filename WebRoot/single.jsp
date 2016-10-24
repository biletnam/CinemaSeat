<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="true"%>
<%@ include file="bootstraphead.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'single.jsp' starting page</title>
    
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
      	   <div class="movie_top">
      	         <div class="col-md-9 movie_box">
                        <div class="grid images_3_of_2">
                        	<div class="movie_image">
                                <span class="movie_rating">5.0</span>
                                
                                <!-- 电影海报 --------------------------------------------------------------------->
                                <img src='<s:property value="movie.MPicon"/>' class="img-responsive" alt=""/>
                                
                                
                                <!-- ---------------------------------------------------------------------------- -->
                            </div>
                            <div class="movie_rate">
                            	<div class="rating_desc"><p>Your Vote :</p></div>
                            	<form action="" class="sky-form">
							     <fieldset>					
								   <section>
								     <div class="rating">
										<input type="radio" name="stars-rating" id="stars-rating-5">
										<label for="stars-rating-5"><i class="icon-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-4">
										<label for="stars-rating-4"><i class="icon-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-3">
										<label for="stars-rating-3"><i class="icon-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-2">
										<label for="stars-rating-2"><i class="icon-star"></i></label>
										<input type="radio" name="stars-rating" id="stars-rating-1">
										<label for="stars-rating-1"><i class="icon-star"></i></label>
									 </div>
								  </section>
							    </fieldset>
						  	   </form>
						  	   <div class="clearfix"> </div>
                            </div>
                        </div>
                        
                        
                        <!-- 电影信息 -->
                        <div class="desc1 span_3_of_2" style="height: 460px;">
                     	   <p class="movie_option"><strong>Name: </strong><s:property value="movie.MName"/></p>
                        	<p class="movie_option"><strong>Country: </strong>
                        			<a href="#"><s:property value="movie.MState"/></a>, <a href="#"><s:property value="movie.MCountry"/></a></p>
                        	<p class="movie_option"><strong>Year: </strong><s:property value="movie.MReldate"/></p>
                        	<p class="movie_option"><strong>Category: </strong>
                        			<s:property value="movie.MCategory"/>
                        	<p class="movie_option"><strong>Release date: </strong><s:property value="movie.MReldate"/></p>
                        	<p class="movie_option"><strong>Director: </strong>
                        			<a href="#"><s:property value="movie.MDirector"/> </a></p>
                        	<p class="movie_option"><strong>Actors: </strong>
                        			<s:property value="movie.MActors"/>
                            <p class="movie_option"><strong>Age restriction: </strong><s:property value="movie.MFitage"/></p> 
                             
                             
                             
                        <div class="clearfix"> </div>
                        </div>
                        <!----------------------------------------------------------------------------------------------------->
                        <div class="row" style="width:98%;margin-left: 0px">
                         	
                         	
                         </div>
                        
                        
                        
                        
                        <!----------------------------------------------------------------------------------------------------->
                         <div class="row" style="width:98%;margin-left: 0px">
                         	<table class="table table-hover table-bordered table-striped text-center" >
                         		<tr>
                         			<th class="text-center">放映日期</th>
                         			<th class="text-center">放映时间</th>
                         			<th class="text-center">语言版本</th>
                         			<th class="text-center">放映厅</th>
                         			<th class="text-center">票价</th>
                         			<th class="text-center">选座购票</th>
                         		</tr>
                         		
	                         		<s:iterator value="slist"> 
									  <tr>
										<td><s:property value="SShowdate"/></td>
									    <td><s:property value="SBegintime"/>  ~ <s:property value="SEndtime"/></td>
									    <td><s:property value="SVersion"/></td>
									    <td>1</td>
									    <td><s:property value="SPrice"/></td> 
	                         			<td><a href="seat_showSeat.action?mid=<s:property value="MId"/>&sid=<s:property value="SId"/>" target="_blank">
	                         				<button class="btn btn-warning">在线选座</button></a></td>   
	                         			</tr>      
									</s:iterator> 
                         
                         		
                         			             			
                         	</table>
                         	
                         	
                         </div>
                         
                         <%-- <div class="down_btn"><a class="btn1" href="#"><span> </span>Choose Seat</a></div> --%>
                         <!----------------------------------------------------------------------------------------------------->
                        <p class="m_4">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet.</p>
		                <form method="post" action="contact-post.jsp">
							<div class="to">
		                     	<input type="text" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
							 	<input type="text" class="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" style="margin-left:3%">
							</div>
							<div class="text">
			                   <textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message:</textarea>
			                </div>
			                <div class="form-submit1">
					           <input name="submit" type="submit" id="submit" value="Submit Your Message"><br>
					        </div>
							<div class="clearfix"></div>
                 		</form>
		                <div class="single">
		                <h1>10 Comments</h1>
		                <ul class="single_list">
					        <li>
					            <div class="preview"><a href="#"><img src="images/2.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
					                <div class="title">Movie  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.</p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					         <li>
					            <div class="preview"><a href="#"><img src="images/3.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
					                <div class="title">Wernay  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent </p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					         <li>
					            <div class="preview"><a href="#"><img src="images/4.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
					                <div class="title">mr.dev  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes in futurum. qui sequitur mutationem consuetudium lectorum. Mirum est notare quam littera gothica, quam nunc putamus parum claram,</p>
					            </div>
					           <div class="clearfix"></div>
					        </li>
					     	<li class="middle">
					            <div class="preview"><a href="#"><img src="images/5.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data-middle">
					                <div class="title">Wernay  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					        <li class="last-comment">
					            <div class="preview"><a href="#"><img src="images/6.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data-last">
					                <div class="title">mr.dev  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit </p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
					         <li>
					            <div class="preview"><a href="#"><img src="images/7.jpg" class="img-responsive" alt=""></a></div>
					            <div class="data">
					                <div class="title">denpro  /  2 hours ago  /  <a href="#">reply</a></div>
					                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
					            </div>
					            <div class="clearfix"></div>
					        </li>
			  			</ul>
                      </div>
                      </div>
                      
                      
                      <div class="col-md-3">
                      	
                      	  <div class="grid_2 col_1">
							<img src="images/pic2.jpg" class="img-responsive" alt="">
						   </div>
						   
						   
		               </div> 
                      <div class="clearfix"> </div>
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


