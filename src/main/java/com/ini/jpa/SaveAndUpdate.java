package com.ini.jpa;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateExistUser")
public class SaveAndUpdate extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("ID"));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AryanMySql");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<User> cu = cb.createCriteriaUpdate(User.class);
		Root<User> root1 = cu.from(User.class);
		
		cu.set("Name", req.getParameter("Name"));
		cu.set("Email", req.getParameter("Email"));
		cu.set("DOB", req.getParameter("DOB"));
		cu.set("Country", req.getParameter("Country"));
		cu.where(cb.equal(root1.get("ID"), id));
		
		Query query1 = em.createQuery(cu);
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
