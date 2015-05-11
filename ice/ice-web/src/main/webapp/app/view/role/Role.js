Ext.define('Eway.view.role.Role',{

	alias : 'widget.role_role',
	extend : 'Eway.view.base.Panel',

	initComponent : function(){
		Ext.apply(this,{
			title : '角色管理',
			html : "<div style='color:red;font-size:50px;'>ROLE<div>",
			margin : '100'
		});
		this.callParent(arguments);
	}


});