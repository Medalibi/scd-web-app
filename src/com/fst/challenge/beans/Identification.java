package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;




/**
 * 
 * Classe pour verifier le login et le mot de passe
 * 
 * 1- verification
 * 
 * 2- retourner l'id du l'equipe
 * 
 * */





public class Identification {
	private Connecteur sql;
	private String login,pass,id_equipe;

	public Identification(Connecteur sql, String login,String pass) {
		this.sql=sql;
		this.login=login;
		this.pass=pass;	
		
	}
	
	
	/*Methode pour la verification du login et mot de passe*/
	
	
	
	public boolean test(){
		
		try{
			MD5 m = new MD5();
	         ResultSet rs = sql.exec("SELECT * FROM EQUIPE where LOGIN ='"+m.hasher(login)+"' AND PASSWORD='"+m.hasher(pass)+"'");
		
		if(rs!=null){		
			 while (rs.next()) {
				 id_equipe=rs.getString("id_equipe");				
			 }
		}
		}
		
		 catch (SQLException e) {
		 System.out.println("requet feha mochkla");
				e.printStackTrace();
							}

		if( id_equipe!=null) return true;
		 return false;
		
		
		
	}
	
	
	
	
	/* Methode pour retourner l'id de l'equipe ayant le login et mot de passe deja verifier */
	
	
	
	
	
	public String getIdEquipe()
	{
		return id_equipe;
	}
	
	

}
