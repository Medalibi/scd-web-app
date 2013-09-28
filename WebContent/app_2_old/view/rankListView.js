Ext.define('SCD.view.rankListView', {
		extend : 'Ext.grid.Panel',
		alias : 'widget.rankListGrid',
		id : 'rankListGrid',
		frame: true,
		store : 'rankListStore',
		viewConfig: {
        	loadMask: false
    	},
		columns : [{
			header : 'Name',
			dataIndex : 'name',
			flex : 1,
			renderer : formatContent
		}, {
			header : 'Score',
			dataIndex : 'score',
			flex : 1,
			hidden : true
		}],
		dockedItems: [{
			xtype: 'pagingtoolbar',
			id:'rankPaginator',
			store: 'rankListStore',   // same store GridPanel is using
			dock: 'bottom',
			hidden: false,
			displayInfo: true
		}]/*,
		tbar:[{
			xtype:'button',
			text:'filter',
			handler: function(){
				var store = this.up('grid').store;
				console.log(store.count());
			}
		}]*/
});

function formatContent(value, p, record) {
	return Ext.String.format(
			'<div class="rank_main">' +
				'<div class="rank_icon" style="background:transparent url(css/images/numbers/{3}.png) no-repeat;">' +
				'</div>'+
				'<div class="rank_grid" style="background:transparent url(css/images/team_logo/{2}) no-repeat;">' +
					'<b>{0}</b>' +
					'<span class="score_value">' +
						'<b>{1}</b>' +
					'</span>' +
				'</div>' +
			'</div>',
			value, record.get('score'),record.get('image') ,record.get('rang'));
}