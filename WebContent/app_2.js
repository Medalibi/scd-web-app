var sponsors_list = '<div id="slideshow">'+
						'<div>'+
							'<img src="css/images/sponsors/orange.jpg"/>'+
						'</div>'+
						'<div>'+
							'<img src="css/images/sponsors/hli.jpg"/>'+
						'</div>'+
						'<div>'+
							'<img src="css/images/sponsors/vermeg.jpg"/>'+
						'</div>'+
					'</div>';
Ext.application({
	requires : ['Ext.container.Viewport'],
	name : 'SCD',
	appFolder : 'app_2',
	controllers : ['scoreCtl'],
	launch : function() {
		Ext.create('Ext.container.Viewport', {
			layout : 'border',
			items : [{
					id:"tabPanelCharts",
					region : 'west',
					width : '70%',
					xtype : 'tabpanel',
					activeTab : 0,
					items: [{
							id:"barChartTab",
							title : 'Ranking score - Levels',
							bodyStyle: "background-image:url(css/images/bg2.jpg) !important;padding:20px;",
							layout:'fit',
							items:[{xtype:'barChartCmp'}]
						},{
							id:"pieChartTab",
							title : 'Flag capture - Total',
							bodyStyle: "background-image:url(css/images/bg2.jpg) !important;padding:5px;",
							layout : 'fit',
							items:[{xtype:'pieChartCmp'}]
					}]
				}, {
					region : 'center',
					layout: {
            			type: 'vbox',
            			align: 'stretch'
        			},
					items:[{
						xtype: 'rankListGrid'
					}/*,{
						xtype:'panel',
						height:100,
						bodyStyle: "background-color:#fff;",
						html:sponsors_list
						
					}*/]

				}]
		});
	}
});