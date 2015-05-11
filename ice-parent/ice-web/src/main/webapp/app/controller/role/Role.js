Ext.define('Eway.controller.role.Role', {
    extend: 'Eway.controller.base.Controller',

    init: function() {
        console.log('Initialized3 Users! This happens before the Application launch function is called');
    },

    refs : [{
    	ref : 'ewayView',
    	selector : 'role_role',
    	autoCreate : true,
    	xtype: 'role_role'
    }],

    views : [
    	'role.Role'
    ]

});
