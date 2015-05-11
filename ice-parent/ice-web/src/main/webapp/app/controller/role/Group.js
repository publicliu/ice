Ext.define('Eway.controller.role.Group', {
    extend: 'Eway.controller.base.Controller',

    init: function() {
        console.log('Initialized3 Users! This happens before the Application launch function is called');
    },

    refs : [{
    	ref : 'ewayView',
    	selector : 'role_group',
    	autoCreate : true,
    	xtype: 'role_group'
    }],

    views : [
    	'role.Group'
    ]

});
