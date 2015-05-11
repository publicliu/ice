Ext.define('Eway.view.Viewport',{

	extend : 'Ext.container.Viewport',
	layout : 'border',

	requires : [
		'Eway.view.Header',
		'Eway.view.Workspace',
		'Eway.view.Menu',
		'Eway.view.MenuTree'
	],

	items : [{
		region : 'north',
		xtype : 'appHeader',
		height : 80
	}/*,{
		region : 'west',
		border : 1,
		width : 200,
		xtype : 'menuTree',
		margin :'2 2 2 0',
		collapsible: true,
		collapseDirection: Ext.Component.DIRECTION_LEFT,
		title : '系统菜单'
	}*/,{
		region : 'center',
		border : 0,
		xtype : 'appWorkspace',
		margin : '2 2 2 2'
	}]
});