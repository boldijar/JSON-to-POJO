package com.boldijarpaul.jsontopojo.helper;

public class StringHelper {
	public static String firstCharUppercase(String text) {
		char first = Character.toUpperCase(text.charAt(0));
		return first + text.substring(1);
	}

	public static String firstCharLowerCase(String text) {
		char first = Character.toLowerCase(text.charAt(0));
		return first + text.substring(1);
	}
}
