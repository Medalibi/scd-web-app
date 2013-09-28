package com.fst.challenge.beans;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class MD5Script
{
    private static String encode(String password)
    {
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;

        try
        {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new Error("No MD5 support in this VM.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++)
        {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1)
            {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            }
            else
                hashString.append(hex.substring(hex.length() - 2));
        }
        return hashString.toString();
    }

    public static void main(String[] args)throws IOException
    {
        
    	
    	PrintWriter ecrivain;
        int n = 5;

        ecrivain =  new PrintWriter(new BufferedWriter
    	   (new FileWriter("/home/dali/script.txt")));
       
     
      
        
        
        
     ArrayList l = new ArrayList();
  
     String Newligne=System.getProperty("line.separator"); 

     
   l.add("cllfst");l.add("marwen");l.add("big");l.add("ahmed");l.add("dali");l.add("essii");
     l.add("manel");l.add("yosri");l.add("basboussa");l.add("sabrine");l.add("sakura");l.add("eroi");
     l.add("meriam");l.add("safé");l.add("aba3ziz");l.add("3ibes");l.add("arnoub");l.add("daynasou");
     l.add("safé");l.add("nouha");l.add("mohamed");l.add("za3roura");l.add("zoumta3");l.add("5layel");
     
     for(int i=0 ;i<l.size();i++){
        String toEncode = (String)l.get(i);
        ecrivain.println("INSERT INTO EQUIPE VALUES("+(i+1)+",'"+toEncode+"','"+encode(toEncode)+"','"+encode(toEncode)+"',"+(i+1)+",0,0,0,0,0,'logo_team_1.png');"+Newligne);

      
     
     }
     ecrivain.close();
    }
}

