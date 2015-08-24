package com.boldijarpaul.jsontopojo.parser;

import java.util.ArrayList;
import java.util.List;

import com.boldijarpaul.jsontopojo.entities.ClassFile;
import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

public class ClassObjectConverter {

	/* converts a class object to a pojo string, line by line */
	public static String toPojo(ClassObject classObject) {
		String result = "public class " + classObject.getName() + "{\n";

		/* variables declaration */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += "private " + variable.getType().toString() + " "
					+ variable.getName() + ";\n";
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += "private " + obj.getName() + " "
					+ StringHelper.firstCharLowerCase(obj.getName()) + ";\n";
		}
		result += "\n";
		/* getters setters */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += variableGetterAndSetter(variable);
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += classObjectGetterAndSetter(obj);
		}

		result += "}";
		return result;
	}

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

	/*
	 * a class object can have nested class objects, this method will return
	 * them all, recursively
	 */
	public static List<ClassObject> getAllClassObjects(ClassObject classObject,
			List<ClassObject> classObjects) {
		classObjects.add(classObject);
		for (int i = 0; i < classObject.getObjects().size(); i++) {
			ClassObject newClassObject = classObject.getObjects().get(i);
			classObjects.addAll(getAllClassObjects(newClassObject));
		}
		return classObjects;
	}

	public static List<ClassObject> getAllClassObjects(ClassObject classObject) {
		return getAllClassObjects(classObject, new ArrayList<ClassObject>());
	}

	/* converts a class object to a list of strings, which are the whole classes */
	public static ClassFile[] classObjectToClassFileArray(
			ClassObject classObject) {
		List<ClassObject> classObjects = ClassObjectConverter
				.getAllClassObjects(classObject);
		ClassFile[] classes = new ClassFile[classObjects.size()];
		for (int i = 0; i < classes.length; i++) {
			classes[i] = new ClassFile();
			classes[i]
					.setText(ClassObjectConverter.toPojo(classObjects.get(i)));
			classes[i].setFilename(classObjects.get(i).getName() + ".java");
		}
		return classes;
	}
}
