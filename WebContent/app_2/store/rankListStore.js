Ext.define('SCD.store.rankListStore', {
	extend: 'Ext.data.Store',
	model: 'SCD.model.rankListModel',
	storeId: 'rankStore',
	//autoLoad: true,
	pageSize: 7,
	sorters:[{
		property:'score',
		direction: 'DESC'
	}],
	proxy: {
		type: 'ajax',
		url: 'EnvoiDonnees',
	
		actionMethods:{read:'POST'},
		extraParams:{getJson:'getList'},
		reader: {
    		type: 'json',
    		root: 'rank'
		}
	}
});