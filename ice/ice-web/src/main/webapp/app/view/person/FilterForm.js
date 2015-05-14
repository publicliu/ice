Ext.define('Eway.view.person.FilterForm',{

	alias : 'widget.person_filterform',
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
				fieldLabel : '用户编号',
				name : 'userCode'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '用户姓名',
				name : 'userName'
			}]
		});
		this.callParent(arguments);
	}

});