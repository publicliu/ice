Ext.define('Eway.model.person.Person',{

	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields : ['id','code','name','mobile','phone','email'],

	proxy : {
		type : 'rest',
		url : 'api/person',

		reader : {
			type : 'json',
			root : 'data'
		},
		wirter : {
			type : 'json'
		}
	}
});