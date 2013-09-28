Ext.define('SCD.controller.scoreCtl', {
    extend: 'Ext.app.Controller',
	views: ['rankListView','barChartCmp','pieChartCmp'],
	stores:['rankListStore','barChartStore','pieChartStore'],
	models:['rankListModel','barChartModel','pieChartModel'],
	//this function runs after the launch function in app.js
	init: function() {
		//Provides the ability to switch between the 2 tabs (Bar and Pie) and to refresh charts.
		var switchTabs = function () {
			//Automatic rank list paginator
			var store = Ext.getCmp('rankListGrid').store,
			page = store.currentPage,
			
			paginator = Ext.getCmp('rankPaginator');
			console.log(page);
			//store.clearFilter();
			if(store.isFiltered()){
				store.clearFilter();
			}
			if (page == 1){
				store.loadPage(1);
				storeCount = store.count();
				if(storeCount <= 7){
					store.filter(function(record) {
						return ((record.get('rang') < 8));
					});
				}
				else{
					paginator.moveNext();
					store.filter(function(record) {
						return ((record.get('rang') > 7) && (record.get('rang') < 15));
					});
				}
			}
			else{
				if(store.count() % 7)
					sup = Math.floor((store.count() / 7))+1;
				else
					sup = (store.count() / 7);
				
				console.log("supe: "+sup);
				if(page == sup){
					console.log("Go to first page");
					paginator.moveFirst();
					store.filter(function(record) {
						return (record.get('rang') < 8);
					});
				}
				else{
					paginator.moveNext();
					inf = (7 * (page+1))-6;
					sup = 7 * (page+1);
					store.filter(function(record) {
						return ((record.get('rang') >= inf) && (record.get('rang') <= sup));
					});
				}
			}
			/*
			else{
				paginator.moveFirst();
				store.filter(function(record) {
					return (record.get('rang') < 8);
				});
			}
			*/
			/*
			var tabPanelCharts = Ext.getCmp("tabPanelCharts");
			if (tabPanelCharts.getActiveTab().id == "pieChartTab")
				tabPanelCharts.setActiveTab(0);
			else
				tabPanelCharts.setActiveTab(1);
			*/
		};
		
		var refreshCharts = function(){
			//get proxy and reload store for each chart
			//Ext.getCmp("barchart").store.loadData(generateBarData());
		};
		var runner = new Ext.util.TaskRunner();
		//Switch between tabs every 5sec
		runner.start({
			run: switchTabs,
			interval: 5000
		});
		//Refresh charts every 12sec
		runner.start({
			run: refreshCharts,
			interval: 7000
		});
	}
});