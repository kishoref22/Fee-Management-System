package pro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import pro.pojo.Student;

public class StudentDAOimpl {
	public static boolean addStudent(Student student) throws SQLException {
		String query = "insert into Student(name,course,email,id,phone_no,dob,address,fee_paid,fee_due) values(?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		con = DBConnect.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, student.getName());
		ps.setString(2, student.getCourse());
		ps.setString(3, student.getEmail());
		ps.setString(4, student.getId());
		ps.setString(5, student.getPhone_no());
		ps.setDate(6, student.getDob());
		ps.setString(7, student.getAddress());
		ps.setInt(8, student.getFee_paid());
		ps.setInt(9, student.getFee_due());
		int status = ps.executeUpdate();
		ps.close();
		con.close();
		if (status == 1)
			return true;
		else {
			return false;
		}
	}

	public static boolean checkStudent(String email) {
		return false;

	}

	public static boolean removeStudent(String id) throws SQLException {
		String query = "delete from student where id = ?";
		Connection con = null;
		con = DBConnect.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, id);
		int flag = ps.executeUpdate();
		ps.close();
		con.close();
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean updateStudent(Student student, String id) throws SQLException {
		String query = "update student set name = ?, course = ?, email = ?, id = ?,phone_no = ?,dob = ?,address = ?,fee_paid = ?,fee_due = ? where id = ?";
		Connection con = null;
		con = DBConnect.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, student.getName());
		ps.setString(2, student.getCourse());
		ps.setString(3, student.getEmail());
		ps.setString(4, student.getId());
		ps.setString(5, student.getPhone_no());
		ps.setDate(6, student.getDob());
		ps.setString(7, student.getAddress());
		ps.setInt(8, student.getFee_paid());
		ps.setInt(9, student.getFee_due());
		ps.setString(10, id);
		int flag = ps.executeUpdate();
		ps.close();
		con.close();
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static List<Student> viewStudents() throws SQLException {
		String query = "select * from student";
		Connection con = null;
		List<Student> students = new ArrayList<>();
		con = DBConnect.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			String course = rs.getString("course");
			String email = rs.getString("email");
			String id = rs.getString("id");
			String phone_no = rs.getString("phone_no");
			Date dob = rs.getDate("dob");
			String address = rs.getString("address");
			int fee_paid = rs.getInt("fee_paid");
			int fee_due = rs.getInt("fee_due");
			students.add(new Student(name, course, email, id, phone_no, dob, address, fee_paid, fee_due));
		}
		con.close();
		ps.close();
		return (ArrayList<Student>) students;
	}

	public static Student getStudent(String ids) throws SQLException {
		String query = "select * from student where id = ?";
		Connection con = DBConnect.getConnection();
		Student student = null;
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		ps.setString(1, ids);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			String course = rs.getString("course");
			String email = rs.getString("email");
			String id = rs.getString("id");
			String phone_no = rs.getString("phone_no");
			Date dob = rs.getDate("dob");
			String address = rs.getString("address");
			int fee_paid = rs.getInt("fee_paid");
			int fee_due = rs.getInt("fee_due");

			student = new Student(name, course, email, id, phone_no, dob, address, fee_paid, fee_due);
		}
		con.close();
		ps.close();

		return student;
	}
}
