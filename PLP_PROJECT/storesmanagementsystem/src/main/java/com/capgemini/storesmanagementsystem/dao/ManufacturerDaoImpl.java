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

public class ManufacturerDaoImpl implements ManufacturerDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginManufacturer(String userId, String password) {

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
			String qry = " insert into  userDetailsInfo  values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, dealer.getUserId());
			pstmt.setString(6, dealer.getUserName());
			pstmt.setString(2, dealer.getEmail());
			pstmt.setString(4, dealer.getPassword());
			pstmt.setString(3, dealer.getAddress());
			pstmt.setString(5, dealer.getUserRole());
			
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
	

	public boolean modifyDealer(String userId,UserDetailsInfo user) {
		int i=0;
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update userDetailsInfo set userName=?,email=?,password=?,address=?,userRole=? where userId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4, user.getAddress());
		    pstmt.setString(1, user.getUserRole());
		    pstmt.setString(2, user.getUserId());
		    
			i = pstmt.executeUpdate();
			

		} catch (Exception e) {
		
			e.printStackTrace();
		}

		if(i<1) {
			return flag;
		}
		else {
			flag=true;
			return flag;
		}
	}

	

	public boolean removeDealer(String userId) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from userDetailsInfo  where userId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, userId);
			int n = pstmt.executeUpdate();
			System.out.println(n);
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> viewAllDealers(String user) {
		List<String> manufactures = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from userDetailsInfo ";
			pstmt=con.prepareStatement(qry);

		     rs = pstmt.executeQuery();

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
			pstmt.setString(5, product.getMinStocksPresent());
			pstmt.setString(4, product.getWarranty());
			
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

	public boolean modifyProduct(String  product) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "update  productDetailsInfo set productName='sparx' where productId='" + product + "' ";
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
			String qry = "delete from productDetailsInfo where productId=? ";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;

	}

	public List<String> viewAllProducts() {
		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from productDetailsInfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("brand"));
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}

	public List<String> viewAllOrders() {
		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from productDetailsInfo";
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

		List<String> productlist = new ArrayList<String>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);

			String qry = "select * from storesInfo";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				productlist.add(rs.getString("productId"));
				productlist.add(rs.getString("storesId"));
				productlist.add(rs.getString("minStocksPresent"));
				productlist.add(rs.getString("numOfItems"));
				
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return productlist;

	}
}
