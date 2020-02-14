package com.capgemini.storesmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.service.AdminService;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;

public class StoresInfoController {
	static Logger log = Logger.getLogger("store");

	public static void main(String[] args) {
		BasicConfigurator.configure();
		AdminServiceImpl service = new AdminServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;

		log.info("1.Admin");
		log.info("2.Manufacturer");
		log.info("3.Dealer");
		log.info("4.Exit");

		int count = 0;

		do {
            log.info("...................................");
			log.info("Enter Your Choice");
			log.info("...................................");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
                
				if (count < 1) {
					count++;
					while(true) {
					log.info("Enter your id");
					String id=sc.next();
					log.info("Enter Your Username:");
					String name = sc.next();
					log.info("Enter Your Password:");
					String password = sc.next();
					
					boolean b=service.passwordValidate(password);
					if(b) {
						service.loginAdmin(name, password, id);
						log.info("successFully Login");
						break;
					}else {
						log.info("invalid");
					}
				}
			}

				AdminController admin = new AdminController();
				admin.adminTask();

				break;

			case 2:

				ManufacturerController manufacturer = new ManufacturerController();
				manufacturer.manufacturerTask();
				break;

			case 3:

				DealerController dealer = new DealerController();
				dealer.dealerTask();
				break;

			}
		} while (choice != 4);

		log.trace("ThankYou!!!!!!");
		sc.close();

	}
	
}
