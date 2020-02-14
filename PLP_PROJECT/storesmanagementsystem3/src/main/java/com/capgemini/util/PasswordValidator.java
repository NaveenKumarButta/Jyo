package com.capgemini.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordValidator {

	public static boolean passwordValidator(String plainPassword,String hashedPassword) {
		return BCrypt.checkpw(plainPassword ,hashedPassword);
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the password to be encoded");
		String plainPassword=sc.nextLine();
		String hashedPassword=PasswordEncrypter.passwordEncryptor(plainPassword);
		System.out.println(hashedPassword);
		System.out.println("Enter the password to be match");
		String password=sc.nextLine();
		if(passwordValidator(password,hashedPassword)) {
			System.out.println("password matches");
		}else {
			System.out.println("Invalid password");
		}
		sc.close();
		
	}
}
