Ext.define('Eway.view.user.User',{

	alias : 'widget.user_User',
	extend : 'Eway.view.base.Panel',

	requires : [
		'Eway.view.user.FilterForm',
		'Eway.view.user.UserGrid',
		'Eway.view.org.OrgTree'
	],

	initComponent : function(){
		Ext.apply(this,{
			title : '用户管理',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'west',
				xtype : 'org_orgtree',
				width : 200
			},{
				region : 'center',
				layout : 'border',
				title : '用户管理',
				items : [{
					region : 'north',
					height : 100,
					xtype : 'user_filterform'
				},{
					region : 'center',
					xtype : 'user_usergrid'
				}]
			}]
		});
		this.callParent(arguments);
	}


});