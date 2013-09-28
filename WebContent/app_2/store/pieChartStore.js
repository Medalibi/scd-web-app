Ext.define('SCD.store.pieChartStore', {
	extend: 'Ext.data.Store',
	model: 'SCD.model.pieChartModel',
	storeId: 'piechartstore',
	autoLoad: true,
	
	
	proxy: {
		type: 'ajax',
		url: 'EnvoiDonnees',
	
		actionMethods:{read:'POST'},
		extraParams:{getJson:'getpieData'},
		reader: {
    		type: 'json',
    		root: 'teams'
		}
	}
});