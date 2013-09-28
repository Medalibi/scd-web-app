Ext.define('SCD.view.scoreDecFrom',{
	extend:'Ext.form.Panel',
	alias: 'widget.scoreDecFrom',
	id: 'scoreDecFrom',
	title: 'Simple Form',
	bodyPadding: 10,
	width: 350,
	border : false,
	// The form will submit an AJAX request to this URL when submitted
	//url: 'save-form.php',
	
	// Fields will be arranged vertically, stretched to full width
	layout: 'anchor',
	defaults: {
	    anchor: '100%'
	},
	// The fields
	defaultType: 'textfield',
	items: [{
	    fieldLabel: 'Login',
	    emptyText : 'login',
	    name: 'admin_login',
	    allowBlank: false
	},{
	    fieldLabel: 'Password',
	    emptyText : '********',
	    name: 'admin_pwd',
	    inputType: 'password',
	    allowBlank: false
	},{
		xtype: 'combobox',
		fieldLabel: 'Team',
		name: 'team',
		emptyText: 'Select a team...',
		store: Ext.create('Ext.data.Store', {
		    fields: ['team_id', 'team_name'],
		    data : [
		    	{'team_id':'1', 'team_name':'team1'},
		    	{'team_id':'2', 'team_name':'team2'},
		    	{'team_id':'3', 'team_name':'team3'},
		    	{'team_id':'4', 'team_name':'team4'},
		    	{'team_id':'5', 'team_name':'team5'}				    	
		    ]
		}),
		valueField: 'team_id',
		displayField: 'team_name',
		typeAhead: true,
		queryMode: 'local',
		allowBlank: false
	}],
	
	// Reset and Submit buttons
	buttons: [{
	    text: 'Reset',
	    handler: function() {
	        this.up('form').getForm().reset();
	    }
	}, {
	    text: 'Submit',
	    formBind: true, //only enabled once the form is valid
	    disabled: true,
	    handler: function() {
	    	/*
	        var form = this.up('form').getForm();
	        if (form.isValid()) {
	            form.submit({
	                success: function(form, action) {
	                   Ext.Msg.alert('Success', action.result.msg);
	                },
	                failure: function(form, action) {
	                    Ext.Msg.alert('Failed', action.result.msg);
	                }
	            });
	        }*/
	    	console.log("Form Submited");
	    }
	}]
});
