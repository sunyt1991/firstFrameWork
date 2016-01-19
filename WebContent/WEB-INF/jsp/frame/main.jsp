<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${config.systemName }</title>
<meta name="Keywords" content="${config.systemKeyword }" />
<meta name="Description" content="${config.systemDescription }" />
<%@include file="/WEB-INF/jsp/common/meta.jsp"%>
<%@include file="/WEB-INF/jsp/common/easyuiInc.jsp"%>
<script type="text/javascript">
	$(function() {
		//绑定tabs的右键菜单  
		$("#center_tabs").tabs({
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#tabsMenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data("tabTitle", title);
			}
		});

		//右键菜单
		$("#tabsMenu").menu({
			onClick : function(item) {
				updateOrCloseTab(this, item.name);
			}
		});

		//主题
		var themes = [ {
			value : 'default',
			text : '默认风格',
			group : 'Base'
		}, {
			value : 'metro',
			text : 'win8风格',
			group : 'Base'
		}, {
			value : 'bootstrap',
			text : '扁平风格',
			group : 'Base'
		}, {
			value : 'gray',
			text : '灰色风格',
			group : 'Base'
		}, {
			value : 'black',
			text : '黑色风格',
			group : 'Base'
		}, {
			value : 'metro-gray',
			text : '灰色风格',
			group : 'metro'
		}, {
			value : 'metro-green',
			text : '绿色风格',
			group : 'metro'
		}, {
			value : 'metro-orange',
			text : '橙色风格',
			group : 'metro'
		}, {
			value : 'metro-red',
			text : '红色风格',
			group : 'metro'
		}, {
			value : 'ui-cupertino',
			text : '苹果风格',
			group : 'ui'
		}, {
			value : 'ui-pepper-grinder',
			text : '土黄风格',
			group : 'ui'
		} ];
		$('#cb-theme').combobox({
			width : 100,
			data : themes,
			editable : false,
			panelHeight : 'auto',
			onChange : onChangeTheme
		});

	});

	//几个关闭事件的实现  
	function updateOrCloseTab(menu, type) {
		var curTabTitle = $(menu).data("tabTitle");
		var tabs = $("#center_tabs");

		if(type === "refresh"){
			var currTab =  self.parent.$('#center_tabs').tabs('getSelected');
			var url = $(currTab.panel('options').content).attr('src');
			var content = '<iframe scrolling="auto" frameborder="0"  src="'
				+ url + '" style="width:100%;height:100%;"></iframe>';
		    self.parent.$('#center_tabs').tabs('update', {
		      tab : currTab,
		      options : {
		       content : content
		      }
		     });
			return;
		}
		
		if (type === "close" && curTabTitle != "我的主页") {
			tabs.tabs("close", curTabTitle);
			return;
		}

		var allTabs = tabs.tabs("tabs");
		var closeTabsTitle = [];
		$.each(allTabs, function() {

			var opt = $(this).panel("options");
			if (opt.closable && opt.title != curTabTitle && type === "Other") {
				closeTabsTitle.push(opt.title);
			} else if (opt.closable && type === "All") {
				closeTabsTitle.push(opt.title);
			}
		});

		for (var i = 0; i < closeTabsTitle.length; i++) {
			tabs.tabs("close", closeTabsTitle[i]);
		}
	}

	function addTab(text, url, c) {

		if ($("#center_tabs").tabs('exists', text)) {
			$('#center_tabs').tabs('select', text);
		} else {
			var content = '<iframe scrolling="auto" frameborder="0"  src="'
					+ url + '" style="width:100%;height:100%;"></iframe>';
			$('#center_tabs').tabs('add', {
				title : text,
				closable : true,
				content : content
			});
		}
		return false;
	}

	function deleteTab(text) {
		$('#center_tabs').tabs('close', text);
	}
	
	function closeCurrentTab(){
		$.messager.confirm('警示信息', '关闭当前页面，确定吗?', function(r) {
			if(r){
				var tab = $('#center_tabs').tabs('getSelected');
				var index = $('#center_tabs').tabs('getTabIndex',tab);
				console.info(index);
				$('#center_tabs').tabs('close',index);
				return;
			}
		});
	}

	function onChangeTheme(theme) {
		var link = $('#currentTheme');
		link.attr('href', '${ctx}/js/easyui/themes/' + theme + '/easyui.css');
		//$.cookie("userTheme",theme);
		$.cookie("userTheme", theme, {
			expires : 7,
			path : '/'
		});
	}

	function logout() {
		$.messager.confirm('警示信息', '您确定要离开吗?', function(r) {
			if (r) {
				$.post('${ctx}/logout.action', function(json) {
					if (json.statusCode == '200') {
						window.location.href = "${ctx}";
					}
				}, "json");
			}
		});
	}
</script>
</head>
<body class="easyui-layout" id="indexlayout" >
	<div data-options="region:'north',border:false" id="header"  class="banner_bg">
		<div class="bannerright">
			<span class="txt"></span>
			<div class="clear"></div>
			<div style="margin-right: 10px;">
				<div class="fr">
					 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-logout" plain="true" size='large' onclick="logout()" title="退出"></a>
				</div>
				<div class="fr txt" style="line-height: 45px;">您好  管理员</div>
			</div>
		</div>
		<!-- 这里是banner的前景区 class="bannerarea"${config.systemBanner }-->
		<div  class="bannerarea"></div>
		<div class="clear"></div>
	</div>
	<div id="menuDiv" data-options="region:'west',split:true,title:'系统功能',href:'${ctx }/role/leftmenu.action'" style="width: 190px;"></div>

	<div data-options="region:'south',border:false">
		<div class="bottom">
			<div class="copyright">版权所有:<strong>${config.systemCopyright }</strong></div>
		</div>
	</div>
	
	<div data-options="region:'center'">
		<div id="center_tabs" class="easyui-tabs" data-options="tools:'#changeTheme',border:false,fit:true">
			<div title="欢迎" href="${ctx }/welcom.jsp"></div>
		</div>
	</div>

	<div id="changeTheme" style="padding: 2px; height: auto; border-top: none; border-right: none">
		<img src="${ctx }/images/skin.png" alt="" style="vertical-align: middle;" /><select id="cb-theme"></select>
	</div>

	<div id="tabsMenu" class="easyui-menu" style="width: 120px;direction: none;">
		<div name="refresh">刷新当前</div>
		<div class="menu-sep"></div>
		<div name="close">关闭当前</div>
		<div class="menu-sep"></div>
		<div name="Other">关闭其他</div>
		<div class="menu-sep"></div>
		<div name="All">关闭所有</div>
	</div>
</body>
</html>

