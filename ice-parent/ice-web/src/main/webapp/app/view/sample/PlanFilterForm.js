Ext.define('Eway.view.sample.PlanFilterForm',{

	alias : 'widget.sample_planfilterform',
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
				fieldLabel : '监测类别'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '采样环节'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '采样单位'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '监测单位'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '上报时间'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '监测项目'
			},{
				labelAlign : 'right',
				columnWidth : .2,
				fieldLabel : '监测样品'
			}]
		});
		this.callParent(arguments);
	}

});