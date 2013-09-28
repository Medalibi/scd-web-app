package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;


public class RetraitScore {

	
  public void retrait(String id_equipe) throws SQLException {
  

    	//TODO recuperation de  l'id  equipe 

    //   String  idEquipe = "1";
      Connecteur connecteur = new  Connecteur();
      if (connecteur.connect()){     
      
      String query = "SELECT retrait from EQUIPE where id_equipe = '" + id_equipe +"'";         
      ResultSet result = connecteur.exec(query);
       
      if(result.first()){
    	  int  retrait = result.getInt(1); 
    	  System.out.print("Retarait before update :" + retrait);
    	  result.close();

          retrait+=3;

    	 connecteur.update("Update EQUIPE set retrait =" + retrait + " where id_equipe = '" + id_equipe + "'");
 
      }
      }
  }
  }
