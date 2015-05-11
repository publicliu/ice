Ext.define("Eway.controller.Main",{

	extend : 'Eway.controller.base.Controller',

	refs : [{
		ref : 'ewayView',
		selector : 'viewport > appWorkspace'
	}],

	init : function(){
		var me = this;
		me.control({
			'viewport menuTree' : {
				itemclick : function(scope,record){
					me.activeController(record.raw.controller);
				}
			},
			'viewport appHeader button[action=index]' : {
				click : function(){
					me.activeController("index.Index");
				}
			},
			'viewport appHeader menu' : {
				click : function(menu,item){
					if(item.action){
						if(item.action == 'logout'){
							me.logout();
							return;
						}
						me.activeController(item.action);
					}
					else {
						console.debug('action未定义');
					}

				}
			}
		});
	},

	logout : function(){
		Ext.Ajax.request({
			method : 'POST',
			url : 'api/logout',
			success : function(response) {
				window.location.reload();
			},
			failure : function(response) {
			}
		});
	},
	onLaunch : function(){
		this.activeController("index.Index");
	}

});