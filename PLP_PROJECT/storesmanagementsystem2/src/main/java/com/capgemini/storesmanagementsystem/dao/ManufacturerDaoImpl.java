package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerDaoImpl {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginManufact(String userId, String password) {

		List<String> users = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = "select * from userDetailsInfo where userId ='" + userId + "' and password='" + password + "'";
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				users.add(rs.getString("userId"));
				users.add(rs.getString("password"));

			}
		} catch (Exception e) {
			e.getMessage();
		}

		return users;
	}

	public boolean addDealer(UserDetailsInfo dealer) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  usersDetailsInfo  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealer.getUserId());
			pstmt.setString(2, dealer.getUserName());
			pstmt.setString(3, dealer.getEmail());
			pstmt.setString(4, dealer.getPassword());
			pstmt.setString(5, dealer.getAddress());
			pstmt.setString(6, dealer.getUserRole());
			
			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;
	}

	public boolean modifyDealer(String user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update userDetailsInfo set userRole='Admin' where userId='" + user + "' ";
			pstmt = con.prepareStatement(qry);
			int i = pstmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return false;
	}

	public boolean removeDealer(String dealerId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from userDetailsInfo where userRole='dealer' and userId='" + dealerId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealerId);
			int n = pstmt.executeUpdate();
			System.out.println(n);
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> viewAllDealers(String role) {
		List<String> manufactures = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from users_info where role='" + role + "' ";
			pstmt = con.prepareStatement(qry);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				manufactures.add(rs.getString("userName"));

			}
		} catch (Exception e) {

			e.getMessage();
		}

		return manufactures;

	}

	public boolean addProduct(ProductDetailsInfo product) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  productDetailsInfo  values (?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setDouble(3, product.getPrice());
			pstmt.setString(4, product.getWarranty());
			pstmt.setString(5, product.getProductBrand());

			int r = pstmt.executeUpdate();
			System.out.println(r);

			if (r != 0) {
				isAdded = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return isAdded;

	}

	public boolean modifyProduct(String productId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update  productDetailsInfo set productBrand='sparx' where productId='" + productId + "' ";
			pstmt = con.prepareStatement(qry);
			pstmt.executeUpdate();

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return true;
	}

	public boolean removeProduct(Integer productId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from productDetailsInfo  and productId=? ";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;

	}

	public List<String> viewAllProducts() {
		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from productDetailsInfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("productBrand"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewAllOrders() {
		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from orderDetailsInfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("userId"));
				productlist.add(rs.getString("address"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewStore() {

		List<String> productlist = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from stockDetailsInfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getInt("storeId"), qry);
				productlist.add(rs.getString("minStockMaintain"));
				productlist.add(rs.getString("numOfItems"));

			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

}
