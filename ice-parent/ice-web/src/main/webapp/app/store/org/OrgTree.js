/**
 * 机构树Store：
 */
Ext.define('Eway.store.org.OrgTree', {
	extend: 'Ext.data.TreeStore',
	requires : 'Eway.model.org.OrgTree',
	model : 'Eway.model.org.OrgTree',

	root: {
		id: ewayUser.getOrgCode(),
		text: ewayUser.getOrgName(),
		expanded: true
	},

    proxy: {
        type: 'ajax',
        url : 'api/org/orgTree',
	    reader: {
	        type: 'json',
	        root: 'data'
	    }
    },
    autoLoad: false
});