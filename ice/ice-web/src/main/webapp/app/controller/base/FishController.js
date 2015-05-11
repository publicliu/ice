Ext.define('Eway.controller.base.FishController', {
	extend : 'Eway.controller.base.Controller',

	views : [
		'base.Window'
	],

	requires : ['Eway.view.base.Window'],

	initBaseControl : function(){
	},

	onQuery : function(){
		var view = this.getEwayView();
		var form = view.down('form').getForm();
		var bool = form.isValid();
		if (bool == false) {// 查询输入验证
			Ext.Msg.alert("提示","查询条件存在错误项.");
			return;
		}
		var values = form.getValues();
		var store = this.getGridPanel().getStore();
		store.setUrlParamsByObject(values);
		store.loadPage(1);
	},

	onAdd : function(){
		this._onAddOrUpdate('add');
	},

	onUpdate : function(){
		this._onAddOrUpdate('update');
	},

	onRemove : function(){
		var me = this;
		var grid = me.getGridPanel(),
			store = grid.getStore(),
			sm = grid.getSelectionModel(),
			count = sm.getCount();
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
				record.destroy({
					success: function(record,operation){
						Ext.Msg.alert("提示", "删除成功.");
						me.onQuery();
					},
					failure: function(record,operation){
						Ext.Msg.alert("提示", "删除失败:" + operation.request.scope.reader.jsonData.errorMsg);
					},
					scope:this
				});
			}
		});
	},


	_onAddOrUpdate : function(action){
		var title = action=='add' ? "增加"+this.formConfig.title : "更改"+this.formConfig.title;
		var me = this;
		Ext.require([this.formConfig.form],function(){
			if(action=='update'){
				var grid = this.getGridPanel(),
					sm = grid.getSelectionModel(),
					count = sm.getCount();
				if(count == 0){
					Ext.Msg.alert("提示", "请选择您要更改的记录.");
					return;
				}
				else if(count > 1){
					Ext.Msg.alert("提示", "只能选择一条记录更改.");
					return;
				}
			}

			var win = Ext.create('Eway.view.base.Window',{
				layout : 'fit',
				title : title,
				maximizable: true,
				width : this.formConfig.width ? this.formConfig.width : 500,
				height : this.formConfig.height ?  this.formConfig.height : 500,
				items : [{
					xtype : this.formConfig.xtype
				}]
			});
			win.setAction(action);
			win.down('button[action="confirm"]').on('click',me._save,me);
			if(action == 'update'){
				grid = this.getGridPanel(),
				sm = grid.getSelectionModel(),
				form = win.down('form');
				form.loadCusRecord(sm.getLastSelected());
			}
			win.show();
		},this);
	},

	getGridPanel : function(){
		var view =  this.getEwayView();
		return view.down('gridpanel');
	},

	_save : function(button){
		var me = this,
			view = this.getEwayView(),
			win = button.up('window'),
			form = win.down('form');
		if(form.getForm().isValid()){//存在不合法的输入项
			button.disable();
			var grid = me.getGridPanel(),
				store = grid.getStore(),
				action = win.getAction(),
				oldParams = store.getUrlParams(),
				actionName,
				record;
				store.cleanUrlParam();

				if(action == 'add') {
					actionName = '增加';
					var values = form.getCusValues();
					record = Ext.create(store.getModelName(),values);
				}
				else if(action == 'update') {
					actionName = '更改'
					record = grid.getSelectionModel().getLastSelected(),
					form.updateCusRecord(record);
				}
				record.save({
					 success: function(recordInDB) {
						Ext.Msg.alert('提示',actionName + '成功.');
						win.close();
						this.onQuery();
					 },
					 failure: function(record,operation){
						store.setUrlParamsByObject(oldParams);
						Ext.Msg.alert('提示',actionName + "失败:" + operation.request.scope.reader.jsonData.errorMsg);
						store.rejectChanges();
						button.enable();
					 },
					 scope : this
				});
	 	}
	}

});