var _baseInfoTree = 
[
    { text: '公司管理', isexpand: false, children: [
		{ url: contextPath + "/corp/list", text: "公司信息" }
	]
    }, 
	{ text: '部门管理',isexpand:false, children: [ 
		{ url: contextPath + "/dept/list", text: "部门信息" }
	]},
	{ text: '账号管理',isexpand:false, children: [  
		{url:"demos/menu/evenmenu.htm",text:"账号管理"}
	]}
];
var _systemManagementTree = 
[
    { text: '公司管理', isexpand: false, children: [
		{ url: contextPath + "/corp/add", text: "新增" },
		{ url: contextPath + "/corp/list", text: "查询" }
	]
    }, 
	{ text: '部门管理',isexpand:false, children: [ 
		{ url: contextPath + "/dept/list", text: "部门管理" }
	]},
	{ text: '账号管理',isexpand:false, children: [  
		{url:"demos/menu/evenmenu.htm",text:"新增"},
		{url:"demos/menu/mulmenu.htm",text:"查询"}
	]},
	{ text: '角色管理',isexpand:false, children: [  
	    {url:"demos/menu/evenmenu.htm",text:"新增"},
	    {url:"demos/menu/mulmenu.htm",text:"查询"}
	]},
	{ text: '模块组管理',isexpand:false, children: [  
	    {url:"demos/menu/evenmenu.htm",text:"新增"},
	    {url:"demos/menu/mulmenu.htm",text:"查询"}
	]},
	{ text: '模块管理',isexpand:false, children: [  
		{url:"demos/menu/evenmenu.htm",text:"新增"},
		{url:"demos/menu/mulmenu.htm",text:"查询"}
	]}
];
/**
 * 自动生成菜单功能
 */
