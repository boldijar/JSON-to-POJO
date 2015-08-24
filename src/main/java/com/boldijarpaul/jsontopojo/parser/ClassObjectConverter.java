package com.boldijarpaul.jsontopojo.parser;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

 

public class ClassObjectConverter {

	public static String toPojo(ClassObject classObject) {
		String result = "public class " + classObject.getName() + "{\n";

		/* variables */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += "private " + variable.getType().toString() + " "
					+ variable.getName() + ";\n";
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += "private " + obj.getName() + " "
					+ StringHelper.firstCharLowerCase(obj.getName()) + ";\n";
		}
		result += "\n";
		/* get set */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += variableGetterAndSetter(variable);
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += classObjectGetterAndSetter(obj);
		}
		result += "}";
		return result;
	}

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
}
