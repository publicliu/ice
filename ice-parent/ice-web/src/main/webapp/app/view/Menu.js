/**
 * 菜单栏
 */
Ext.define('Eway.view.Menu', {
	alias: 'widget.appmenu',
	extend: 'Ext.toolbar.Toolbar',

	initComponent: function() {
		Ext.apply(this, {
		   id: 'appmenu',
		   items : [{
		   		text : '1'
		   },{
		   		text : '2'
		   }]
		});

        this.callParent(arguments);
	}
});