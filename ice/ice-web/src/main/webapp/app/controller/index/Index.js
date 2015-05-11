Ext.define('Eway.controller.index.Index', {
    extend: 'Eway.controller.base.Controller',

    init: function() {
        console.log('Initialized3 Users! This happens before the Application launch function is called');
    },

    refs : [{
    	ref : 'ewayView',
    	selector : 'index_index',
    	autoCreate : true,
    	xtype: 'index_index'
    }],

    views : [
    	'index.Index'
    ]

});
