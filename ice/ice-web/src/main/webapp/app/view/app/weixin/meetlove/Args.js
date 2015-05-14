Ext.define('Eway.view.app.weixin.meetlove.Args',{

	alias : 'widget.app_weixin_meetlove_args',
	extend : 'Eway.view.base.Panel',

	requires : [
	     'Eway.view.app.weixin.meetlove.ArgsGrid'
	],


	initComponent : function(){
		Ext.apply(this,{
			title : '遇见爱-参数配置',
			layout : 'border',
			margin : '0',
			items : [{
				region : 'center',
				title : '参数配置',
				xtype : 'app_weixin_meetlove_argsgrid'
			}]
		});
		this.callParent(arguments);
	}


});