Ext.define('Eway.view.role.Group',{

	alias : 'widget.role_group',
	extend : 'Eway.view.base.Panel',

	initComponent : function(){
		Ext.apply(this,{
			title : '角色组管理',
			html : "<div style='color:red;font-size:50px;'>RULEGROUP<div>",
			margin : '100'
		});
		this.callParent(arguments);
	}


});