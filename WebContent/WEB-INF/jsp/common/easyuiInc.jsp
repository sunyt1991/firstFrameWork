<%@ page language="java" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cookie/jquery.cookie.js"></script>
<script type="text/javascript">
var theme = "default";
var local = $.cookie("userTheme");
if(local){
	theme = local;
}
var easyHref="${pageContext.request.contextPath}/js/easyui/themes/"+theme+"/easyui.css";
document.write("<link rel='stylesheet' type='text/css' href='"+ easyHref +"' id='currentTheme'>");
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">

<script src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/easyui/easy-myexpand.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/easyui/easyui-lang-zh_CN.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/plugins/jquery.my97.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/json2.js" ></script>
<script  type="text/javascript">
	var ctx = "${pageContext.request.contextPath}";
	
	//处理键盘事件  
   function doKey(e){  
       var ev = e || window.event;//获取event对象  
       var obj = ev.target || ev.srcElement;//获取事件源  
       var t = obj.type || obj.getAttribute('type');//获取事件源类型  
       if(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea"){  
           return false;  
       }  
   }  
   //禁止后退键 作用于Firefox、Opera  
   document.onkeypress=doKey;  
   //禁止后退键  作用于IE、Chrome  
   document.onkeydown=doKey;  
   
</script>