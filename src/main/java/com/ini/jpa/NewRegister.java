package com.ini.jpa;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newRegister")
public class NewRegister extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User u = new User();
		u.setID(Integer.parseInt(req.getParameter("ID")));
		u.setName(req.getParameter("Name"));
		u.setEmail(req.getParameter("Email"));
		u.setDOB(req.getParameter("DOB"));
		u.setCountry(req.getParameter("Country"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AryanMySql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		em.persist(u);
		
		et.commit();
		em.close();
		
		resp.sendRedirect("index.jsp");
	}

}
