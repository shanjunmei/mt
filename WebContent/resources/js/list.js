/**
 * 
 */
function toList(){
	var href=window.location.href;
	
	var endPostion=href.lastIndexOf("/");

	href=href.substring(0, endPostion);
	

	href+='/list.html';
	window.location.href=href;
	/*href+='?id='+o;*/
	//window.open(href, '', null, null);
}
function toAdd(){
	var href=window.location.href;
	
	var endPostion=href.lastIndexOf("/");

	href=href.substring(0, endPostion);
	

	href+='/add.html';
	window.location.href=href;
	/*href+='?id='+o;*/
	//window.open(href, '', null, null);
}
function view(o){
	var href=window.location.href;
	
	var endPostion=href.lastIndexOf("/");

	href=href.substring(0, endPostion);
	

	href+='/view.html';
	href+='?id='+o;
	window.open(href, '', null, null);
}
function deleteRow(o){
	if(!confirm("确定删除？")){
		return;
	}
	var href=window.location.href;
	var s=href;
	
	var endPostion=href.lastIndexOf("/");

	href=href.substring(0, endPostion);
	

	href+='/delete.iv';
	//href+='?id='+o;
	
	//window.location.href=href;
	$.post(href,{id:o},function(ret,status){
		console.log(ret);
		
		if(!ret.ex){
			alert(ret.msg);
			window.location.href=s;
			window.location.reload(true);
			//window.location.href="#";
			
		}else{
			alert(ret.ex.message);
		}
	});
	
	//window.open(href, '', null, null);
}
function disableOrEnable(o){
	if(!confirm("确定禁用/启用？")){
		return;
	}
	var href=window.location.href;
	var s=href;
	
	var endPostion=href.lastIndexOf("/");

	href=href.substring(0, endPostion);
	

	href+='/disableOrEnable.iv';
	//href+='?id='+o;
	
	//window.location.href=href;
	$.post(href,{id:o},function(ret,status){
		alert(ret.msg);
		window.location.href=s;
	});
	
	//window.open(href, '', null, null);
}
function rowSelect(o){
	
	if(o.selected){
		$(o).removeClass("selected");
		o.selected=undefined;
	}else{
		$(o).addClass("selected");
		o.selected=true;
	}
}
function edit(o){
	var href=window.location.href;
	var endPostion=href.lastIndexOf('/');
	href=href.substring(0, endPostion);
	href+='/edit.html';
//	href=href.replace("/list", "/edit");
	href+='?id='+o;
	window.open(href, '', null, null);
}