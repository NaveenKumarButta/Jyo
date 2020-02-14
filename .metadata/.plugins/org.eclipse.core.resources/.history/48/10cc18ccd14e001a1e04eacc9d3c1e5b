package com.capgemini.storesmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;
import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;
import com.capgemini.storesmanagementsystem.service.AdminService;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;
import com.capgemini.storesmanagementsystem.validation.Validation;

public class AdminController {
	static AdminService adminService = new AdminServiceImpl();
	AdminDaoImpl dao = new AdminDaoImpl();

	static Logger log = Logger.getLogger("store");
	static Scanner scan = new Scanner(System.in);

	static Validation validate = new Validation();

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
				while (true) {
					log.info("Enter the UserId");
					String userId = scan.next();
					boolean res1 = validate.idValidation(userId);
					if (res1) {
						user.setUserId(userId);
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				while (true) {
					log.info("Enter the UserName");
					String uname = scan.next();
					boolean res6 = validate.userNameValidation(uname);
					if (res6) {
						user.setUserName(uname);
						break;
					} else
						log.info("Invalid !! Try Again");
				}
				
				while (true) {
					log.info("Enter the Email(It Should contain Capital Letters" + "Special Characters,Digits)");
					String Email = scan.next();
					boolean res2 = validate.validateEmail(Email);
					if (res2) {
						user.setEmail(Email);
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				while (true) {
					log.info(
							"Enter the Password(Minimum 8 characters" + "Atleast 1 Capital Letter,1 Special Character");
					String password = scan.next();
					boolean res4 = validate.validatePassword(password);
					if (res4) {
						user.setPassword(password);
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				
				while (true) {
					log.info("Enter the Location(Give it in Alphabets)");
					String Location = scan.next();
					boolean res3 = validate.userNameValidation(Location);
					if (res3) {
						user.setAddress(Location);
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				while (true) {
					log.info("Enter the Role");
					String role = scan.next();
					boolean res5 = validate.userNameValidation(role);
					if (res5) {
						user.setUserRole(role);
						break;
					} else
						log.info("Invalid !! Try Again");
				}
				
				boolean u = adminService.addManufacturer(user);
				if (u)
					log.info("Insert Succesfully");
				else
					log.info("Insertion Failed");
				break;

			case 2:
				UserDetailsInfo user1 = new UserDetailsInfo();
				String userId = null;
				while (true) {
					log.info("Enter the UserID You want to Update");
					userId = scan.next();
					boolean res7 = validate.idValidation(userId);
					if (res7) {
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				while (true) {
					log.info("Enter the Username");
					String name = scan.next();
					boolean res8 = validate.userNameValidation(name);
					if (res8) {

						user1.setUserName(name);
						break;
					} else {
						log.info("Invalid !! Try Again");
					}
				}
				while (true) {
					log.info("Enter the Password");
					String pass = scan.next();
					boolean res9 = validate.validatePassword(pass);
					if (res9) {
						user1.setPassword(pass);
						break;
					} else
						log.info("Invalid !! Try Again");
				}
				while (true) {
					log.info("Enter the email");
					String emailid = scan.next();
					boolean result = validate.validateEmail(emailid);
					if (result) {
						user1.setEmail(emailid);
						break;
					} else
						log.info("Invalid !! Try Again");
				}
				boolean res = adminService.updateManufacturer(userId, user1);
				if (res)

					log.info("Record has been updated Successfully!!!");
				else
					log.info("Record has not updated");
				break;

			case 3:
				String userid = null;
				while (true) {
					log.info("Enter the UserId(String) You want to Delete");
					userid = scan.next();
					boolean result3 = validate.idValidation(userid);
					if (result3) {
						break;
					} else
						log.info("Invalid !! Try Again");
				}

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




	 
	


