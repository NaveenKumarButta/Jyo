package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.exception.InsertionFailedException;

public class AdminDaoImpl implements AdminDao {

	public boolean loginAdmin(String name, String password, String id) {
		boolean isCheck = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select userName,password from userDetailsInfo where userId ='" + id + "'";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");

			pstmt.setString(1, id);
			while (rs.next()) {
				if (rs.getString("userName").equals(name) && rs.getString("password").equals(password)) {
					isCheck = true;
				} else {
					// log.info("wrong credentials");
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return isCheck;
	}

	public boolean addManufacturer(UserDetailsInfo user) {
		boolean isAdded = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = " insert into userdetailinfo   values (?,?,?,?,?,?)";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getUserRole());
			int r = pstmt.executeUpdate();

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean updateManufacturer(String userId, UserDetailsInfo user) {
		boolean isUpdated = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "update userdetailinfo set userName=?,email=?,password=? where userId='" + userId + "' ";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			int n = pstmt.executeUpdate();
			if (n != 0) {
				isUpdated = true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isUpdated;
	}

	public boolean deleteManufacturer(String userId) {
		boolean isDeleted = false;
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "delete from userdetailinfo where userId=?";

		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			pstmt.setString(1, userId);
			int r = pstmt.executeUpdate();
			if (r != 0) {
				isDeleted = true;
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return isDeleted;
	}

	public List<String> viewAllManufacturer() {

		List<String> manufactures = new ArrayList<>();
		String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=tiger&useSSL=false";
		String qry = "select * from userdetailinfo ";
		try (Connection con = DriverManager.getConnection(dburl);
				PreparedStatement pstmt = con.prepareStatement(qry);

				ResultSet rs = pstmt.executeQuery(qry);) {
			Class.forName("com.mysql.jdbc.Driver");
			while (rs.next()) {
				manufactures.add(rs.getString("userId"));
				manufactures.add(rs.getString("userName"));
				manufactures.add(rs.getString("email"));
				manufactures.add(rs.getString("password"));
				manufactures.add(rs.getString("address"));
				manufactures.add(rs.getString("userRole"));

			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}

}