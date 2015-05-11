Ext.define('Eway.view.org.OrgGrid',{

	extend : 'Ext.grid.GridPanel',
	alias : 'widget.org_orggrid',

	initComponent : function(){
		var store = Ext.create('Eway.store.org.Org');
		store.setBaseParam('parentOrgCode',ewayUser.getOrgCode());
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
				header : 'ID',
				dataIndex : 'id',
				flex : 1
			},{
				header : '机构编码',
				dataIndex : 'code',
				flex : 1
			},{
				header : '机构名称',
				dataIndex : 'name',
				flex : 1
			},{
				header : '地址',
				dataIndex : 'address',
				flex : 1
			},{
				header : '邮编',
				dataIndex : 'zip',
				flex : 1
			},{
				header : '描述',
				dataIndex : 'des',
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