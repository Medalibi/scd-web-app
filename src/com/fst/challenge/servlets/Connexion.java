package com.fst.challenge.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.annotation.WebServlet;
import javax.servlet.descriptor.JspConfigDescriptor;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import com.fst.challenge.beans.Connecteur;
import com.fst.challenge.beans.Flags;
import com.fst.challenge.beans.Historique;
import com.fst.challenge.beans.Identification;
import com.fst.challenge.beans.Scores;
import com.fst.challenge.beans.VerifierCode;
import com.sun.corba.se.spi.activation.Repository;

/**
 * Servlet implementation class Connextion
 */
@WebServlet("/Connextion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id_equipe,id_challenge;
       
  
    public Connexion() { super();     }
	public void init(ServletConfig config) throws ServletException {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {System.out.println(request.getMethod());}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id2 = null;
		Connecteur sql = new Connecteur();
		PrintWriter out = response.getWriter();

		
		
/*
		String challenge = request.getParameter("recaptcha_challenge_field");
		String resp= request.getParameter("recaptcha_response_field");
		String remoteAddr = request.getRemoteAddr();
		ReCaptchaImpl reCaptcha = new ReCaptchaImpl();

		// ***  PROVIDE  PRIVATE KEY HERE ***
		reCaptcha.setPrivateKey("6LcxU9oSAAAAADx2tVrgKS9dZeAJjbqqn3b10qAJ");
	

	//	ReCaptchaResponse reCaptchaResponse =
	//	reCaptcha.checkAnswer(remoteAddr, challenge, resp);
		//boolean valid = reCaptchaResponse.isValid();

	//	if (valid) {
		//System.out.println("yesssssssss");
*/
		//etablir la connexion avec la base de donnée
	
		
		if(sql.connect()!= null)
			
		{

			
			
			Identification  a = new Identification(sql,request.getParameter("login"),request.getParameter("pass"));
			
			// verification du login et mot de passe
			
				
			if(a.test())
				{
					id_equipe=a.getIdEquipe();
					VerifierCode ver = new VerifierCode();
					
						//verification du code challenge
						
					if(ver.verifier(sql, request.getParameter("code"),id_equipe))
						{
							id_challenge=ver.getId_challenge();
							
							//verification de l'etat du flag du challenge et MAJ si necessaire
							
							Flags f = new Flags();
							String etat= f.verfifier(sql, id_challenge);
							if(etat.equals("avec flag"))
							{
								// MAJ du historique
						
								Historique h = new Historique();
								if(	h.enregistrer(sql, id_equipe, id_challenge))
								{
									//MAJ du l'etat du flag
									
									f.majEtat(sql, id_challenge);
									
									//MAJ du score
									
									Scores s = new Scores();
									s.majScore(sql, id_equipe, id_challenge,true);
									out.println("{success:true,message:'flag_success'}");
								}//else System.out.println("pages/historique.jsp");
								
							}
							else if(etat.equals("flag retenu"))
								out.println("{success:false,message:'flag_retenu'}");
							else 
							{
								//MAJ du historique
								
								Historique h = new Historique();
								if(h.enregistrer(sql, id_equipe, id_challenge))
								{
									//MAJ du score
									
									Scores s = new Scores();
									s.majScore(sql, id_equipe, id_challenge,false);
									out.println("{success:true,message:'challenge_success'}");	
								}
								else out.println("{success:false,message:'challenge_exist'}");
								
								
							}
							
							// response.sendRedirect("pages/ErreurCode.jsp");
							}
			
						else out.println("{success:false,message:'code_error'}");
				}else out.println("{success:false,message:'login_error'}");
			sql.close();
			}else out.println("{success:false,message:'redirect'}");

		
	

}}
