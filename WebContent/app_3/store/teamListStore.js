Ext.define('SCD.store.teamListStore',{
	extend:'Ext.data.Store',
	model: 'SCD.model.teamListModel',
	storeId: 'teamList',
	autoLoad: true,
	data:[
    	{'team_id':'1', 'team_name':'team1'},
    	{'team_id':'2', 'team_name':'team2'},
    	{'team_id':'3', 'team_name':'team3'},
    	{'team_id':'4', 'team_name':'team4'},
    	{'team_id':'5', 'team_name':'team5'},
    	{'team_id':'6', 'team_name':'team6'},
    	{'team_id':'7', 'team_name':'team7'},
    	{'team_id':'8', 'team_name':'team8'},
    	{'team_id':'9', 'team_name':'team9'},
    	{'team_id':'10', 'team_name':'team10'},
    	{'team_id':'11', 'team_name':'team11'},
    	{'team_id':'12', 'team_name':'team12'},
    	{'team_id':'13', 'team_name':'team13'},
    	{'team_id':'14', 'team_name':'team14'},
    	{'team_id':'15', 'team_name':'team15'},
    	{'team_id':'16', 'team_name':'team16'}		
	]
	/*proxy:{
		type:'ajax',
		url:'app_3/data/team_list.json',
		reader:{
			type:'json',
			root:'teams'
		}
	}*/
});