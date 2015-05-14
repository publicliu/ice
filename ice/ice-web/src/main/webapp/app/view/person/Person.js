Ext.define('Eway.view.person.Person',{

	alias : 'widget.person_person',
	extend : 'Eway.view.base.Panel',

	requires : [
		'Eway.view.person.FilterForm',
		'Eway.view.person.PersonGrid',
		'Eway.view.org.OrgTree'
	],

	initComponent : function(){
		Ext.apply(this,{
			title : '人员管理',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'west',
				xtype : 'org_orgtree',
				width : 200
			},{
				region : 'center',
				layout : 'border',
				title : '人员管理',
				items : [{
					region : 'north',
					height : 100,
					xtype : 'person_filterform'
				},{
					region : 'center',
					xtype : 'person_persongrid'
				}]
			}]
		});
		this.callParent(arguments);
	}


});