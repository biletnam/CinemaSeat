<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../bootstraphead.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/CinemaSeat/css/sysmainstyle.css">
	<script type="text/javascript" src="/CinemaSeat/js/jquery-3.1.0.min.js"></script> 
	<script src="js/mustache.min.js"></script>
	<script type="text/javascript" src="/CinemaSeat/js/sysmainJS.js"></script>
	<script type="text/javascript" src="/CinemaSeat/97DatePicker/WdatePicker.js"></script>
	
	
	<script type="text/html" id="tmpl">
		{{#key}}
		<div class="panel " style="margin:1px">
		   		<a data-toggle="collapse" data-parent="#accordion"  href="{{amovie}}" style="color: white">
		        <div class="panel-heading" style="height:40px;padding-top: 5px;background-color: rgba(145,250,250,0.3);">
		                <table class="tablehead" >
		                	<tr>
		                		<td>{{movie.MName}}</td>
								<td>{{movie.MState}}, {{movie.MCountry}}</td>
								<td>{{movie.MDirector}}</td>
								<td>{{movie.MReldate}}</td>
								<td>{{movie.MTime}}</td>
								<td></td>
								<td>
										<a><font class="glyphicon glyphicon-edit"></font></a>
										<a href="javascript:void(0);" >
											<label  onclick="undercCfm('{{movie.MId}}', '{{movie.MName}}')">
												<font class="glyphicon glyphicon-trash"></font>
											</label></a>

											
								</td>
								
		                	</tr>
		                </table>
		        </div></a>


		        <div id="{{movie.MId}}" class="panel-collapse collapse">
				{{#slist}}
		        	<div class="panel-body" style="color: white;height:30px;padding-top: 5px;background-color: rgba(145,250,250,0.2);">
		        			<table class="tablebody" >
			           		 <tr>
					   			<td><span style="top:-15px;">{{SShowdate}}</span></td>
					   			<td><span style="top:-15px;">{{SBegintime}}</span></td>
								<td><span style="top:-15px;">{{SEndtime}}</span></td>
								<td><span style="top:-15px;">1</span></td>
								<td><span style="top:-15px;">{{SVersion}}</span></td>
								<td><span style="top:-15px;">{{SPrice}}</span></td>
								<td>
										<a><font class="glyphicon glyphicon-edit"></font></a>
										<a><font class="glyphicon glyphicon-trash"></font></a>
								</td>
							</tr>
							</table>
		        	</div>
		        
		        {{/slist}}
				</div>
		    </div>
			{{/key}}


	</script>
		
  </head>
  
  <body>
  
  <!-- 头部div -->
  <div class=" headdiv">
  	<font class="text-default">电影选座购票后台管理系统</font>
  </div>
  
  
  <!-- body div -->
	<div class="row" style="margin-top: 15px;width:100%;">
	  
	    <!-- 左边折叠-------------------------------------------------------------------------------------------- -->
		<div class="panel-group col-lg-2" id="accordion">
		    <!--  -->
		    <div class="panel mainbgc">
		    <a data-toggle="collapse" data-parent="#accordion"  href="#collapseOne" style="color: white">
		        <div class="panel-heading">
		               <font class="glyphicon glyphicon-film"></font>  电影管理
		        </div></a>
		        
		        <div id="collapseOne" class="panel-collapse collapse">
		        
		        	<div class="panel-body panel-body1" style="color: white;background-color: darkgray;height:30px">
			            <span class="panelchildcontent" id="pubmovie">上架电影</span>
		        	</div>
		        	<div class="panel-body panel-body1" style="color: white;background-color: darkgray;height:30px"
		        				onclick="showMovieSeasons(0)">
			            <span class="panelchildcontent" id="undercarriage">下架电影</span>
		        	</div>
		        	
		        </div>
		        
		    </div>
		    
		    <!--  -->
		    <div class="panel mainbgc">
		   		<a data-toggle="collapse" data-parent="#accordion"  href="#collapseTwo" style="color: white">
		        <div class="panel-heading">
		                <font class="	glyphicon glyphicon-list-alt"></font>  订单管理
		        </div></a>
		        
		        <div id="collapseTwo" class="panel-collapse collapse">
		        
		        	<div class="panel-body panel-body1" style="color: white;background-color: darkgray;height:30px">
			            <span class="panelchildcontent" id="showorder">查看订单</span>
		        	</div>
		        </div>
		        
		    </div>
		    <!--  -->
		    
		</div>
		
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<!-- 右边div----------------------------------------------------------------------------------------------- -->
		<div class="col-lg-10 businessdiv text-justify"  >
			<!-- 上架电影 -->
			<div childpanel="pubmovie" class="">
				
				<form class="form-inline" role="form" action="movie_addMovie.action" method="post" enctype="multipart/form-data">
				
					  <div class="form-group">
					    <label  for="name">名字</label>
					    <input type="text" class="form-control"  placeholder="请输入名称" name="movie.MName">
					  </div>
					  
					  
					  <!-- <div class="form-group" style="margin-left: 20px">
					    <label  for="name">发布日期</label>
					    <input type="text" class="form-control" name="movie.MReldate">
					  </div> --><br><br>
					 
					 <div class="form-group" >
					  	<label  for="name">国家</label>
						  <input type="text" class="form-control"  name="movie.MCountry">(国家)
						  <input type="text" class="form-control"  name="movie.MState">(省/州)
					 </div><br><br>
				
					 <div class="form-group">
					 <label for="name">类型</label>
						<div>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory" value="动作">动作
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="冒险">冒险
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="动漫">动漫
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="喜剧">喜剧
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="科幻">科幻
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="爱情">爱情
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="战争">战争
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="恐怖">恐怖
						  </label><br>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="传记">传记
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="犯罪">犯罪
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="剧情">剧情
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="家庭">家庭
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="历史">历史
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="音乐">音乐
						  </label>
						  <label class="checkbox-inline">
						    <input type="checkbox" name="movie.MCategory"  value="惊悚">惊悚
						  </label>
					  </div><br><br>
					  
					  <div class="form-group">
					    <label  for="name">导演</label>
					    <input type="text" class="form-control"  placeholder="请输入导演名字" name="movie.MDirector" >
					  </div><br><br>
					  
					  <div class="form-group">
					    <label  for="name">演员</label>
					    <textarea class="form-control" rows="3"  placeholder="多个演员之间用逗号分隔" style="width:400px" name="movie.MActors" ></textarea>
					  </div><br><br>
					  
					  <div class="form-group">
					    <label  for="name">年龄</label>
					    <select class="form-control" id="age_select" name="movie.MFitage" ></select>&nbsp;<font>最低年龄限制</font>
					  </div><br><br>
					  
					  <div class="form-group">
					    <label for="inputfile">海报</label>
					    <!-- <button type="button" class="btn btn-default" name="movie.MPicon" >上传</button> -->
					    <input type="file" value="上传" name="myfile">
					    
					    &nbsp;<font>支持jpg,jpeg等主流图片格式</font>
					  </div><br><br>
					  <!-- <div class="form-group" style="margin-left: 250px">
					    <label for="inputfile">预告图</label>
					    <button type="button" class="btn btn-default" name="movie.MIicon" >上传</button>&nbsp;<font>支持jpg,jpeg等主流图片格式</font>
					  	<input type="file" value="上传" name="myfile">
					  </div><br><br> -->
					  
					 
					  
					  <div class="form-group" >
					    <label  for="name">时长</label>
					    <input type="text" class="form-control" name="movie.MTime"  id="timelength">&nbsp;<font>分钟</font>
					  </div><br><br>
					   <!-- <div class="form-group" style="margin-left: 278px">
					    <label for="inputfile">预告片</label>
					    <button type="button" class="btn btn-default" name="movie.MVideo" >上传</button>&nbsp;<font></font>
					    <input type="file" value="上传" name="myfile[2]">
					  </div><br><br> -->
					  
					  
					  <div class="form-group">
					    <label  for="name">场次</label>
					   	<input type="text" class="form-control Wdate"  id="mpubdate"  placeholder="放映日期"
					   				onFocus="WdatePicker({lang:'zh-cn',readOnly:true})" style="height: 33px;border: 1px solid lightgray">
					 	<input type="text" class="form-control"  id="mbegintime"   placeholder="开始时间">
					 	<input type="text" class="form-control"  id="mpubroom"   placeholder="放映厅">
					  	<select class="form-control"  id="mversion" >
					  		<option>国语2D</option>
					  		<option>国语3D</option>
					  		<option>外语2D</option>
					  		<option>外语3D</option>
					  	</select>
					  	<input type="text" class="form-control"  id="mprice"  placeholder="票价(最多两位小数)">
						<button type="button" class="btn btn-warning" onclick="addSeason()">添加</button>
					 
					  <br>
					  <table class="table table-bordered table-striped table-hover"  style="margin-left: 32px;margin-top: 10px">
					   		<tr>
					   			<th>放映日期</th><th>开始时间</th>
								<th>结束时间</th><th>放映厅</th>
								<th>语言版本</th><th>票价</th><th>操作</th>
							</tr>
							
							<tbody id="stbody"></tbody>
					   	</table>
					   </div>
					   
					   
					   <input type="hidden" value="" id="slisthidden" name="slist">
					   
					   
					  <br><br><button type="submit" class="btn btn-info">提交</button>
				</form>
			</div>
			
				
			</div>
			
			
			
			<!-- 下架电影 -->
			<div childpanel="undercarriage" class="hide" >
				<div id="undermovieDiv" ></div>
				<div class="text-center" style="margin-top: 20px">
					<button class="btn btn-warning" onclick="changePage(-1)">&lt;</button>
					<button class="btn btn-warning" onclick="changePage(1)">&gt;</button>
				</div>
			</div>
		
			<!-- 查看订单 -->
			<div childpanel="showorder" class="hide">
				查看订单
			</div>
		
		<!-- ----------------------------------------------------------------------------------------------------- -->
		<div class="modal fade" id="delcfmModel">  
		  <div class="modal-dialog">  
		    <div class="modal-content message_align">  
		      <div class="modal-header">  
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>  
		        <h4 class="modal-title">提示信息</h4>  
		      </div>  
		      <div class="modal-body">  
		        <p id="tiptext"></p>  
		      </div>  
		      <div class="modal-footer">  
		         <input type="hidden" id="url"/>  
		         <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>  
		         <a  onclick="underC()" class="btn btn-primary" data-dismiss="modal">确定</a>  
		      </div>  
		    </div><!-- /.modal-content -->  
		  </div><!-- /.modal-dialog -->  
		</div><!-- /.modal -->  
		
</div>




<!-- 节点数量 -->
<input type="hidden" value="0" id="nodehidden">
<!-- 总页数 -->
<input type="hidden" value="<s:property value="pageTotal"/>" id="pageTotalhidden">
<!-- 当前索引 -->
<input type="hidden" value="0" id="pageIndexhidden">
<!-- 要下架的电影mid -->
<input type="hidden" value="0" id="undercMidhidden">
<!-- 要下架的电影名 -->
<input type="hidden" value="0" id="undercMNamehidden">
  </body>
</html>



















