package com.capgemini.storesmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.service.AdminService;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;

public class AdminController {
	AdminService adminService = new AdminServiceImpl();
	AdminDaoImpl dao = new AdminDaoImpl();

	Logger log = Logger.getLogger("store");
	Scanner scan = new Scanner(System.in);

	void adminTask() {
		int choice = 0;

		log.info("Welcome to Admin's Page");
		log.info("1.Add Manufactures");
		log.info("2.Update Manufactures");
		log.info("3.Delete Manufactures");
		log.info("4.Show Manufactures");
		log.info("5.Exit");

		do {

			log.info("************************");
			log.info("Enter Your Choice");
			log.info("************************");
			choice = scan.nextInt();
			switch (choice) {

			case 1:

				UserDetailsInfo user = new UserDetailsInfo();
				log.info("Enter the UserId");
				String userId = scan.next();
				user.setUserId(userId);

				log.info("Enter the Email");
				String Email = scan.next();
				user.setEmail(Email);

				log.info("Enter the Location");
				String Location = scan.next();
				user.setAddress(Location);

				log.info("Enter the Password");
				String password = scan.next();
				user.setPassword(password);

				log.info("Enter the Role");
				String role = scan.next();
				user.setUserRole(role);;

				log.info("Enter the UserName");
				String uname = scan.next();
				user.setUserName(uname);

				// dao.addManufactur(user);
				boolean u = adminService.addManufacturer(user);
				if (u)
					log.info("Insert Succesfully");
				break;

			case 2:
				UserDetailsInfo user1 = new UserDetailsInfo();
				log.info("Enter the User_ID You want to Update");
				String id = scan.next();

				log.info("Enter the Username");
				String name = scan.next();
				user1.setUserName(name);

				log.info("Enter the Password");
				String pass = scan.next();
				user1.setPassword(pass);

				log.info("Enter the email");
				String emailid = scan.next();
				user1.setEmail(emailid);

				// dao.updateManufactur(id,user1);
				boolean res = adminService.updateManufacturer(id, user1);
				if (res)

					log.info("Record has been updated Successfully!!!");
				else
					log.info("Record has not updated");
				break;

			case 3:
				log.info("Enter the UserId(String) You want to Delete");
				String userid = scan.next();
				
				boolean d = adminService.deleteManufacturer(userid);
				if (d)
					log.info("User_Id is deleted Succesfully");
				else
					log.info("UserID not found");
				break;

			case 4:
				log.info("--------------Manufacturer's Info----------------");
				List<String> li = adminService.viewAllManufacturer();

				log.info(li);
				break;

			default:
				System.out.println("Invalid Choice...");
				break;

			}

		} while (choice != 5);
	}

	
	
}
	 
	


