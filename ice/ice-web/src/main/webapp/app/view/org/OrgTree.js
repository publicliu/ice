Ext.define('Eway.view.org.OrgTree',{

	alias : 'widget.org_orgtree',
	extend : 'Ext.tree.Panel',

	initComponent : function(){
		var store = Ext.create('Eway.store.org.OrgTree');
		Ext.apply(this,{
			border : true,
			title : '组织机构',
			rootVisible : true,
			store : store,
			lines : true
		});
		this.callParent(arguments);
	}



});