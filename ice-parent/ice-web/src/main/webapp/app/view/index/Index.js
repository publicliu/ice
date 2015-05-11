Ext.define('Eway.view.index.Index',{

	alias : 'widget.index_index',
	extend : 'Ext.panel.Panel',

	initComponent : function(){
		Ext.apply(this,{
			title : '欢迎',
			html : "<div style='color:red;font-size:50px;'>ICE信息管理系统<div>",
			margin : '100'
		});
		this.callParent(arguments);
	}


});