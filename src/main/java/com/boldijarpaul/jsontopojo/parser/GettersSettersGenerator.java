package com.boldijarpaul.jsontopojo.parser;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

public class GettersSettersGenerator {
	/* returns getter and setters for a variable */
	public static String variableGetterAndSetter(Variable variable) {
		String result = StringHelper.tab + "public "
				+ variable.getType().toString() + " get"
				+ StringHelper.firstCharUppercase(variable.getName())
				+ "() {\n";
		result += StringHelper.tab + StringHelper.tab + "return "
				+ variable.getName() + ";\n" + StringHelper.tab + "}\n";

		result += "\n";

		result += StringHelper.tab + "public void set"
				+ StringHelper.firstCharUppercase(variable.getName()) + "(";
		result += variable.getType().toString() + " " + variable.getName();
		result += ") {\n";
		result += StringHelper.tab + StringHelper.tab + "this."
				+ variable.getName() + " = " + variable.getName() + ";\n"
				+ StringHelper.tab + "}\n";
		result += "\n";
		return result;
	}

	/* returns getter and setters for a array of a variable */
	public static String variableArrayGetterAndSetter(Variable variable) {
		String result = StringHelper.tab + "public List<"
				+ variable.getType().toString() + "> get"
				+ StringHelper.firstCharUppercase(variable.getName())
				+ "() {\n";
		result += StringHelper.tab + StringHelper.tab + "return "
				+ variable.getName() + ";\n" + StringHelper.tab + "}\n";

		result += "\n";

		result += StringHelper.tab + "public void set"
				+ StringHelper.firstCharUppercase(variable.getName())
				+ "(List<";
		result += variable.getType().toString() + "> " + variable.getName();
		result += ") {\n";
		result += StringHelper.tab + StringHelper.tab + "this."
				+ variable.getName() + " = " + variable.getName() + ";\n"
				+ StringHelper.tab + "}\n";

		result += "\n";

		return result;
	}

	/* returns the getters and setters for a class object */
	public static String classObjectGetterAndSetter(ClassObject classObject) {
		String nameLowercase = StringHelper.firstCharLowerCase(classObject
				.getName());
		String nameUppercase = StringHelper.firstCharUppercase(classObject
				.getName());

		String result = StringHelper.tab + "public " + nameUppercase + " get"
				+ nameUppercase + "() {\n";
		result += StringHelper.tab + StringHelper.tab + "return "
				+ nameLowercase + ";\n" + StringHelper.tab + "}\n";

		result += "\n";

		result += StringHelper.tab + "public void set" + nameUppercase + "(";
		result += nameUppercase + " " + nameLowercase;
		result += ") {\n";
		result += StringHelper.tab + StringHelper.tab + "this." + nameLowercase
				+ " = " + nameLowercase + ";\n" + StringHelper.tab + "}\n";

		result += "\n";

		return result;
	}

	/* returns the getters and setters for a class object array */
	public static String classObjectArrayGetterAndSetter(ClassObject classObject) {
		String nameLowercase = StringHelper.firstCharLowerCase(classObject
				.getName());
		String nameUppercase = StringHelper.firstCharUppercase(classObject
				.getName());

		String result = StringHelper.tab + "public List<" + nameUppercase
				+ "> get" + nameUppercase + "() {\n";
		result += StringHelper.tab + StringHelper.tab + "return "
				+ nameLowercase + ";\n" + StringHelper.tab + "}\n";

		result += "\n";

		result += StringHelper.tab + "public void set" + nameUppercase
				+ "(List<";
		result += nameUppercase + "> " + nameLowercase;
		result += ") {\n";
		result += StringHelper.tab + StringHelper.tab + "this." + nameLowercase
				+ " = " + nameLowercase + ";\n" + StringHelper.tab + "}\n";
		result += "\n";
		return result;
	}

}
