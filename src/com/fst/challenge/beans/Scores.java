package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;


/***
 * 
 *Classe pour la gestion des scores  
 * 
 * 1- determiner le niveau et le score du challenge
 * 
 * 2- recuperer la case du score correspondante au niveau puis la mettre a jour
 * 		ensuite mettre le nombre de flag de l'equipe a jour si le challenge a un flag nn retenu
 * 
 */






public class Scores {
	private String score,niveau;

	public Scores() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*Recuperation du niveau et du score du challenge*/
	
	
	public void getNiveauScoreChallenge(Connecteur sql,String id_challenge)
	{
		
		
		try{
	        ResultSet rs = sql.exec("SELECT score_challenge,niveau_challenge FROM CHALLENGE where ID_CHALLENGE ='"+id_challenge+"'");
		
		if(rs!=null){		
			 while (rs.next()) {
		niveau =rs.getString("niveau_challenge");
		score =rs.getString("score_challenge");

			 }}
		}
		 catch (SQLException e) {
		 System.out.println("requet feha mochkla");
				e.printStackTrace();
				
			}

		
	}
	
	
	
	/*MAJ du score et du nombre de flags(si necessaire) pour l'equipe*/
	
	
	
	public void majScore(Connecteur sql, String id_equipe,String id_challenge,boolean flag)
	{
		String scorex,val2 = null;
	
		getNiveauScoreChallenge(sql, id_challenge);
		if(niveau.equals("1"))
			scorex="score1";
		else if(niveau.equals("2"))
			scorex="score2";
		else
			scorex="score3";
	
		try{
	        ResultSet rs = sql.exec("SELECT "+scorex+", nbr_flags FROM EQUIPE where ID_EQUIPE ='"+id_equipe+"'");
		
		if(rs!=null){		
			 while (rs.next()) {
		String val1 =rs.getString(scorex);
		 val2 =rs.getString("nbr_flags");
		
		score=String.valueOf(Integer.parseInt(val1)+Integer.parseInt(score));
		
		val2=String.valueOf(Integer.parseInt(val2)+1);
		
			 }}
		sql.update("update EQUIPE  set "+scorex+"='"+score+"' where id_equipe='"+id_equipe+"'");
		
		if(flag)
			sql.update("update EQUIPE  set nbr_flags ='"+val2+"' where id_equipe='"+id_equipe+"'");
		
		}
		 catch (SQLException e) {
			 System.out.println("requet feha mochkla");
					e.printStackTrace();
					
				}
		
	}
	
	

}
