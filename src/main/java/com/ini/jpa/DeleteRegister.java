package com.ini.jpa;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteRegister")
public class DeleteRegister extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int ID = Integer.parseInt(req.getParameter("ID"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AryanMySql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaDelete<User> cd = cb.createCriteriaDelete(User.class);
		Root<User> root = cd.from(User.class);
		cd.where(cb.equal(root.get("ID"), ID));
		
		Query query1 = em.createQuery(cd);
		int result = query1.executeUpdate();
		
		// Select
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root2 = cq.from(User.class);
		cq.select(root2);
		Query query2 = em.createQuery(cq);
		List<User> user =  query2.getResultList();

		req.setAttribute("userList", user);
		RequestDispatcher rd = req.getRequestDispatcher("displayAllRegister.jsp");
		rd.forward(req, resp);

		et.commit();
		em.close();
	}

}
