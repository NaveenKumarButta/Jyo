package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dto.ProductDetailsInfo;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class ManufacturerImpl implements ManufacturerDao{
	static Logger log = LogManager.getLogger("Admin class");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public boolean loginManufacturer(UserDetailsInfo info) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select userId,password from userDetailsInfo where userId=?";

			ps = con.prepareStatement(query);
			ps.setInt(1,info.getUserId());
			ps.setString(2,info.getPassword());

			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;
	}
	
		
	

	@Override
	public boolean addDealer(UserDetailsInfo info1) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "insert into userDetailsInfo values(?,?,?,?,?,?)";

			ps = con.prepareStatement(query);
			ps.setInt(1,info1.getUserId());
			ps.setString(2, info1.getUserName());
			ps.setString(3,info1.getEmail());
			ps.setString(4,info1.getPassword());
			ps.setString(5,info1.getAddress());
			ps.setString(6, info1.getUserRole());

			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;
	}

		
	

	@Override
	public boolean modifyDealer(UserDetailsInfo info2) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "update userDetailsInfo set userName=? WHERE userId=?";
            ps = con.prepareStatement(query);
			ps.setString(1,info2.getUserName());
			ps.setInt(2, info2.getUserId());


			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception arises");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception came");
			}
		}
		return false;

		
	}

	@Override
	public boolean removeDealer(UserDetailsInfo info3) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "delete from userDetailsInfo where userName=?";

			ps = con.prepareStatement(query);

			ps.setString(1, info3.getUserName());


			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception 1");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Hello Exception");
			}
		}
		return false;

	
		
	}

	@Override
	public boolean showDealer(UserDetailsInfo info4) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select * from userDetailsInfo";

			ps = con.prepareStatement(query);
			ps.setInt(1,info4.getUserId());
			ps.setString(2, info4.getUserName());
			ps.setString(3,info4.getEmail());
			ps.setString(4,info4.getPassword());
			ps.setString(5,info4.getAddress());
			ps.setString(6,info4.getUserRole());

			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in showing records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in Show records");
			}
		}
		return false;

	}
	public boolean addProduct(ProductDetailsInfo product) {
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "insert into ProductInfoDetails values(?,?,?,?,?)";

			ps = con.prepareStatement(query);
			ps.setInt(1,product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4,product.getWarranty());
			ps.setString(5,product.getProductBrand());
		
			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in login records");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception in login records 1");
			}
		}
		return false;
}

public boolean modifyProduct(ProductDetailsInfo product1) {
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "tiger");

			String query = "update userDetailsInfo set ProductName=? WHERE getPrice=?";
            ps = con.prepareStatement(query);
			ps.setString(1,product1.getProductName());
			ps.setDouble(2, product1.getPrice());


			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);
			

		} catch (Exception e) {
			log.info("Exception arises");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}

			} catch (SQLException e) {
				log.info("Exception came");
			}
		}
		return false;

	}

	

public boolean removeProduct(ProductDetailsInfo product2) {
	
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
				con = DriverManager.getConnection(dburl, "root", "tiger");
				String query = "delete from ProductInfoDetails where ProductId=?";

				ps = con.prepareStatement(query);
				ps.setInt(1,product2.getProductId());

			


				int count = ps.executeUpdate();
				log.info("no of rows affected: " + count);

			} catch (Exception e) {
				log.info("Exception 1");
			} finally {
				try {
					if (con != null) {
						con.close();
					}
					if (ps != null) {
						ps.close();
					}

				} catch (SQLException e) {
					log.info("Hello Exception");
				}
			}
			return false;



		}


		
	}
	


