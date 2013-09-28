Ext.application({
	name : 'SCD',
	appFolder : 'app_3',
	controllers : ['scoreDecCtl'],
	launch : function(){
		//Can't include recaptcha in Extjs from (no callback to know if inserted captcha is corrct on no !)
		/*var recaptcha = Ext.create('SCD.view.Recaptcha',{
			recaptchaId: 'recaptcha',
			publickey: '6Lcmr9oSAAAAACS-sNgTd4YB5CvxN3Za6_8RcKV3',
			theme: 'white',
			lang: 'en',
			callback: this.focus_response_field
		});*/
		Ext.create('Ext.form.Panel',{
			title: 'Decrease team score',
			bodyPadding: 10,
			style:'margin-top:10px;',
			width: 350,
			url : 'DemandeInternet',
			// The form will submit an AJAX request to this URL when submitted
			//url: 'link/to/the/java/servlet',
			
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
			    name: 'login',
			    style:'margin-bottom:10px;',
			    allowBlank: false
			},{
			    fieldLabel: 'Password',
			    emptyText: '********',
			    name: 'pass',
			    inputType: 'password',
			    style:'margin-bottom:10px;',
			    allowBlank: false
			},{
				xtype: 'combobox',
				fieldLabel: 'Team',
				name: 'team_id',
				emptyText: 'Select a team...',
				store: 'teamListStore',
				valueField: 'team_id',
				displayField: 'team_name',
				style:'margin-bottom:15px;',
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
			    formBind: true, //Only enabled once the form is valid
			    disabled: true,
				style:'margin-top:20px;',
			    handler: function() {
			        var form = this.up('form').getForm();
			        if (form.isValid()) {
			            form.submit({
	                		success: function(form, action) {
	                			Ext.Msg.alert('Success', action.result.message);
	                		     form.reset();
	                		},
	                		failure: function(form, action) {
	                			Ext.Msg.alert('Failed', action.result.message);
	                		     form.reset();
	                		}
			            });
			        }
			    }
			}],
			renderTo: 'submitForm'
		});
	}
});