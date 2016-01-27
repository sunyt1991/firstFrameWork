<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<style>
<!--
.w200{width:200px;}
-->
</style>
<script type="text/javascript">
	var id="${bean.id}";
	if(id != ""){
		$("#name").attr("readonly","readonly");
	}
	$("#admin_edit_form").form({
		method : 'post',
		url : "${ctx}/admin/save.action",
		onSubmit : function() {
			var flag= $(this).form('enableValidation').form('validate');
			if(flag){
				var row=$('#role_list_box').datagrid('getSelected');
				$("#roleid").val(row.id);
				if(!row){
					warnMessage({
						"message" : "请指定一种角色"
					});				
				}else{
					return true;
				}
			}
			return false;
		},
		success : function(json) {
			alert(json);
			if (json.statusCode == '200') {
				$("#admin_edit_box").dialog("destroy");
				datagridReload();
			}
			infoMessage(json.message);
		}
	});
	var roleid='${role.id}';
	function selectRoles(){
		var rows=$('#role_list_box').datagrid('getRows');
		for(var i=0;i<rows.length;i++){
		    if(rows[i].id==roleid){//如何i行符合要求
		        $('#role_list_box').datagrid('selectRow',i);//勾选此行
		    }
		}
	}
</script>
<form id="admin_edit_form" method="post" data-options="novalidate:true" class="easyui-form">
	<div class="easyui-layout" style="width:750px;height:400px;margin-top: 0px;margin-left: 0px;" >
		<div data-options="region:'north'" style="height:81px">
			<table width="100%" class="formTable" border="0">
				<tr>
					<td>用户名</td>
					<td><input name="loginname" id="loginname" class="easyui-textbox w200"  data-options="required:true,validType:'length[1,20]'"  value="${bean.loginname }"/></td>
					<td>密码</td>
					<td><input name="pwd" class="easyui-textbox w200" data-options="required:true,validType:'length[1,6]'"  value="${bean.pwd }"/></td>
				</tr>
				<tr>
					<td>真实姓名</td>
					<td><input name="name" id="name" class="easyui-textbox w200"  data-options="required:true,validType:'length[1,20]'"  value="${bean.name }"/></td>
					<td>邮箱</td>
					<td><input name="email" class="easyui-textbox w200" data-options="required:true,validType:'length[1,6]'"  value="${bean.email }"/></td>
				</tr>
			</table>
		</div>
		 <div data-options="region:'center',title:'拥有角色',iconCls:'icon-ok'">
		 	<table id="role_list_box"  class="easyui-datagrid" data-options="striped:true,fit:true, rownumbers:true,border:false,pagination:false,singleSelect:true,
	      		url:'${ctx }/role/list.action',onLoadSuccess:selectRoles" >
		                  <thead>
			               <tr>
			                 <th data-options="field:'ck',checkbox:true"></th>
				             <th data-options="field:'id',hidden:true">ID</th>
				             <th data-options="field:'name',width:100,halign:'center',align:'left'">名称</th>
				             <th data-options="field:'descn',width:180,halign:'center',align:'left'">描述</th>
			              </tr>
		                </thead>
	                  </table>
		 </div>
	</div>
	<input type="text" name="id" value="${bean.id }">
	<input type="" name="roleid" id="roleid">
</form>
