package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;


/***
 * 
 * classe pour la verification du code de challenge
 * 
 * 1- verification du code de challenge
 * 
 * 
 * 2- retourner l'id du challenge 
 * 
 * 
 * 
 * */






public class VerifierCode {
	private String id_challenge=null;


	public VerifierCode() {
	
	}
	
	/*Methode pour la verification du code de challenge*/
	
	
	
	public boolean verifier(Connecteur sql,String code, String id_equipe)
	{
		try{
			MD5 m = new MD5();
	         ResultSet rs = sql.exec("SELECT * FROM CODE where CODE_CHALLENGE ='"+m.hasher(code)+"'");
		
		if(rs!=null){		
			 while (rs.next()) {
				 if(id_equipe.equals(rs.getString("id_equipe")))
		id_challenge =rs.getString("id_challenge");
			 }
		}
		}
		 catch (SQLException e) {
		 System.out.println("requet feha mochkla");
				e.printStackTrace();
				
			}
		if(id_challenge!=null)return true;
		return false;
		
	}

	
	/*Methode pour retourner l'id du challenge*/
	
	
	
	public String getId_challenge() {
		return id_challenge;
	}


}
