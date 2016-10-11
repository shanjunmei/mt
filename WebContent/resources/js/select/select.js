/**
 * 
 */

window.alert=function(msg){
	var dialog=createDialog();//$('#_objectSelect');
	var dialogArgs = {
		title : '确定', // 标题文本，若不想显示title请通过CSS设置其display为none
		showTitle : true, // 是否显示标题栏。
		closeText : '[关闭]', // 关闭按钮文字，若不想显示关闭按钮请通过CSS设置其display为none
		draggable : false, // 是否移动
		modal : true, // 是否是模态对话框
		center : true, // 是否居中。
		fixed : true, // 是否跟随页面滚动。
		time : 0,
		resizable:false,
		close:function(e,ui){
			//source();
			$(this).remove();
			
		},
		buttons:[{text:'确定',click:function(){$(dialog).remove();}},
		         {text:'取消',click:function(){$(dialog).remove();}}
		],
		
	};
	$(dialog).html(msg,$(dialog).dialog(dialogArgs)); //
}
function createDialog(){
	var d=document.createElement("div");
	 $("body").append(d);
	 return d;
}
function openSelectDialog(title,url,source) {
	var dialog=createDialog();//$('#_objectSelect');
	var dialogArgs = {
		title : title, // 标题文本，若不想显示title请通过CSS设置其display为none
		showTitle : true, // 是否显示标题栏。
		closeText : '[关闭]', // 关闭按钮文字，若不想显示关闭按钮请通过CSS设置其display为none
		draggable : true, // 是否移动
		modal : true, // 是否是模态对话框
		center : true, // 是否居中。
		fixed : true, // 是否跟随页面滚动。
		time : 0,
		width:800,
		height:600,
		close:function(e,ui){
			//source();
			$(this).remove();
			
		},
		buttons:[{text:'选择',click:function(){source();$(dialog).remove();}},
		         {text:'取消',click:function(){$(dialog).remove();}}
		],
		
	};
	$(dialog).load(url,$(dialog).dialog(dialogArgs)); //
	
		
	// dialog(path);
	// window.open(url);
}
/**
 * 打开用户选择窗口
 * @param path
 */
function openUserSelect(path){
	console.log(path);
	var url="/user/select.html";
	url=path+url;
	openSelectDialog('用户选择',url,selectUser);
}
/**
 * 选择用户
 * @returns {___anonymous1926_1935}
 */
function selectUser(){
	var selectData;
	 $("#selectDataTable tr").each(function(trindex,tritem){
		if($(tritem).hasClass('selected')){
			selectData=new Object();
			selectData.id=$(tritem).attr('id');
			selectData.name=$(tritem).attr('name');
		};
    
     });
	
	 if(selectData){ 
		 console.log(selectData);
		 
		 //$('#user\\.id').val(selectData.id);
		// $('#user\\.name').val(selectData.name);
		 
		 $('#user\\.id').attr('value',selectData.id);
		 $('#user\\.name').attr('value',selectData.name);
		 return selectData;
	 }else{
		 alert('请先选择！');
	 }
}


/**
 * 打开用户选择窗口
 * @param path
 */
function openRoleSelect(path){
	console.log(path);
	var url="/role/select.html";
	url=path+url;
	openSelectDialog('角色选择',url,selectRole);
}
/**
 * 选择用户
 * @returns {___anonymous1926_1935}
 */
function selectRole(){
	var selectData;
	 $("#selectDataTable tr").each(function(trindex,tritem){
		if($(tritem).hasClass('selected')){
			selectData=new Object();
			selectData.id=$(tritem).attr('id');
			selectData.name=$(tritem).attr('name');
		};
    
     });
	
	 if(selectData){ 
		 console.log(selectData);
		 
		 //$('#user\\.id').val(selectData.id);
		// $('#user\\.name').val(selectData.name);
		 
		 $('#role\\.id').attr('value',selectData.id);
		 $('#role\\.name').attr('value',selectData.name);
		 return selectData;
	 }else{
		 alert('请先选择！');
	 }
}


/**
 * 打开用户选择窗口
 * @param path
 */
function openNewCategorySelect(path){
	console.log(path);
	var url="/newCategory/select.html";
	url=path+url;
	openSelectDialog('类别选择选择',url,selectNewCategory);
}
/**
 * 选择用户
 * @returns {___anonymous1926_1935}
 */
function selectNewCategory(){
	var selectData;
	 $("#selectDataTable tr").each(function(trindex,tritem){
		if($(tritem).hasClass('selected')){
			selectData=new Object();
			selectData.id=$(tritem).attr('id');
			selectData.name=$(tritem).attr('name');
		};
    
     });
	
	 if(selectData){ 
		 console.log(selectData);
		 
		 //$('#user\\.id').val(selectData.id);
		// $('#user\\.name').val(selectData.name);
		 
		 $('#category\\.id').attr('value',selectData.id);
		 $('#category\\.name').attr('value',selectData.name);
		 return selectData;
	 }else{
		 alert('请先选择！');
	 }
}

function E(o){
	return document.getElementById(o);
}