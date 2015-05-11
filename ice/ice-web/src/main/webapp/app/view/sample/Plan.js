Ext.define('Eway.view.sample.Plan',{

	alias : 'widget.sample_plan',
	extend : 'Eway.view.base.Panel',

	/*requires : [
		'Eway.view.sample.PlanFilterForm',
		'Eway.view.sample.PlanGrid'
	],*/

	initComponent : function(){
		Ext.apply(this,{
			title : '采样计划',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'center',
				layout : 'border',
				title : '采样计划',
				items : [/*{
					region : 'north',
					height : 100,
					xtype : 'sample_planfilterform'
				},*/{
					region : 'center',
//					xtype : 'sample_plangrid'
					xtype : 'panel'
				}]
			}]
		});
		this.callParent(arguments);
	}


});