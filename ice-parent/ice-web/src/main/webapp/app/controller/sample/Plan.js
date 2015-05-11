Ext.define('Eway.controller.sample.Task', {
    extend: 'Eway.controller.base.Controller',

    init: function() {
        console.log('Initialized3 Users! This happens before the Application launch function is called');
    },

    refs : [{
    	ref : 'ewayView',
    	selector : 'sample_plan',
    	autoCreate : true,
    	xtype: 'sample_plan'
    }],

    views : [
    	'sample.Plan'
    ]

});
