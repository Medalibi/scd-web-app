package com.fst.challenge.beans;

import java.util.ArrayList;

public class trie {
	private ArrayList l= new ArrayList();

	public trie(ArrayList l2) {
		this.l=l2;
	int i=0;
	boolean change=true;
	while(change)
	{
		change=false;
		for(i=0;i<l.size()-1;i++)
		{
			if(((Rank)l.get(i)).getScore()<((Rank)l.get(i+1)).getScore())
			{	
				Rank e =(Rank)l.get(i);
				l.set(i,(Rank)l.get(i+1));
				l.set(i+1,e);
				change=true;
			}
		}
		
		
		
	}
	
	for(i=0;i<l.size();i++)
		
	{
		((Rank)l.get(i)).setRang(i+1);
		
	}
		
	}
	
	
	public ArrayList getList(){
		
		
		return l;
	}

}
