Ext.define('Eway.store.org.Org',{

	extend : 'Eway.store.base.Store',
	requires : 'Eway.model.org.Org',
	model : 'Eway.model.org.Org',


    /*proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            rootProperty: 'data'
        }
    },*/


	data : [
		{id:'1',code : '1',name : '1',address : '1',zip : '1',des : '1'},
		{id:'2',code : '2',name : '2',address : '2',zip : '2',des : '2'}
	]


});