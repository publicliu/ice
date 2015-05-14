Ext.define('Eway.view.Header',{
	alias : 'widget.appHeader',
	extend : 'Ext.panel.Panel',
	layout : 'fit',
	html:'<div class="appHeader">' +
			'<span style="position: absolute;left: 10px;font-size:30px;">数据采样计划平台</span>' +
			'<span><img src="resources/images/banner_bg.png"  width="100%"/></span>' +
			'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' +
		 '</div>',
	 bbar: [{
	 	xtype : 'button',
	 	action : 'index',
	 	text: '系统首页'
     },'-',{
     	text: '人员管理',
     	menu : [{
     		action : 'person.Person',
     		text : '人员管理'
     	},{
     		action : 'user.User',
     		text : '用户管理'
     	},{
     		action : 'org.Org',
     		text : '机构管理'
     	}]
     },'-',{
     	text: '权限管理',
        menu: [{
        	action : 'role.Role',
        	text: '角色管理'
        },{
        	action : 'role.Group',
        	text : '角色组管理'
        }]
     },'-',{
     	text : '采样管理',
     	menu : [{
     		text : '采样计划',
     		action : 'sample.Plan'
     	}]
     },'->',{
     	text : ewayUser.getName(),
     	menu : [{
     		text : '修改密码'
     	},{
     		action : 'logout',
     		text : '退出'
     	}]
     }]
});