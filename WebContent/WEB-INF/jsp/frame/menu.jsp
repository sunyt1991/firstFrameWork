<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx}/js/ztree/css/zTreeStyle/zTreeStyle.css">
<script type="text/javascript" charset="utf-8" src="${ctx}/js/ztree/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
	$(function(){
		var nodes = ${json.param};
		var setting = {
			view: {
				selectedMulti: false
			},
			check: {
				enable: false
			},
			data: {
				simpleData: {        
					enable: true
				}
			},
			callback:{
				onClick:function(event, treeId, treeNode){
				      if(treeNode.name=="主页"){
						  $('#center_tabs').tabs('select', '我的主页');  
						    refreshTab({tabTitle:'我的主页',url:'${ctx }/system/login.do?method=homepage'});   
            			    return;
						}
						
						if(treeNode.name=="密码修改"){
						   updatePassword();
						   
						   return;
						}
				
					if(treeNode.theUrl && !treeNode.isParent){
						if(treeNode.openType=="tab"){
							addTab(treeNode.name,treeNode.theUrl);
						}else if(treeNode.openType="window"){
							var div = "<div id='openWindow_"+treeNode.id+"' title='"+treeNode.name+"'></div>";
							var $div = $(div);
							if(treeNode.options){
								$div.attr("data-options",treeNode.options);
							}
							
							var content = '<iframe scrolling="auto" frameborder="0"  src="${ctx}/'+treeNode.theUrl+'&windowid=openWindow_'+treeNode.id+'" style="width:100%;height:99%;"></iframe>';
							var area = getPageArea();
							$div.window({
								width:area.width,
								height:area.height,
								content:content,
								onClose:function(){
									$(this).window("destroy");
								}
							});
						}
					}
					 
				}
			}

		};

	$.fn.zTree.init($("#left_menu"), setting, nodes);
	});
</script>
<ul id="left_menu" class="ztree"></ul>