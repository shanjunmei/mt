/**
 * 
 */

function rowSelect(o){
	if(o.selected){
		$(o).removeClass("selected");
		o.selected=undefined;
	}else{
		$(o).addClass("selected");
		o.selected=true;
	}
}
function confirmSelect(){
	
}
