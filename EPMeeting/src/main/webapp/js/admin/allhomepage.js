
//该函数为二层导航栏点击后的样式变换函数，在二层导航栏中监听
function changcss(obj){//obj为当前点击的li  id为当前Li所在ul的id
	var list=document.getElementById("menu").getElementsByTagName("a");
	for(var i=0;i<list.length;i++)
		list[i].className="asideInputNone";
	obj.className="asideInputNoneActivity";
}