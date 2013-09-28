package com.fst.challenge.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreparationDonnees {

private ArrayList list= new ArrayList();

public void demarer(String para){
	
	Connecteur c = new Connecteur();
	if(c.connect()!= null)
	{
	
	try{
        ResultSet rs = c.exec("SELECT nom_equipe,nbr_flags,score1,score2,score3,retrait,image FROM EQUIPE");
	
	if(rs!=null){		
		 while (rs.next()) {
			 
			 if(para.equals("getList"))
			{Rank e = new Rank();
			int score;
			
			e.setName(rs.getString("nom_equipe"));
			e.setImage(rs.getString("image"));
			
			score = Integer.parseInt(rs.getString("score1"))+Integer.parseInt(rs.getString("score2"))+Integer.parseInt(rs.getString("score3"))-Integer.parseInt(rs.getString("retrait"));
			
			e.setScore(score);
			list.add(e);
			
			}
			 else if(para.equals("getbarData"))
			 {
				 barData e = new barData();
					int score;
					
					e.setName(rs.getString("nom_equipe"));
					e.setLevel1(Integer.parseInt(rs.getString("score1")));
					e.setLevel2(Integer.parseInt(rs.getString("score2")));
					e.setLevel3(Integer.parseInt(rs.getString("score3")));
					list.add(e);
					
			 }
			 else if(para.equals("getpieData"))
			 {
				 pieData e = new pieData();
				 e.setName(rs.getString("nom_equipe"));
					e.setFlag(Integer.parseInt(rs.getString("nbr_flags")));
					list.add(e);
				 
			 }
		
			
	
			
			
			
		 }}}
		 catch (SQLException e) {
		 System.out.println("requet feha mochkla");
				e.printStackTrace();}
				
			c.close();}}



public ArrayList getDonnees()
{
	return list;
	}
}
