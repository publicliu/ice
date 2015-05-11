Ext.define('Eway.controller.org.Org', {
    extend: 'Eway.controller.base.Controller',

    init: function() {
        console.log('Initialized3 Users! This happens before the Application launch function is called');
    },

    refs : [{
    	ref : 'ewayView',
    	selector : 'org_Org',
    	autoCreate : true,
    	xtype: 'org_Org'
    },{
		ref: 'grid',
		selector: 'org_orggrid'
	},{
		ref :'filterForm',
		selector:'org_filterform'
	},{
		ref: 'addWin',
		selector: 'org_add'
	},{
		ref: 'updateWin',
		selector: 'org_update'
	}],

    views : [
    	'org.Org'
    ],

    init : function(){
   		var me = this;
   		me.control({
   			'org_Org org_orgtree' : {
   				afterrender : me.orgTreeAfterRender,
   				itemclick :  me.orgTreeItemClick
   			},
   			'org_Org button[action=query]' : {
   				click : me.onQuery
   			},
   			'org_Org button[action=add]' : {
   				click : me.onAdd
   			},
   			'org_Org button[action=remove]' : {
   				click : me.onRemove
   			},
   			'org_Org button[action=update]' : {
   				click : me.onUpdate
   			}
   		});
    },

    orgTreeAfterRender : function(comp){
    	comp.getSelectionModel().select(0);
    },

    getOrgTree : function(){
    	var view = this.getEwayView();
    	var tree = view.down('org_orgtree');
    	return tree;
    },

    onQuery : function(){
    	var tree = this.getOrgTree();
    	var view = this.getEwayView();
    	var data = this.getFilterForm().getForm().getValues();
		var store = this.getGrid().getStore();
		store.setUrlParamsByObject(data);
		var treeRecord = tree.getSelectionModel().getLastSelected();
		store.setBaseParam('parentOrgCode',treeRecord.data.id);
		store.loadPage(1);
    },

    onAdd : function(){
    	var addWin = Ext.create('Eway.view.org.Add');
    	var tree = this.getOrgTree();
		var treeRecord = tree.getSelectionModel().getLastSelected();
    	var form = addWin.down('form');
    	form.getForm().setValues({
    		parentOrgName : treeRecord.data.text,
    		parentOrgCode : treeRecord.data.id
    	});
    	addWin.down('button[action="confirm"]').on('click',this.onAddWinConfirm,this);
    	addWin.show();
    },

    onRemove : function(){
    	var me = this;
    	var grid = this.getGrid();
    	var store = grid.getStore();
    	var sm = grid.getSelectionModel();
    	var count = sm.getCount();
    	if(count == 0){
			Ext.Msg.alert("提示", "请选择您要删除的记录.");
			return;
		}
		else if(count > 1){
			Ext.Msg.alert("提示", "只能选择一条记录删除.");
			return;
		}
		Ext.MessageBox.confirm("请确认", "是否删除该机构?",function(button,text){
			if(button == 'yes'){

				var record = sm.getLastSelected();
				store.remove(record);
				store.sync({
					success : function(batch){
						var operation = batch.operations[batch.current];
						var response = Ext.JSON.decode(operation.response.responseText);
						if(response.success){
							Ext.Msg.alert("提示", "删除成功");
							//在浏览器机构树中删除该机构
							var tree = me.getOrgTree();
							var rootNode = tree.getRootNode();
							currentNode = rootNode.findChildBy(function(node){
								if(node.data.id == record.data.code){
									return true;
								}
							},rootNode,true);
							currentNode.remove(false);
							me.onQuery();
						}
						else {
							store.rejectChanges();
							Ext.Msg.alert("提示", "删除失败");
						}
					},
					failure : function(){
						store.rejectChanges();
						Ext.Msg.alert("提示", "删除失败");
					}
				});
			}
		});
    },

    onUpdate: function() {
		var grid = this.getGrid();
		var sm = grid.getSelectionModel();
		if(sm.getCount() == 1) {
			var tree = this.getOrgTree();
			var treeRecord = tree.getSelectionModel().getLastSelected();
			var win = Ext.create('Eway.view.org.Update');
			var record = sm.getLastSelected();
			var form = win.down('form').getForm();
			form.loadRecord(record);
			form.setValues({
	    		parentOrgName : treeRecord.data.text,
	    		parentOrgCode : treeRecord.data.id,
	    		oldOrgCode : record.get('code')
	    	});
	    	win.down('button[action="confirm"]').on('click',this.onUpdateWinConfirm,this);
			win.show();
		}else {
			Ext.Msg.alert("提示", "请选择您要更改的记录.");
		}
	},

     onAddWinConfirm: function() {
    	var me = this;
		var ewayView = this.getEwayView();
		var tree = this.getOrgTree();
		var rootNode = tree.getRootNode();
		var win = this.getAddWin();
		var data = win.down('form').getForm().getValues();
		var record = Ext.ModelManager.create(data, 'Eway.model.org.Org');
		if(win.down('form').getForm().isValid()){
			record.save({
				success : function(record,operation){
					me.getGrid().getStore().load();

					var currentNode;
					var parentCode = data.parentOrgCode;
					if(parentCode == rootNode.data.id){
						currentNode = rootNode;
					}
					else {
						currentNode = rootNode.findChildBy(function(node){
							if(node.data.id == parentCode){
								return true;
							}
						},rootNode,true);
					}
					currentNode.appendChild({
						id : data.code,
						text : data.name,
						leaf : true
					});

					Ext.MessageBox.alert('提示','机构增加成功');
					win.close();
			    },
			    failure: function(record,operation){
					Ext.Msg.alert("提示", operation.request.scope.reader.jsonData.errors);
				}
			});
		}
	},

	onUpdateWinConfirm: function() {
		var me = this;
		var win = this.getUpdateWin();
		var updateForm = win.down('form');
		var store = this.getGrid().getStore();
		var form = updateForm.getForm();
		var record = form.getRecord();
		var oldOrgCode = updateForm.down('textfield[name=oldOrgCode]').getValue();
		if(form.isValid()){
			form.updateRecord(record);
			store.sync({
				success : function(batch){
					var operation = batch.operations[batch.current];
					var response = Ext.JSON.decode(operation.response.responseText);
					if(response.success){
						Ext.Msg.alert("提示", "修改成功");
						win.close();
						//在浏览器机构树中修改该机构
						var tree = me.getOrgTree();
						var rootNode = tree.getRootNode();
						currentNode = rootNode.findChildBy(function(node){
							if(node.data.id == oldOrgCode){
								return true;
							}
						},rootNode,true);
						currentNode.set('id',record.data.code);
						currentNode.set('text',record.data.name)
						currentNode.commit();

					}
					else {
						store.rejectChanges();
						Ext.Msg.alert("提示", response.errorMsg);
					}
				},
				failure : function(batch,object){
					store.rejectChanges();
					Ext.Msg.alert("提示", "修改失败");
				}
			});
		}
	},


    orgTreeItemClick : function(view,record){
    	var grid = this.getGrid();
		var store = grid.getStore();
		store.cleanUrlParam();
		store.setBaseParam('parentOrgCode',record.data.id);
		grid.getStore().loadPage(1);
    }

});
