package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDao {

	private Connection conn;

	public StudentDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addStudent(Student s) {
		boolean f = false;

		try {

			String sql = "insert into studentinfo (name,dob,qualification,address,email) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getQualification());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getEmail());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<>();
		Student s = null;

		try {

			String sql = "select * from studentinfo";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setQualification(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setEmail(rs.getString(6));
				list.add(s);

			}

		}

		catch (

		Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public Student getStudentById(int id) {

		Student s = null;

		try {

			String sql = "select * from studentinfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setQualification(rs.getString(4));
				s.setAddress(rs.getString(5));
				s.setEmail(rs.getString(6));

			}

		}

		catch (

		Exception e) {
			e.printStackTrace();
		}

		return s;

	}

	public boolean updateStudent(Student s) {
		boolean f = false;

		try {

			String sql = "update studentinfo set name=?, dob=?, qualification=?, address=? ,email=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getDob());
			ps.setString(3, s.getQualification());
			ps.setString(4, s.getAddress());
			ps.setString(5, s.getEmail());
			ps.setInt(6, s.getId());
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

	public boolean deleteStudent(int id) {
		boolean f = false;

		try {

			String sql = "delete from studentinfo where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;

	}

}
