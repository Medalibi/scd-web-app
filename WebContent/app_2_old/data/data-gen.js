function generateBarData (n, floor){
        var data = [],
			team = ['team1','team2','team3','team4','team5','team6','team7','team8',
			'team9','team10','team11','team12','team13','team14','team15','team16'],
            i;
            
        floor = (!floor && floor !== 0)? 20 : floor;

        for (i = 0; i < (n || 16); i++) {
            data.push({
                name: team[i],
                level1: Math.floor(Math.max((Math.random() * 100), floor)),
                level2: Math.floor(Math.max((Math.random() * 100), floor)),
                level3: Math.floor(Math.max((Math.random() * 100), floor))
            });
        }
        return data;
};

function generatePieData (n, floor){
        var data = [],
			team = ['team1','team2','team3','team4','team5','team6','team7','team8',
			'team9','team10','team11','team12','team13','team14','team15','team16'],
            i;
            
        floor = (!floor && floor !== 0)? 20 : floor;

        for (i = 0; i < (n || 16); i++) {
            data.push({
                name: team[i],
                flag: Math.floor(Math.max((Math.random() * 100), floor))
            });
        }
        return data;
};