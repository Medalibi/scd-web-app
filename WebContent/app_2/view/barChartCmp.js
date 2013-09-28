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

Ext.define('SCD.view.barChartCmp', {
		extend : 'Ext.chart.Chart',
		alias : 'widget.barChartCmp',
		id : 'barchart',
		animate:true,
		shadow:true,
		store:'barChartStore',
		theme:'Cll',
		legend:{
			   position:'left'
		},
		axes:[{
		      type:'Numeric',
		      position:'bottom',
		      fields:['level1','level2','level3'],
		      title:'Score per level'
		 
		},{
			  type:'Category',
			  position:'left',
			  fields:['name'],
			  title:'Teams'
		}
		],
		series:[{
		       type:'bar',
		       axis:'bottom',
		       xField:'name',
		       yField:['level1','level2','level3']
		}]
		
});
		
		
		
		