package com.capgemini.storesmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class AdminDaoImpl implements AdminDao {
	static Logger log = LogManager.getLogger("Admin class");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public boolean loginAdmin(UserDetailsInfo info) {
		
            try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select userId,password from userDetailsInfo where userId=?";

			ps = con.prepareStatement(query);
			    int userId =123;
				String password = "root123";
				
				if ((userId==info.getUserId())&&(password.equals(info.getPassword()))) {
					log.info("successfully login");
					return true;
				} else {
					return false;
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(" Username and password is wrong  ");
				
				}finally {
					try {
						con.close();
					} catch (SQLException e) {
						
						log.info("Exception occured");
					}
				}
			return false;
			
			
		}
	

		public boolean addManufacturer(UserDetailsInfo info) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "insert into userDetailsInfo values(?,?,?,?,?,?)";

			ps = con.prepareStatement(query);
			ps.setInt(1,info.getUserId());
			ps.setString(2, info.getUserName());
			ps.setString(3,info.getEmail());
			ps.setString(4,info.getPassword());
			ps.setString(5,info.getAddress());
			ps.setString(6, info.getUserRole());

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

	

	public  boolean updateManufacturer(UserDetailsInfo info) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "update userDetailsInfo set userName=? WHERE userId=?";
            ps = con.prepareStatement(query);
			ps.setString(1,info.getUserName());
			ps.setInt(2, info.getUserId());


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
	public boolean deleteManufacturer(UserDetailsInfo info) {
	
			try {

				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
				con = DriverManager.getConnection(dburl, "root", "hr");
				String query = "delete from userDetailsInfo where userName=?";

				ps = con.prepareStatement(query);

				ps.setString(1, info.getUserName());


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
	public boolean showManufacturer(UserDetailsInfo info) {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/stores_management_db";
			con = DriverManager.getConnection(dburl, "root", "hr");
			String query = "select * from userDetailsInfo";

			ps = con.prepareStatement(query);
			ps.setInt(1,info.getUserId());
			ps.setString(2, info.getUserName());
			ps.setString(3,info.getEmail());
			ps.setString(4,info.getPassword());
			ps.setString(5,info.getAddress());
			ps.setString(6,info.getUserRole());

			int count = ps.executeUpdate();
			log.info("no of rows affected: " + count);

		} catch (Exception e) {
			log.info("Exception in deleting records");
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
}


	

	


		

