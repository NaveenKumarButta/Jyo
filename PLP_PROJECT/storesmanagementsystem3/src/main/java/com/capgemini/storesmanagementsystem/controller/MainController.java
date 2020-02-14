package com.capgemini.storesmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dto.UserDetailsInfo;

public class MainController {
	static UserDetailsInfo info;
	static Logger log=LogManager.getLogger("");
    static int key;
    static AdminController a = new AdminController();
     public static void main(String[] args) throws InterruptedException {
    	 BasicConfigurator.configure();	
    	 Scanner sc = new Scanner(System.in);
			log.info("Welcome to Home Page");
			Thread.sleep(3000);
			log.info("Choose the below Option");
			Thread.sleep(2000);
			log.info("Press 1 for HomePage");
			Thread.sleep(1000);
			log.info("Press 2 for Admin");
			Thread.sleep(1000);
			log.info("press 3 for Manufacturer");
            Thread.sleep(1000);
            log.info("press 4 for dealer");
     
            int key=sc.nextInt();
			switch (key) {
  		case 1:
  			log.info("press 1 for admin");
//				CRegistration re = new CRegistration();
//				UserRegistration res = new UserRegistration();
//				re.enterDetails(res);
//				IRegistration reg = FUserRegistration.registration("one");
//				reg.register(res);
                a.showMenu();
           
			break;
			case 2:
					log.info("Press 2 for adding manufacturer");
//				break;
//			case 3:
//					log.info("Press 3 for HomePage");
//				break;
//			case 4:
//					log.info("Press 4 for Login ");
//				break;
					a.showMenu();

			default:
				sc.close();
				log.info("Invalid msg");
			
     }
     }
     }
		

	


