function infoMessage(json) {
	valid(json);
	top.$.messager.alert('信息',json.message,'info');
}

function alertMessage(json) {
	valid(json);
	top.$.messager.alert('警报',json.message);
}

function errorMessage(json) {
	valid(json);
	top.$.messager.alert('错误',json.message,'error');
}

function questionMessage(json) {
	valid(json);
	top.$.messager.alert('有问题了',json.message,'question');
}

function warnMessage(json) {
	valid(json);
	top.$.messager.alert('警告',json.message,'warning');
}

function valid(json){
	if(json.statusCode=='301'){
		alert("当前会话已经过期，请重新登陆！");
		window.top.location.href=ctx;
	}
}

function message(json){
	if(json.statusCode=='300'){
		errorMessage(json);
	}else{
		infoMessage(json);
	}
}


function getPageArea() {
	if (document.compatMode == 'BackCompat') {
		return {
			width : Math.max(document.body.scrollWidth,
					document.body.clientWidth),
			height : Math.max(document.body.scrollHeight,
					document.body.clientHeight)
		}
	} else {
		return {
			width : Math.max(document.documentElement.scrollWidth,
					document.documentElement.clientWidth),
			height : Math.max(document.documentElement.scrollHeight,
					document.documentElement.clientHeight)
		}
	}
}