Ext.define('SCD.store.rankListStore', {
	extend: 'Ext.data.Store',
	model: 'SCD.model.rankListModel',
	storeId: 'rankStore',
	//autoLoad: true,
	ageSize: 7,
	sorters:[{
		property:'score',
		direction: 'DESC'
	}],
	proxy: {
		type: 'ajax',
		url: 'EnvoiDonnees',
		//url: 'app_2/data/ranking.json',
		actionMethods:{read:'POST'},
		extraParams:{getJson:'getList'},
		reader: {
    		type: 'json',
    		root: 'rank'
    	}
	}
});