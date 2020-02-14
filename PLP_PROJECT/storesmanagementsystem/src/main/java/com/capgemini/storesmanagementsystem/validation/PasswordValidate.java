package com.capgemini.storesmanagementsystem.validation;

public class PasswordValidate {
	public static boolean validPassword(String pwd) {
		if (!((pwd.length() >= 8) && (pwd.length() <= 15))) {
			return false;
		}

		if (pwd.contains(" ")) {
			return false;
		}

		if (true) {
			int count = 0;
			for (int i = 0; i <= 9; i++) {

				String str1 = Integer.toString(i);

				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		if (!(pwd.contains("@") || pwd.contains("#") || pwd.contains("!") || pwd.contains("~") || pwd.contains("$")
				|| pwd.contains("%") || pwd.contains("^") || pwd.contains("&") || pwd.contains("*") || pwd.contains("(")
				|| pwd.contains(")") || pwd.contains("-") || pwd.contains("+") || pwd.contains("/") || pwd.contains(":")
				|| pwd.contains(".") || pwd.contains(", ") || pwd.contains("<") || pwd.contains(">")
				|| pwd.contains("?") || pwd.contains("|"))) {
			return false;
		}

		if (true) {
			int count = 0;

			for (int i = 65; i <= 90; i++) {
				char c = (char) i;

				String str1 = Character.toString(c);
				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}

		if (true) {
			int count = 0;

			for (int i = 90; i <= 122; i++) {

				char c = (char) i;
				String str1 = Character.toString(c);

				if (pwd.contains(str1)) {
					count = 1;
				}
			}
			if (count == 0) {
				return false;
			}
		}
		return true;
	}

}
