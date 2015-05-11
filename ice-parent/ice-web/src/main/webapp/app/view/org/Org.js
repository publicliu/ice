Ext.define('Eway.view.org.Org',{

	alias : 'widget.org_Org',
	extend : 'Eway.view.base.Panel',

	requires : [
		'Eway.view.org.FilterForm',
		'Eway.view.org.OrgGrid',
		'Eway.view.org.OrgTree'
	],

	initComponent : function(){

		Ext.apply(this,{
			title : '机构管理',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'west',
				xtype : 'org_orgtree',
				width : 200
			},{
				region : 'center',
				layout : 'border',
				title : '机构管理',
				items : [{
					region : 'north',
					height : 100,
					xtype : 'org_filterform'

				},{
					region : 'center',
					xtype : 'org_orggrid'
				}]
			}]
		});
		this.callParent(arguments);
	}


});