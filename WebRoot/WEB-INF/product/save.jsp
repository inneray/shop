<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的JSP片段 -->
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
		    $.extend($.fn.validatebox.defaults.rules,{
		    	format:{
		    		validator:function(value,param){
		    			var ext = value.substring(value.lastIndexOf('.')+1);
		    			var arr = param[0].split(",");
		    			for(var i=0;i<arr.length;i++){
		    				if(ext==arr[i])
		    					return true;
		    			}
		    			return false;
		    			//return value==$(param[0]).val();
		    		},
		    		message:'文件格式必须为:{0}'
		    	}
		    	
		    });
		    
			$("input[name=name]").validatebox({
  				required:true,
  				missingMessage:'请输入商品名称'
  			});
  			$("input[name=price]").numberbox({
  				required:true,
  				missingMessage:'请输入商品价格',
  				min:0,
  				precision:2,
  				prefix:'$'
  			}); 
  			$("input[type=file]").validatebox({
  				required:true,
  				missingMessage:'请上传商品图片',
  				validType:"format['gif,jpg,jpeg,png']"
  			});
  			$("input[type=file]").change(function(){
  				$(this).validatebox("validate");
  			}); 
  			$("textarea[name=remark]").validatebox({
  				required:true,
  				missingMessage:'请输入商品简单描述'
  			});
  			
  			$('#cc').combobox({    
			    url:'category_query.action',    
			    valueField:'id',    
			    textField:'type',
			    panelHeight:'auto',
			    panelWidth:120,
			    width:120,
			    editable:false,   
			    required:true,
			    missingMessage:'请选择所属类别'
			}); 
			
			$("#ff").form("disableValidation");
			$("#submit").click(function(){
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					$('#ff').form('submit', {    
		    			url:'product_save.action',    
		    			success:function(){
		    				parent.$("#win").window("close");
		    				parent.$("iframe[title='商品管理']")
		    				.get(0).contentWindow.$("#dg").datagrid("reload");
		    				
		      			 // 如果成功 则重置表单数据
		       			//$("#ff").form("disableValidation");
		       			//$("#ff").form("reset");
		    			}	    
					});  
  				}
  				
  			});
  			$("#reset").click(function(){
  				$("#ff").form("reset");
  			});
		});
	</script>
	<style type="text/css">
		form div{
			margin: 10px;
		}
	</style>
	<!-- <script type="text/javascript">
  		$(function(){
  			alert("jhehe");
  			$("input[name=name]").validatebox({
  				required:true,
  				missingMessage:'请输入商品名称'
  			});
  			$("input[name=price]").numberbox({
  				required:true,
  				missingMessage:'请输入商品价格'，
  				min:0,
  				precision:2,
  				prefix:'$'
  			});
  			
			/* $("#ff").form("disableValidation");
  			$("#btn").click(function(){
  				$("#ff").form("enableValidation");
  				if($("#ff").form("validate")){
  					$('#ff').form('submit', {    
		    			url:'category_save.action',    
		    			success:function(){
		    				parent.$("#win").window("close");
		    				parent.$("iframe[title='类别管理']")
		    				.get(0).contentWindow.$("#dg").datagrid("reload");
		    				
		      			 // 如果成功 则重置表单数据
		       			//$("#ff").form("disableValidation");
		       			//$("#ff").form("reset");
		    			}	    
					});  
  				}
  				
  			}); */
  		});
  	</script> -->
</head>

<body>
<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
	<div>
		<label>商品名称:</label> <input type="text" name="name" />
	</div>
	<div>
		<label>商品价格:</label> <input type="text" name="price" />
	</div>
	<div>
		<label>图片上传:</label> <input type="file" name="fileImage.upload" />
	</div>
	<div>
		<label>所属类别：</label> 
		<input id="cc" name="category.id">
		</input>
	</div>
	<div>
		<label>加入推荐:</label> 推荐:<input type="radio" name="commend"
			checked="checked" value="true" />  不推荐:<input type="radio"
			name="commend" value="false" /> 
	</div>
	<div>
		<label>是否有效:</label>
		上架:<input type="radio" name="open" checked="checked"value="true" />
		下架:<input type="radio" name="open" value="false" />
				
	</div>
	<div>
		<label>简单描述:</label>
		<textarea name="remark" cols="40" rows="4"></textarea>
	</div>
	<div>
		<label>详细描述:</label>
		<textarea name="xremark" cols="40" rows="8"></textarea>
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
</form>
</body>
</html>
