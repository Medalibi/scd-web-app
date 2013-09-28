package com.fst.challenge.beans;

	import java.sql.DriverManager;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.util.logging.Level;
		import java.util.logging.Logger;
		
		
		
		/**
		 * 
		 * Classe de connexion a la base de donnees 
		 * 
		 * 
		 * 1- connexion a la base
		 * 
		 * 2-methode pour l'execution d'une requete select ou insert
		 * 
		 * 3- methode pour l'execution d'une requete update
		 * 
		 * */
		
		
		
		
		

public class Connecteur {

    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;

	public Connecteur() {
       
	}
		
	
	/*Methode pour ouvrir une connexion a la base de donnée*/
	
	
		    public Boolean connect() {
		        try {
		            Class.forName("com.mysql.jdbc.Driver").newInstance();
		            this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/challenge" , "root", "dali15051988");
		            this.dbStatement = this.dbConnect.createStatement();
		            return true;
		        } catch (SQLException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        } catch (ClassNotFoundException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        return false;
		    }

		    /**
		     * Executer une requete SQL
		     * 
		     */
		   public ResultSet exec(String sql) {
		        try {
		            ResultSet rs = this.dbStatement.executeQuery(sql);
		           
		            return rs;
		        } catch (SQLException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        return null;
		    }
		   
		   
		   /*Methode d'execution d'une requete update*/
		   
		   
		   public boolean update(String sql) {
		        try {
		             this.dbStatement.executeUpdate(sql);
		           
		            return true;
		        } catch (SQLException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        }
		        return false;
		    }

		    /**
		     * Fermer la connexion au serveur de DB
		     */
		    public void close() {
		        try {
		            this.dbStatement.close();
		            this.dbConnect.close();
		            this.dbConnect.close();
		        } catch (SQLException ex) {
		            Logger.getLogger(Connecteur.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    }

		}
		

