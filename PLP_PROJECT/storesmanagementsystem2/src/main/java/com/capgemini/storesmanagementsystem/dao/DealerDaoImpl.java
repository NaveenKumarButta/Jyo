package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.storesmanagementsystem.dto.OrderDetailsInfo;

public class DealerDaoImpl implements DealerDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	public List<String> loginDealer(String userId, String password) {
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

	public boolean makeOrder(OrderDetailsInfo order) {
		boolean isAdded = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = " insert into  orderDetailsInfo values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(qry);
		
			
			pstmt.setInt(1, order.getOrderId());
			pstmt.setInt(2, order.getProductId());
			pstmt.setInt(3, order.getQuantity());
			pstmt.setString(4, order.getAddress());
			pstmt.setString(5, order.getUserId());
			pstmt.setString(6,order.getUserName());
			pstmt.setString(7,order.getPassword());

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

	public boolean deleteOrder(Integer orderId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			con = DriverManager.getConnection(dburl);
			String qry = "delete from orderDetailsInfo where orderId=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.getMessage();
		}
		return true;
	}

	public List<String> showAllproducts() {
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

	public List<Integer> viewMyStore(Integer storeId) {
		List<Integer> storelist = new ArrayList<Integer>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from stockDetailsInfo where storeId='" + storeId + "'";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				storelist.add(rs.getInt("numOfItems"));
			}

		} catch (Exception e) {

			e.getMessage();
		}
		return storelist;
	}

	public List<String> viewMyOrders(String userId) {
		List<String> orderlist = new ArrayList<>();
		;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db?user=root&password=hr";
			Connection con = DriverManager.getConnection(dburl);
			String qry = "select * from orderDetailsInfo where userId='" + userId + "'";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(qry);

			while (rs.next()) {
				orderlist.add(rs.getString("address"));
				
			}
		} catch (Exception e) {

			e.getMessage();
		}
		return orderlist;
	}

}
