var color='#fff';
Ext.define('Ext.chart.theme.Cll', {
extend: 'Ext.chart.theme.Base',
    
    constructor: function(config) {
        this.callParent([Ext.apply({
            axis: {
                fill: color,
                stroke: color
            },
            axisLabelLeft: {
                fill: color
            },
            axisLabelBottom: {
                fill: color
            },
            axisTitleLeft: {
                fill: color
            },
            axisTitleBottom: {
                fill: color
            }
        }, config)]);
    }
});

Ext.define('SCD.view.pieChartCmp', {
	extend : 'Ext.chart.Chart',
	alias : 'widget.pieChartCmp',
	id : 'piechartstore',
	animate : true,
	shadow : true,
	theme:'Cll',
	store : 'pieChartStore',
	axes: [{
        type: 'Numeric',
        position: 'left',
        fields: ['flag'],
        title: 'Captured Flags',
        grid: true,
        minimum: 0,
        maximum: 10
    }, {
        type: 'Category',
        position: 'bottom',
        fields: ['name'],
        title: 'Teams'
	}],
	series: [{
    	type: 'column',
        axis: 'left',
        highlight: true,
        tips: {
        	trackMouse: true,
        	width: 140,
            height: 28,
            renderer: function(storeItem, item) {
            	this.setTitle(storeItem.get('name') + ': ' + storeItem.get('flag') + ' flag(s)');
            }
		},
        label: {
        	display: 'insideEnd',
            'text-anchor': 'middle',
            field: 'flag',
            renderer: Ext.util.Format.numberRenderer('0'),
            	orientation: 'vertical',
                color: '#333'
			},
            xField: 'name',
            yField: 'flag'
 	}]
 });
/*
	extend : 'Ext.chart.Chart',
	alias : 'widget.pieChartCmp',
	id : 'piechartstore',
	animate : true,
	store : 'pieChartStore',
	shadow : true,
    legend: {
        position: 'right'
    },
    insetPadding: 60,
    theme: 'Base:gradients',
	tips: {
		trackMouse: true,
		width: 140,
		height: 28,
		renderer: function(storeItem, item) {
			this.setTitle(storeItem.get('name') + ': ' + Math.round(storeItem.get('flag') / total * 100) + ' flag(s)');
			console.log('ok');
		}
			
	},
	series : [{
		type : 'pie',
		field : 'flag',
		showInlegend : true,
		highlight : {
			segment : {
				margin : 20
			}
		},
		label : {
			field : 'name',
			display : 'rotate',
			contrast: true,
            font: '18px Arial'
		}
	}]
*/