package com.capgemini.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncrypter {

	public static String passwordEncryptor(String plainPassword) {
		return BCrypt.hashpw(plainPassword,BCrypt.gensalt());
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the password to be encoded..");
        System.out.println(passwordEncryptor(sc.nextLine()));
        sc.close();
	}
}
