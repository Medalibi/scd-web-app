Ext.define('SCD.model.barChartModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name:'name',  type:'string'},
		{name:'level1',type:'int'},
		{name:'level2',type:'int'},
		{name:'level3',type:'int'}
	]
});