<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/jsp/common/meta.jsp"%>
<%@include file="/WEB-INF/jsp/common/easyuiInc.jsp"%>
<script type="text/javascript">
	var area=getPageArea();
	function add() {
		var url = "${ctx }/website/edit.action";
		$("<div id='website_edit_box' style='padding: 10px'></div>").show().dialog({
			width : 790,
			height : area.height,
			modal : true,
			href : url,
			title : '添加用户',
			buttons : [ {
				text : '确定',
				iconCls : 'icon-ok',
				handler : function() {
					$("#website_edit_form").submit();
				}
			}, {
				text : '取消',
				iconCls : 'icon-cancel',
				handler : function() {
					$("#website_edit_box").dialog("destroy");
				}
			} ],
		    onClose : function() {
               $(this).dialog('destroy');
            } 
		});
	}

	function edit() {
		var row = $("#website_list_box").datagrid("getSelected");
		if (row) {
			 $("<div id='website_edit_box' style='padding: 10px'></div>").show().dialog({
				width :790,
				height : area.height,
				modal : true,
				href : '${ctx}/website/edit.action?id=' + row.id,
				title : '修改用户信息',
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						$("#website_edit_form").submit();
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						$("#website_edit_box").dialog("destroy");
					}
				}],
		   	 	onClose : function() {
              		$(this).dialog('destroy');
            	} 
			});
		} else {
			warnMessage({
				"message" : "请选择一条数据"
			});
		}
	}

	function remove() {
		var row = $("#website_list_box").datagrid("getSelected");
		if (row) {
			$.messager.confirm('警示信息', '信息删除后不可恢复，确定吗?', function(r) {
				if (r) {
					$.post("${ctx}/website/isdelete.action?s_id=" + row.id,
							function(json) {
								infoMessage(json.message);
								if (json.statusCode == 200) {
									datagridReload(); 
								}
							}, "json");
				}
			});
		} else {
			warnMessage({
				"message" : "请选择一条数据"
			});
		}
	}
	
	function datagridReload(){
		$("#website_list_box").datagrid("reload");
	}
	
	function searchData(){
		$("#website_list_box").datagrid({
			url: '${ctx }/website/list.action?s_name='+encodeURI(encodeURI(($("#s_name").val())))+"&startmark="+encodeURIComponent($("#startmark").combobox('getValue'))
		});
	}
</script>
</head>
<body class="easyui-layout" border="false" id="engiLayout">
	<div region="center" border="false">
		<div id="tb" style="padding: 5px;">
			<a href="javascript:add();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a>
			<a href="javascript:edit();" class="easyui-linkbutton" data-options="iconCls:'icon-ex-edit',plain:true">修改</a> 
			<a href="javascript:remove();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
			<a href="javascript:reload();" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
			<div>
			登录名: <input class="easyui-textbox" style="width:150px" id="s_name">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="searchData();" data-options="iconCls:'icon-search',plain:true,disabled:false">查询</a>
			</div>
		</div>
	  <table id="website_list_box"  class="easyui-datagrid" data-options="toolbar:'#tb',striped:true, rownumbers:true,border:false,fit:true,pagination:true,singleSelect:true,pageSize:15,pageList:[10,15,20,30],fitColumns:true,
	  	url:'${ctx }/website/list.action'" >
			<thead>
				<tr>
					<th data-options="field:'id',hidden:true">ID</th>
				    <th data-options="field:'name',width:50,halign:'center',align:'left'">用户名</th>
				    <th data-options="field:'name',width:80,halign:'center',align:'left'">真实姓名</th>
				    <th data-options="field:'email',width:80,halign:'center',align:'left'">邮箱</th>
				    <th data-options="field:'state',width:50,halign:'center',align:'left'">状态</th>
			    </tr>
		    </thead>
	  </table>
	</div>
</body>
</html>
