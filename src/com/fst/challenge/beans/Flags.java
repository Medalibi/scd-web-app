package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 * Classe pour la gestion des flags
 * 
 * verification si le challenge est avec flags ou nn
 *
 * verification si le flag est retenu ou pas
 * 
 * MAJ de l'etat du flags ( le mettre a retenu)
 * 
 * 
 */
	




public class Flags {

	
	public Flags() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/* methode pour la verification du flag*/
	
	
public String verfifier(Connecteur sql ,String id_challenge)
{
	String reponse=null,flag=null;
	
	try{
        ResultSet rs = sql.exec("SELECT * FROM CHALLENGE where ID_CHALLENGE ='"+id_challenge+"'");
	
	if(rs!=null){		
		 while (rs.next()) {
	flag =rs.getString("flag");
	
	if(flag.equals("0"))
		reponse="sans flag";
	else if(flag.equals("1"))
		reponse="avec flag";
	else if (flag.equals("2"))
		reponse="flag retenu";
		 }
	}
	}
	 catch (SQLException e) {
	 System.out.println("requet feha mochkla");
			e.printStackTrace();
			
		}
	
	return reponse;
	
}


/*Methode pour la MAJ du flag*/



public boolean majEtat(Connecteur sql ,String id_challenge)
{
if(sql.update("update CHALLENGE set flag='2' where id_challenge='"+id_challenge+"'"))
		
		return true;
	return false;

}

}
