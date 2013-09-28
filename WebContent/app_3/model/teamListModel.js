/*Ext.define('SCD.model.teamListModel',{
	Extend:'Ext.data.Model',
	fields:[
		{name:'team_id', type:'string'},
		{name:'team_name', type:'string'}
	]
});
*/
Ext.define('SCD.model.teamListModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name:'team_id',type:'int'},
		{name:'team_name',type:'string'}
	]
});