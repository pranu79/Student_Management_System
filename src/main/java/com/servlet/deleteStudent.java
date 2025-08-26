package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connect.DBConnect;
import com.dao.StudentDao;

@WebServlet("/delete")
public class deleteStudent  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		StudentDao dao = new StudentDao(DBConnect.getConn());

		boolean f = dao.deleteStudent(id);

		HttpSession session = req.getSession();

		if (f) {

			session.setAttribute("succMsg", "Student Details Deleted Successfully");
			resp.sendRedirect("index.jsp");

		} else {
			session.setAttribute("errorMsg", "Something Went Wrong");
			resp.sendRedirect("index.jsp");
		}
	}


}
