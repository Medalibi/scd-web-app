package com.fst.challenge.servlets;





import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;



import com.fst.challenge.beans.Connecteur;
import com.fst.challenge.beans.MD5;
import com.fst.challenge.beans.Rank;
import com.fst.challenge.beans.PreparationDonnees;
import com.fst.challenge.beans.RetraitScore;
import com.fst.challenge.beans.barData;
import com.fst.challenge.beans.pieData;

/**
 * Servlet implementation class DemandeAcces
 */
@WebServlet("/DemandeAcces")
public class DemandeInternet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeInternet() {
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
		
		PrintWriter out = response.getWriter();
		MD5 m = new MD5();

		String login=m.hasher(request.getParameter("login"));
		String pass=m.hasher(request.getParameter("pass"));
		String id_equipe= request.getParameter("team_id");
		System.out.println(id_equipe);
		Connecteur sql = new Connecteur();
		//if(login.equals("e8bf2a67cde65825c329479caca6618b")&& pass.equals("a998e136d6b4afd0e5fa092fbf1ef174"))
		if(1==1)
		{
			if(sql.connect()!=null)
		{
				RetraitScore r = new RetraitScore();
				try {
					r.retrait(id_equipe);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		sql.close();
		out.println("{success:true,message:'ok'}");
		sql.close();
		
		}
		else
			out.println("{success:true,message:'impossible_de_MAJ'}");
		}
		else
			out.println("{success:true,message:'login_error'}");
		
		
		
		
	}
		
	}


