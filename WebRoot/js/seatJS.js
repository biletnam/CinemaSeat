var $j = jQuery.noConflict();

$j(function()
{
	var state = $j("#seatstate").val();
	var s_state = state.replace(/,/g, "").replace(/@/g, "");
	
	for(var i = 0 ; i < s_state.length ; i++)
	{
		if(s_state.charAt(i) == "1")
		{
			$j("div[data-tooltip]").eq(i).addClass("row__seat--reserved");
		}
	}
});


//出票
function buyticket()
{
	var array = new Array(324);
	
	for(var i = 0 ; i < array.length ; i++)
	{
		debugger;
		//判断当前坐位状态  row__seat--selected为选中的
		if($j("div[data-tooltip]").eq(i).hasClass("tooltip"))
		{
			array[i] = 0;
			if($j("div[data-tooltip]").eq(i).hasClass("row__seat--reserved"))
			{
				array[i] = 1;
			}else if($j("div[data-tooltip]").eq(i).hasClass("row__seat--selected"))
			{
				array[i] = 2;
			}
		}
		
	}
	//吧字符数组存到一个字符串里面
	var str = "";
	for(var j = 0 ; j < array.length ; j++)
	{
		str = str.concat(array[j]);
		
		if((j+1)%18 == 0)
		{
			str = str.concat("@");
		}else
		{
			str = str.concat(",");
		}
	
	}
	
    window.location.href = "seat_createTicket.action?seatStr="+str;
}











