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
import com.entity.Student;

@WebServlet("/editStudent")
public class editStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("fullname");
		String dob = req.getParameter("dob");
		String qualification = req.getParameter("qualification");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));


		Student s = new Student(id, name, dob, qualification, address, email);

		StudentDao dao = new StudentDao(DBConnect.getConn());

		boolean f = dao.updateStudent(s);

		HttpSession session = req.getSession();

		if(f) {

			session.setAttribute("succMsg", "Student Details Updated Successfully");
			resp.sendRedirect("index.jsp");

		}
		else {
			session.setAttribute("errorMsg", "Something Went Wrong");
			resp.sendRedirect("index.jsp");
		}

	}

}
