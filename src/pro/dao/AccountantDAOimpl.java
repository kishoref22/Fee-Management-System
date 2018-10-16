package pro.dao;

import pro.pojo.Accountant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pro.dao.DBConnect;

public class AccountantDAOimpl {

	public static String addAccountant(Accountant ac) throws SQLException {
		String suc;
		String name = ac.getName();
		String password = ac.getPassword();
		String email = ac.getEmail();
		String address = ac.getAddress();
		String contact = ac.getContact();

		Connection con = DBConnect.getConnection();
		String sql = "insert into accountant(name,password,email,address,contact) values(?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, contact);
			ps.executeUpdate();
			con.close();
			suc = "sucessfully added";
		} catch (SQLException e) {
			e.printStackTrace();
			suc = "failed";
		} finally {
			con.close();
			ps.close();
		}

		return suc;

	}

	public static void removeAccountant(String email) throws SQLException {
      String query = "delete from accountant where email = ?";
      Connection connection = null;
      connection = DBConnect.getConnection();
      PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
      ps.setString(1, email);
      ps.executeUpdate();
	  connection.close();
	  ps.close();
	  	
	}

	public static void updateAccountant(Accountant ac) throws SQLException {
		String query = "update accountant set name=?,password=?,address=?,contact=? where email=?";
		Connection con = null;
		con = DBConnect.getConnection();
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setString(1, ac.getName());
			ps.setString(2, ac.getPassword());
			ps.setString(3, ac.getAddress());
			ps.setString(4, ac.getContact());
			ps.setString(5, ac.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}
	}

	public static boolean checkAccountant(String email) throws SQLException {
       String query = "select * from accountant where email = ?";
       Connection con = null;
       con = DBConnect.getConnection();
       PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
	   ps.setString(1, email);
	   ResultSet rs = ps.executeQuery();
	   while(rs.next()) {
		   return true;
	   }
		return false;
	}

	public static Accountant viewAccountant(String emailref) throws SQLException {
		String query = "select * from accountant where email = ?";
		Connection con = null;
		con = DBConnect.getConnection();
		Accountant acc = null;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, emailref);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String contact = rs.getString("contact");
				acc = new Accountant(name, password, email, address, contact);
			}

		} catch (NullPointerException e) {
			System.out.println(e);
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

		return acc;
	}

	public static List<Accountant> viewAccountants() throws SQLException {
		List<Accountant> acc = new ArrayList<>();
		Connection con = null;
			con = DBConnect.getConnection();
		String sql = "select * from accountant";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String contact = rs.getString("contact");
				acc.add(new Accountant(name, password, email, address, contact));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			ps.close();
		}

		return acc;
	}

}
