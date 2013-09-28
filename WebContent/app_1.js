
Ext.application({
requires:[
    'Ext.form.Panel'
],
name: 'SCD',
appFolder : 'app_1',
launch :function (){
    Ext.create ('Ext.form.Panel', {
        renderTo: 'submitForm',
        frame: false,
        width: 350,
        id:'myform',
        bodyPadding: 10,
        style:'margin-top:10px;',
        bodyBorder:false,
        title: 'Update your score',
        url: 'Connexion',
        defaults: {
            anchor: '100%'
        },
        items: [{
            xtype: 'textfield',
            name: 'login',
            fieldLabel: 'Login',
            style:'margin-bottom:10px;',
            vtype :'alphanum',
            allowBlank: false,
            emptyText:'login'
        },{
            xtype: 'textfield',
            name: 'pass',
            fieldLabel: 'Password',
            style:'margin-bottom:10px;',
            inputType: 'password',
            vtype: 'alphanum',
            allowBlank: false,
            emptyText:'*********'
        },{
            xtype: 'textfield',
            name: 'code',
            fieldLabel: 'Code',
            inputType: 'password',
            vtype: 'alphanum',
            allowBlank: false,
        }],
        buttons: [{
        	text: 'Cancel',
            handler: function() {
                this.up('form').getForm().reset();
            }
        },{
        	text: 'Sent',
            style:'margin-top:20px;',
            formBind: true,
            formBind: true,
            handler: function() {
               var form = this.up('form').getForm();
               if (form.isValid()) {
		            form.submit({
                		success: function(form, action) {
                			Ext.Msg.alert('Success', action.result.message);
                		Ext.getCmp('myform').getForm().reset();
                		Ext.create('Ext.window.Window', {
        				    height: 500,
        				    width: 820,
        				    draggable:false,
        				    resizable:false,
        				    bodyStyle: "background-image:url(css/images/error.jpg)",
        				    modal:true
        				}).show();
                		},
                		failure: function(form, action) {
                			Ext.Msg.alert('Failed', action.result.message);
                			Ext.getCmp('myform').getForm().reset();
                		}
		            });
		        }
            }
        }]
    });
}
    });
   
