Ext.define('Eway.view.sample.PlanGrid',{

	extend : 'Ext.grid.GridPanel',
	alias : 'widget.sample_plangrid',

	initComponent : function(){
		var store = Ext.create('Eway.store.user.User');
		store.setBaseParam('orgCode',ewayUser.getOrgCode());
		store.loadPage(1);

		Ext.apply(this,{
			tbar : ['->',{
				iconCls :'queryBtn',
				action: 'query',
				text : '查询'
			},{
				iconCls :'addBtn',
				action: 'add',
				text : '增加'
			},{
				iconCls :'updateBtn',
				action: 'update',
				text : '修改'
			},{
				iconCls :'deleteBtn',
				action: 'remove',
				text : '删除'
			}],
			store : store,
			columns : [{
				xtype: 'rownumberer'
			},{
				header : '任务编号',
				dataIndex : 'code',
				flex : 1
			},{
				header : '监测类别',
				dataIndex : 'name',
				flex : 1
			},{
				header : '监测项目',
				dataIndex : 'mobile',
				flex : 1
			},{
				header : '监测样品',
				dataIndex : 'phone',
				flex : 1
			},{
				header : '采样环节',
				dataIndex : 'email',
				flex : 1
			},{
				header : '采样单位',
				dataIndex : '',
				flex : 1
			},{
				header : '检测单位',
				dataIndex : '',
				flex : 1
			},{
				header : '采样数量',
				dataIndex : '',
				flex : 1
			},{
				header : '上报时间',
				dataIndex : '',
				flex : 1
			}],
			dockedItems: [{
    			xtype: 'pagingtoolbar',
    			store: store,
    			dock: 'bottom',
    			displayInfo: true
			}]
		});


		this.callParent(arguments);
	}


});