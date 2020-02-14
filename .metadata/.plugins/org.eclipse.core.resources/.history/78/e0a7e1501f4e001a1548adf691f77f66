package com.capgemini.storesmanagementsystem.validation;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.dao.AdminDaoImpl;

public class Validation {
	static Logger log = LogManager.getLogger("store");

	public static boolean passwordValidation(String userName, String password) {

		AdminDaoImpl dao = new AdminDaoImpl();
		List<String> login = null;
		try {
			login = dao.loginAdmin(userName, password);
		} catch (Exception e) {

			//throw new SchemaManagementException("login Failed");
		}
		String adminName = login.get(0);
		String password1 = login.get(1);

		if (userName.equals(adminName)) {
			if (password.equals(password1)) {
				return true;
			}
		}

		return false;

	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[@#$%!]).{8,40})";
	private Pattern pattern;
	private Matcher matcher;

	static Scanner scan;

	public Validation() {
		pattern = Pattern.compile(EMAIL_PATTERN);
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public Scanner integerValidation() {
		scan = new Scanner(System.in);

		while (!scan.hasNextInt()) {
			log.error("Enter the input in specified format");
			scan.next();
		}
		return scan;
	}

	public boolean validateEmail(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	public boolean validatePassword(final String password) {

		matcher = pattern.matcher(password);
		return matcher.matches();

	}

	public Boolean userNameValidation(String name) {
		Pattern pat = Pattern.compile("[A-Za-z]{1,40}");
		Matcher mat = pat.matcher(name);
		if (mat.matches()) {
			return true;
		}
		return false;
	}

	public Boolean idValidation(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if (mat.matches() && (Integer.parseInt(id) >= 0)) {
			return true;
		}
		return false;
	}



}
