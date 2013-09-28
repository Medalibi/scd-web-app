Ext.define('SCD.model.rankListModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name:'name',type:'string'},
		{name:'score',type:'float'},
		{name:'image',type:'string'},
		{name:'rang',type:'int'}
	]
});