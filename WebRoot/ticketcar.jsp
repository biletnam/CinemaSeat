<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="true"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="bootstraphead.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'ticketcar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  
  

    <div class="container">
    
    <h1 class="text-primary">Pay for tickets...<small>just a simulation...</small></h1>
    
    	<table class="table table-hover table-condensed table-striped table-bordered">
   			<tr>
   				<th>电影</th><th>场次</th><th>语言版本</th><th>放映厅</th><th>坐位</th><th>票价</th>
   			</tr>
			
			
			<s:set name="list1" value="#request.seatListRow"></s:set>
			<s:set name="list2" value="#request.seatListCol"></s:set>
	
			<s:iterator value="#list1" status="st">
			<tr>
				<td><s:property value="movie.MName"/></td>
  				<td><s:property value="season.SBegintime"/> ~ <s:property value="season.SEndtime"/></td>
  				<td><s:property value="season.SVersion"/></td>
   				<td>1</td>
   				<td> <s:property/>排<!--直接输出list1迭代的内容-->
						 <s:property value="#list2[#st.index]"/>座<!--输出list1迭代索引对应的list2的内容-->
						 </td>
   				<td><s:property value="season.SPrice"/></td>
   			</tr>
   			</s:iterator>
   			
   			<tr>
   				<td colspan="5" class="text-right">总价:</td>
   				<td><s:property value="#request.sumPrice"/></td>
   			</tr>
   			
   		</table>
    </div>
    
    <div class="container text-right">
    
   			 <s:if test="#session.loginUser == null">
					<a href="regist_inputLogin.action" target="blank">
				</s:if>
				<s:else>
            		<a href="seat_payTickets.action">
       			</s:else> 
    		<button class="btn btn-warning" >支付</button></a>
    </div>
    
  </body>
</html>
