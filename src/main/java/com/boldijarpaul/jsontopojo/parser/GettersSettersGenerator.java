package com.boldijarpaul.jsontopojo.parser;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

public class GettersSettersGenerator {
	/* returns getter and setters for a variable */
	public static String variableGetterAndSetter(Variable variable) {
		String result = "public " + variable.getType().toString() + " get"
				+ StringHelper.firstCharUppercase(variable.getName())
				+ "() {\n";
		result += "return " + variable.getName() + ";\n}\n";

		result += "public void set"
				+ StringHelper.firstCharUppercase(variable.getName()) + "(";
		result += variable.getType().toString() + " " + variable.getName();
		result += "){\n";
		result += "this." + variable.getName() + "=" + variable.getName()
				+ ";\n}\n";

		return result;
	}
	
	/* returns getter and setters for a array of a variable */
	public static String variableArrayGetterAndSetter(Variable variable) {
		String result = "public List<" + variable.getType().toString() + "> get"
				+ StringHelper.firstCharUppercase(variable.getName())
				+ "() {\n";
		result += "return " + variable.getName() + ";\n}\n";

		result += "public void set"
				+ StringHelper.firstCharUppercase(variable.getName()) + "(List<";
		result += variable.getType().toString() + "> " + variable.getName();
		result += "){\n";
		result += "this." + variable.getName() + "=" + variable.getName()
				+ ";\n}\n";

		return result;
	}

	/* returns the getters and setters for a class object */
	public static String classObjectGetterAndSetter(ClassObject classObject) {
		String nameLowercase = StringHelper.firstCharLowerCase(classObject
				.getName());
		String nameUppercase = StringHelper.firstCharUppercase(classObject
				.getName());

		String result = "public " + nameUppercase + " get" + nameUppercase
				+ "() {\n";
		result += "return " + nameLowercase + ";\n}\n";

		result += "public void set" + nameUppercase + "(";
		result += nameUppercase + " " + nameLowercase;
		result += "){\n";
		result += "this." + nameLowercase + "=" + nameLowercase + ";\n}\n";

		return result;
	}
	
	/* returns the getters and setters for a class object array */
	public static String classObjectArrayGetterAndSetter(ClassObject classObject) {
		String nameLowercase = StringHelper.firstCharLowerCase(classObject
				.getName());
		String nameUppercase = StringHelper.firstCharUppercase(classObject
				.getName());

		String result = "public List<" + nameUppercase + "> get" + nameUppercase
				+ "() {\n";
		result += "return " + nameLowercase + ";\n}\n";

		result += "public void set" + nameUppercase + "(List<";
		result += nameUppercase + "> " + nameLowercase;
		result += "){\n";
		result += "this." + nameLowercase + "=" + nameLowercase + ";\n}\n";

		return result;
	}

}
