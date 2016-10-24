var $j = jQuery.noConflict();
var index=0;
$j(function()
{
	var panels = $j("div .panel-body1");
	
	panels.click(function(e){
		var divs = $j("div[childpanel]");
		//alert(e.target.attributes.getNamedItem("id").value);
		for(var j = 0 ; j < divs.length ; j++)
		{
			divs.eq(j).removeClass("show");
			divs.eq(j).addClass("hide");
		}
		for(var j = 0 ; j < divs.length ; j++)
		{
			if(divs.eq(j).attr("childpanel") == e.target.attributes.getNamedItem("id").value)
			{
				divs.eq(j).removeClass("hide");
				divs.eq(j).addClass("show");
			}
		}
		
		
		
	});
	
	
	//年龄
	var selected = document.getElementById("age_select");
	var optionArr = selected.getElementsByTagName("option");
	var len = optionArr.length;
	for(var i=0;i<len;i++){
		selected.remove(optionArr[i]);
	}
	for(var i = 1 ; i < 26 ; i++)
	{
		selected.options.add(new Option(i+"",i));
		selected.value = "18";
	}
	

});



//加分钟的方法
function judgFailTime(currentTime, timelength) {
	var myDate = new Date();
    var currentDate = myDate.toLocaleDateString().replace(/\//g,"-");
    var x = currentDate+" "+currentTime; // 取得的TextBox中的时间
    var time = new Date(x.replace("-","/"));
           
    //timelength分钟数
    time.setMinutes(time.getMinutes() + timelength, time.getSeconds(), 0);
    
    var hour = time.getHours();
    var min = time.getMinutes();
    var sec = time.getSeconds();
    
    return (hour+":"+min+":"+sec);
}


//添加场次
function addSeason()
{
	var nodehidden = parseInt(document.getElementById("nodehidden").value);
	
	var row = document.createElement("tr");
	var tbody = document.getElementById("stbody");
	
	var mpubdate = document.getElementById("mpubdate").value;
	var mbegintime = document.getElementById("mbegintime").value;
	var mpubroom = document.getElementById("mpubroom").value;
	var mversion = document.getElementById("mversion").value;
	var mprice = parseFloat(document.getElementById("mprice").value);
	
	nodehidden += 1;
	document.getElementById("nodehidden").value = nodehidden;
	
	for (var i = 0; i < 7; i++) {
		var col = document.createElement("td");
		
		switch(i){
		
			case 0:col.innerHTML = '<input type="text" name="slist['+index+'].SShowdate" class="form-control tabletext" value="'+mpubdate+'" readonly>';
			break;
			case 1:col.innerHTML = '<input type="text" name="slist['+index+'].SBegintime"  class="form-control tabletext"  value="'+mbegintime+'" readonly>';
			break;
			case 2:col.innerHTML = '<input type="text"  name="slist['+index+'].SEndtime" class="form-control tabletext"  value="'
						+judgFailTime(mbegintime,parseInt(document.getElementById("timelength").value))+'" readonly>';
			break;
			case 3:col.innerHTML = "1";
			//case 3:col.innerHTML = '<input type="text" class="form-control tabletext" name="slist.SShowdate" value="'+mpubroom+'" readonly>';
			break;
			case 4:col.innerHTML = '<input type="text" name="slist['+index+'].SVersion"  class="form-control tabletext"  value="'+mversion+'" readonly>';
			break;
			case 5:col.innerHTML = '<input type="text" name="slist['+index+'].SPrice"  class="form-control tabletext"  value="'+mprice+'" readonly>'; 
			break;
			case 6:col.innerHTML = '<a onclick="removeEle('+nodehidden+')">删除</a>';
			break;
			
		}
		
		
		row.setAttribute("id", "trnode"+nodehidden);
		row.appendChild(col);

	}
	
	
	tbody.appendChild(row);
	index++;
}


function removeEle(no) 
{ 
	//removeEle(no)
	var removeObj = document.getElementById("trnode" + no);
	removeObj.parentNode.removeChild(removeObj); 

}





//下架电影显示电影ajax
function showMovieSeasons(pIndex)
{
	$j("#undermovieDiv").html("");
	
	$j.post("underc_showMovieSeasons.action",{"pageIndex":pIndex},function(data)
	{
		var list = {};
		list.key = data;
		
		var tmpl = Mustache.render($j("#tmpl").html(), list);
		$j("#undermovieDiv").html(tmpl);
	});

}
//翻页
function changePage(eq)
{
	var pTotal = parseInt($j("#pageTotalhidden").val());
	var currenIndex = parseInt($j("#pageIndexhidden").val());
	
	var pIndex;
	if(eq == 1)
	{
		if(currenIndex < pTotal - 1)
		{
			pIndex = currenIndex + 1;
			$j("#pageIndexhidden").val(pIndex);
			showMovieSeasons(pIndex);
		}else{
			return;
		}
	}
	if(eq == -1)
	{
		if(currenIndex > 0)
		{
			pIndex = currenIndex - 1;
			$j("#pageIndexhidden").val(pIndex);
			showMovieSeasons(pIndex);
		}else{
			return;
		}
	}
}


//下架电影
function undercMovie(mid)
{
	$j.post("underc_undercMovie.action",{"mid":mid}, function(data)
	{
		var list = {};
		list.key = data;
		
		var tmpl = Mustache.render($j("#tmpl").html(), list);
		$j("#undermovieDiv").html(tmpl);
		
	});
	
}

function undercCfm(mid, mname) {  
    $j('#undercMidhidden').val(mid);//给会话中的隐藏属性URL赋值  
    $("#undercMNamehidden").val(mname);
    $('#delcfmModel').modal();  
    $j("#tiptext").text("确认要下架电影: " + $j("#undercMNamehidden").val() + " ?");
}  
function underC(){  
	debugger;
    var mid=$j.trim($j("#undercMidhidden").val());//获取会话中的隐藏属性URL  
    undercMovie(mid);
}  


















