Ext.define('SCD.store.barChartStore', {
	extend: 'Ext.data.Store',
	model: 'SCD.model.barChartModel',
	storeId: 'barchartstore',
	autoLoad: true,
	
	//data: generateBarData,
	proxy: {
		type: 'ajax',
		url: 'EnvoiDonnees',
		actionMethods:{read:'POST'},
		extraParams:{getJson:'getbarData'},
		reader: {
    		type: 'json',
    		root: 'teams'
		}
	}
});