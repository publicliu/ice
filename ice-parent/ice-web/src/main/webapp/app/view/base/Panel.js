Ext.define('Eway.view.base.Panel',{

	extend : 'Ext.panel.Panel',

	initComponent : function(){
		Ext.apply(this,{
			closable : true
		});
		this.callParent();
	}


});