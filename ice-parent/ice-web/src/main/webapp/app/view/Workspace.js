Ext.define('Eway.view.Workspace',{
	alias : 'widget.appWorkspace',
	extend : 'Ext.panel.Panel',

	requires : [
		'Eway.view.index.Index'
	],

	layout : 'border',
	items : [{
		region : 'center',
		margin : '0 0 0 2',
		xtype : 'tabpanel'
	}],

	activeEwayView : function(comp){
		var tabPanel = this.down("tabpanel");
		var compId = comp.getId();
		var c = tabPanel.getComponent(compId);
		if(!c){
			tabPanel.add(comp);
		}
		else {
			var currentView = tabPanel.getActiveTab();
			if(currentView.id == c.id){
				return;
			}
		}
		tabPanel.setActiveTab(comp);
		//tabPanel.doComponentLayout();
		tabPanel.updateLayout();

	}


});