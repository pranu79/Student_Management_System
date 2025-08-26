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

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {

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

		Student s = new Student(name, dob, qualification, address, email);

		StudentDao dao = new StudentDao(DBConnect.getConn());

		boolean f =dao.addStudent(s);

		HttpSession session = req.getSession();



		if(f) {

			session.setAttribute("succMsg", "Student Details Added Successfully");
			resp.sendRedirect("add_student.jsp");

		}
		else {
			session.setAttribute("errorMsg", "Something Went Wrong");
			resp.sendRedirect("add_student.jsp");
		}


	}




}
