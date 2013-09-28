package com.fst.challenge.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fst.challenge.beans.PreparationDonnees;
import com.fst.challenge.beans.Rank;
import com.fst.challenge.beans.barData;
import com.fst.challenge.beans.pieData;
import com.fst.challenge.beans.trie;

/**
 * Servlet implementation class EnvoiDonnees
 */
@WebServlet("/EnvoiDonnees")
public class EnvoiDonnees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnvoiDonnees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String root="",para=request.getParameter("getJson");
	
		PreparationDonnees p = new PreparationDonnees();
		p.demarer(para);
		ArrayList l = p.getDonnees();
		

		JSONArray T=new JSONArray();
		
		if(para.equals("getList"))
		{
			
			
			trie t=new trie(l);
			l=t.getList();
			root="rank";
		for(int i=0;i<l.size();i++)
		{
			//get item Object
            Rank e = (Rank)l.get(i);
            //this creates a JSON object from bean object
            JSONObject equipeObj = JSONObject.fromObject(e);
            //add to array list
            T.add(equipeObj);
			
		}}
		
		else if(para.equals("getbarData"))
		{
			
			root="teams";
			
			for(int i=0;i<l.size();i++)
			{
				//get item Object
	            barData e = (barData)l.get(i);
	            //this creates a JSON object from bean object
	            JSONObject equipeObj = JSONObject.fromObject(e);
	            //add to array list
	            T.add(equipeObj);
				
			}
			
		}else if(para.equals("getpieData"))
		{
			
			
			
			root="teams";
			
			for(int i=0;i<l.size();i++)
			{
				//get item Object
	            pieData e = (pieData)l.get(i);
	            //this creates a JSON object from bean object
	            JSONObject equipeObj = JSONObject.fromObject(e);
	            //add to array list
	            T.add(equipeObj);
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		 JSONObject myObj = new JSONObject();
	        //sets success to true
	        myObj.put("success", true);
	        //set the JSON root to items
	        myObj.put(root, T);
	        //set the total number of Items
	       // myObj.put("totalCount", l.size());
	        PrintWriter out = response.getWriter();
	        //set content type
	        response.setContentType("text/html");
	       /* response.setHeader("Cache-control", "no-cache, no-store");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Expires", "-1");
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        response.setHeader("Access-Control-Allow-Methods", "POST,GET");
	        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	        response.setHeader("Access-Control-Max-Age", "86400");*/
	        out.println(myObj.toString());
	        out.close();
		
	}
	}


