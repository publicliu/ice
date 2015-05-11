Ext.define('Eway.view.org.FilterForm',{

	alias : 'widget.org_filterform',
	extend : 'Eway.view.base.FilterForm',


	initComponent : function(){
		Ext.apply(this,{
			defaultType: 'textfield',
			layout : 'column',
			defaults : {
				border : false,
				margin : '10'
			},
			items : [{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '机构编码',
				name : 'orgCode'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '机构名称',
				name : 'orgName'
			}]

		});
		this.callParent(arguments);
	}

});