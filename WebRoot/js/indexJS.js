var $j = jQuery.noConflict();

$j(function()
{
	$j.post("index_showMovie.action", function(data)
	{
		debugger;
		 var list = {};
		 list.key = data;
		
		 var temple = Mustache.render($j("#tmpl").html(), list);
		 $j("#moviecontent").html(temple);
		 
	});
	
	
});
