<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
  	<%@ include file = "/public/head.jspf" %>
  	<style type="text/css">
  		form div{
  		
  			margin: 5px;
  		}
  	</style>
  	<script type="text/javascript">
  		$(function(){
  			$("input[name=type]").validatebox({
  				required:true,
  				missingMessage:'请输入类别名称'
  			});
			$("#ff").form("disableValidation");
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
  				
  			});
  		});
  	</script>
  	
  </head>
  
  <body>
		<form id="ff" method="post">   
    		<div>
				<label for="type">类别名称:</label> 
				<input  type="text" name="type" />
			</div>
			<div>
				<label for="hot">热点:</label>
				热点:<input type="radio" name="hot" value="true" />
				非热点:<input type="radio" name="hot" value="false" checked="checked" />
			</div>
			<div>
				<a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加类型</a>
				<!-- <a id="submit" href="#" class="easyui-linkbutton">添 加</a>
				<a id="reset" href="#" class="easyui-linkbutton">重 置</a> -->
			</div>  
		</form>  
	
  </body>
</html>
