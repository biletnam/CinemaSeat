<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="bootstraphead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>404error</title>
   

</style>
   
   
  </head>
  
  <body>
   <div class="container" style="margin-top: 300px">
   	<h1 class="text-warning">哦哟,交易失败!可能是坐位已经被抢了!</h1>
   	<a href='seat_showSeat.action?mid=<s:property value="mid"/>&sid=<s:property value="sid"/>' >
   		<button class="btn btn-primary">重新选择</button>
   	</a>
   </div>
   
  
  </body>
</html>
