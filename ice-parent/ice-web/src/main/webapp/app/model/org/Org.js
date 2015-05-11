Ext.define('Eway.model.org.Org',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','code','name','address','zip','des'],

	proxy : {
		type : 'rest',
		url : 'api/org',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});