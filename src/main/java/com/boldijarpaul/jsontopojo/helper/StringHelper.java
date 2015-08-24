package com.boldijarpaul.jsontopojo.helper;

public class StringHelper {
	/* makes the first char upper case of a string */
	public static String firstCharUppercase(String text) {
		char first = Character.toUpperCase(text.charAt(0));
		return first + text.substring(1);
	}
	/* makes the first char lower case of a string */
	public static String firstCharLowerCase(String text) {
		char first = Character.toLowerCase(text.charAt(0));
		return first + text.substring(1);
	}
}
