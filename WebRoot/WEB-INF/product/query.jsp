<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@ include file = "/public/head.jspf" %>
  	<script type="text/javascript">
$(function(){
	$('#dg').datagrid({
		url:'product_queryJoinCategory.action',
		loadMsg:"正在加载......",
		queryParams:{name:""}, //第一查询的时候发出额外参数
		idField:'id',
		striped:true,
		//autoRowHeight:false,   // 固定高度
		nowrap:true,  //如果为true，则在同一行中显示数据
		fitColumns:true,
		singleSelect:false, // 支持单行显示
		
		//rownumbers:true,  //显示行号
		pagination:true, //是否支持分页显示
		//pageNumber:1,  //初始页码
		pageSize:5,   // 每页显示的记录数
		pageList:[5,10,15,20],   // 初始化页面大小选择列表
		toolbar:[{
			iconCls: 'icon-add', 
			text:'添加商品',
			handler: function(){
				
				parent.$("#win").window({
					title:"添加商品",
					width:500,
					height:600,
					content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height = "100%" />'
				}); 
			}
		},'-',{
			iconCls: 'icon-edit',
			text:'更新商品',
			handler: function(){
				/* var rows=$("#dg").datagrid("getSelections");
				
				if(rows.length!=1){
				//alert("gengxin");
					$.messager.show({
						title : '更新错误提示!',
						msg : '只能更新一行',
						timeout : 2000,
						showType : 'slide'
					});
				}else{
					parent.$("#win").window({
						title:"更新类别",
						width:320,
						height:250,
						content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height = "100%" />'
					}); 
				} */
			}
		},'-',{
			iconCls: 'icon-remove',
			text:'删除类别',
			handler: function(){
				//删除选中行
				/* var rows = $('#dg').datagrid("getSelections");
				if(rows.length==0){
					$.messager.show({
						title : '删除错误提示!',
						msg : '要删除至少选中一行数据',
						timeout : 2000,
						showType : 'slide'
					});
				}else{
					 $.messager
					.confirm(
						'确认对话框',
						'确认要删除选中的行吗?',
						function(r) {
							if (r) {
								var ids = "";
								for ( var i = 0; i < rows.length; i++) {
									ids += rows[i].id + ",";
								}
								ids = ids.substring(0,ids.length - 1);
								//发送ajax请求
								$.post("category_deleteByIds.action"
									,{ids : ids}
									,function(result){
										if(result=="true"){
											$("#dg").datagrid("uncheckAll");
											$("#dg").datagrid("reload");
										}else{
											$.messager.show({
												title : '删除异常!',
												msg : '删除失败',
												timeout : 2000,
												showType : 'slide'
											});
										}
									}
									,"text"
								);
							}
						}); 
				} */
			}
		},'-',{
			text:"<input id='ss' name='search' />"
		}], 
		frozenColumns:[[
			{field:'xyz',checkbox:true},
			{field:'id',title:'商品编号',width:100}
		]],
	    columns:[[    
	            
	        {field:'name',title:'商品名称',width:200,
		        /* formatter: function(value,row,index){
		        	return "<span title="+value+">"+value+"</span>";
				}	 */
	        
	        },    
	        {field:'remark',title:'简单介绍',width:300,align:'right',  
		        /* formatter: function(value,row,index){
	        		//console.info("当前行索引:" + index +",当前行的对象:" + row + ",单元格值:" + value);
	        			if(value){
	        				return "<input type='checkbox' checked='checked' disabled='false' />"
	        			}else{
	        				return "<input type='checkbox'  disabled='true' />"
	        			
	        			}
	        	} */
	        		
	        },
	        {field:'category.type',title:'所属类别',width:200,
        	   formatter: function(value,row,index){
	        		if(row.category!=null&&row.category.type!=null){
	        			return row.category.type;
	        		}
				}
	        }
	    ]]
	});
	$("#ss").searchbox({ 
		// 响应搜索的事件，按type查询
		searcher:function(value,name){ 
			$('#dg').datagrid('load',{name:value});
			//alert(value + "," + name) 
		}, 
		prompt:'Please Input Value' 
	});  
});
</script>
  	
  	<style type="text/css">
  		body{
  		margin: 1px;
  		}
  		.searchbox {		 
			  margin: -3;		  
		}
  	</style>
  </head>
  
  <body>
		<table id="dg"></table>
		
  </body>
</html>
