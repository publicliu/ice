Ext.define('Eway.controller.app.weixin.meetlove.Args', {
    extend: 'Eway.controller.base.Controller',


    refs : [{
    	ref : 'ewayView',
    	selector : 'app_weixin_meetlove_args',
    	autoCreate : true,
    	xtype: 'app_weixin_meetlove_args'
    }],

    views : [
    	'app.weixin.meetlove.Args'
    ],

    init : function(){
   		var me = this;
    },

    orgTreeAfterRender : function(comp){
    	comp.getSelectionModel().select(0);
    },

    getOrgTree : function(){
    	var view = this.getEwayView();
    	var tree = view.down('org_orgtree');
    	return tree;
    },

    orgTreeItemClick : function(view,record){
    	var grid = this.getGrid();
		var store = grid.getStore();
		store.cleanUrlParam();
		store.setBaseParam('orgCode',record.data.id);
		grid.getStore().loadPage(1);
    },

    onQuery : function(){
    	var tree = this.getOrgTree();
    	var view = this.getEwayView();
    	var data = this.getFilterForm().getForm().getValues();
		var store = this.getGrid().getStore();
		store.setUrlParamsByObject(data);
		var treeRecord = tree.getSelectionModel().getLastSelected();
		store.setBaseParam('orgCode',treeRecord.data.id);
		store.loadPage(1);
    },

    onAdd : function(){
    	var addWin = Ext.create('Eway.view.user.Add');
    	var tree = this.getOrgTree();
		var treeRecord = tree.getSelectionModel().getLastSelected();
    	var form = addWin.down('form');
    	form.getForm().setValues({
    		orgName : treeRecord.data.text,
    		orgCode : treeRecord.data.id
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
		Ext.MessageBox.confirm("请确认", "是否删除该记录?",function(button,text){
			if(button == 'yes'){

				var record = sm.getLastSelected();
				store.remove(record);
				store.sync({
					success : function(batch){
						var operation = batch.operations[batch.current];
						var response = Ext.JSON.decode(operation.response.responseText);
						if(response.success){
							Ext.Msg.alert("提示", "删除成功");
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
		var flag = true;
		if(sm.getCount() == 1) {
			var tree = this.getOrgTree();
			var treeRecord = tree.getSelectionModel().getLastSelected();

			var win = Ext.create('Eway.view.user.Update');
			var record = sm.getLastSelected();
			var form = win.down('form').getForm();
			form.loadRecord(record);
			form.setValues({
	    		orgName : treeRecord.data.text,
	    		orgCode : treeRecord.data.id
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
		var win = this.getAddWin();
		data = win.down('form').getForm().getValues();
		var record = Ext.ModelManager.create(data, 'Eway.model.user.User');
		if(win.down('form').getForm().isValid()){
			record.save({
				success : function(record,operation){
					me.getGrid().getStore().load();
					Ext.MessageBox.alert('提示','创建成功,新建账户'+data.code+'初始密码为: 888888');
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
		if(form.isValid()){
			form.updateRecord(form.getRecord());
			store.sync({
				success : function(batch){
					var operation = batch.operations[batch.current];
					var response = Ext.JSON.decode(operation.response.responseText);
					if(response.success){
						Ext.Msg.alert("提示", "修改成功");
						win.close();
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
	}
});
