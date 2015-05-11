Ext.define('Eway.view.user.UserGrid',{

	extend : 'Ext.grid.GridPanel',
	alias : 'widget.user_usergrid',

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
				header : '编号',
				dataIndex : 'code',
				flex : 1
			},{
				header : '姓名',
				dataIndex : 'name',
				flex : 1
			},{
				header : '电话',
				dataIndex : 'mobile',
				flex : 1
			},{
				header : '固话',
				dataIndex : 'phone',
				flex : 1
			},{
				header : '电子邮箱',
				dataIndex : 'email',
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