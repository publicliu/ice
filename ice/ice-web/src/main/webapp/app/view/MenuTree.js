Ext.define('Eway.view.MenuTree', {

	alias : 'widget.menuTree',
	extend : 'Ext.tree.Panel',

	rootVisible : false,


	root : {
		text : '系统菜单',
		children : [{
			text : '系统首页',
			leaf : true,
			controller : 'index.Index'
		},{
			text : '人员管理',
			leaf : false,
			expanded : true,
			children : [{
				controller : 'user.User',
				text : '人员管理',
				leaf : true
			},{
				text : '机构管理',
				leaf : true,
				controller : 'org.Org'
			}]
		},{
			text : "权限管理",
			leaf : false,
			expanded : true,
			expanded : true,
			children : [{
				controller : 'role.Role',
				text : '角色管理',
				leaf : true
			},{
				controller : 'role.Group',
				text : '角色组管理',
				leaf : true
			}]
		},{
			text : '采样管理',
			leaf : false,
			expanded : true,
			children : [{
				text : '任务管理',
				leaf : true
			}]
		}]
	}

});