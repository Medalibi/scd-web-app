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
			if(store.isFiltered()){
				store.clearFilter();
			}
			if (page == 1){
				console.log(page);																	
				store.loadPage(1);
				paginator.moveNext();
				store.filter(function(record) {
					return ((record.get('rang') > 7) && (record.get('rang') < 15));
				});
			}
			else if (page == 2){
				console.log(page);
				paginator.moveNext();
				store.filter(function(record) {
					return ((record.get('rang') > 14));
				});
			}
			else{
				console.log(page);
				paginator.moveFirst();
				store.filter(function(record) {
					return (record.get('rang') < 8);
				});
			}
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