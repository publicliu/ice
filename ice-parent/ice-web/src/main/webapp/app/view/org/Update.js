
Ext.define('Eway.view.org.Update', {
	extend: 'Ext.window.Window',
	alias: 'widget.org_update',

	title: '修改机构信息',
	modal: true,
	resizable: true,
	constrainHeader: true,
	layout: 'fit',
	width: 300,
	height: 250,
	initComponent: function() {
		Ext.apply(this, {
			items :[ {
				xtype: 'form',
				bodyStyle : 'padding: 10px 10px 10px 10px',
        		height: 80,
				defaults: {
					labelWidth: 60,
					labelAlign: 'right',
					msgTarget : 'side',
					anchor: '100%'
				},
				items: [{
					xtype : 'textfield',
					fieldLabel : '所属机构',
					name : 'parentOrgName',
					readOnly : true
				},{
					xtype : 'textfield',
					fieldLabel : '<font color="red">*</font>机构编码',
					regex: /^[a-zA-Z0-9][a-zA-Z0-9-_\.]{0,19}$/,
					regexText:'只能输入1到20字母‘a-z’或‘A-Z’、数字‘0-9’、减号‘-’、下划线‘_’、点号‘.’， 只能以字母或数字开头！',
					allowBlank : false,
					name : 'code'
				},{
					fieldLabel : '<font color="red">*</font>机构名称',
					xtype : 'textfield',
					allowBlank : false,
					name : 'name'
				},{
					xtype : 'textfield',
					fieldLabel : '机构地址',
					name : 'address'
				},{
					xtype : 'textfield',
					fieldLabel : '机构邮编',
					name : 'zip'
				},{
					xtype : 'textfield',
					fieldLabel : '机构描述',
					name : 'des'
				},{
					xtype : 'textfield',
					fieldLabel : '机构编号',
					name : 'parentOrgCode',
					hidden : false
				},{
					xtype : 'textfield',
					fieldLabel : '旧机构编号',
					name : 'oldOrgCode',
					hidden : true
				}]
			}],
			buttonAlign : 'center',
			buttons: [{
					text: '确认',
					//iconCls :'sureBtn',
					action: 'confirm'
				}, {
					text: '取消',
					//iconCls :'returnBtn',
					handler: this.onOver
			}]
		});

		this.callParent(arguments);
	},

	onOver: function() {
		this.up('window').close();
	}
});