
Ext.define('Eway.view.user.Add', {
	extend: 'Ext.window.Window',
	alias: 'widget.user_add',

	title: '增加用户信息',
	modal: true,
	resizable: false,
	constrainHeader: true,
	layout: 'fit',
	width: 300,
	height: 250,
	initComponent: function() {
		Ext.apply(this, {
			items :[ {
//				title:'用户基本信息',
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
					value : '11111',
					name : 'orgName',
					readOnly : true
				},{
					xtype : 'textfield',
					fieldLabel : '<font color="red">*</font>姓&nbsp;&nbsp;&nbsp;&nbsp;名',
					allowBlank : false,
					name : 'name'
				},{
					fieldLabel : '<font color="red">*</font> 用&nbsp;户&nbsp;名',
					xtype : 'textfield',
					regex: /^[a-zA-Z0-9][a-zA-Z0-9-_\.]{0,19}$/,
					regexText:'只能输入1到20字母‘a-z’或‘A-Z’、数字‘0-9’、减号‘-’、下划线‘_’、点号‘.’， 只能以字母或数字开头！',
					allowBlank : false,
					name : 'code'
				},{
					xtype : 'textfield',
					fieldLabel : '固定电话',
					name : 'phone'
				},{
					xtype : 'textfield',
					fieldLabel : '移动电话',
					name : 'mobile'
				},{
					xtype : 'textfield',
					fieldLabel : '电子邮箱',
					name : 'email'
				},{
					xtype : 'textfield',
					fieldLabel : '机构编号',
					name : 'orgCode',
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