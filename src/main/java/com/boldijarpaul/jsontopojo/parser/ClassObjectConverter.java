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
		String result = "import java.util.List;\n\n";
		result += "public class " + classObject.getName() + "{\n";

		/* variables declaration */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += "private " + variable.getType().toString() + " "
					+ variable.getName() + ";\n";
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += "private " + obj.getName() + " "
					+ StringHelper.firstCharLowerCase(obj.getName()) + ";\n";
		}
		/* Lists declaration */
		for (Variable variable : classObject.getPrimiveVariablesArray()) {
			result += "private List<" + variable.getType().toString() + "> "
					+ variable.getName() + ";\n";
		}
		for (ClassObject obj : classObject.getObjectsArray()) {
			result += "private List<" + obj.getName() + "> "
					+ StringHelper.firstCharLowerCase(obj.getName()) + ";\n";
		}

		result += "\n";

		/* getters setters */
		for (Variable variable : classObject.getPrimiveVariables()) {
			result += GettersSettersGenerator.variableGetterAndSetter(variable);
		}
		for (ClassObject obj : classObject.getObjects()) {
			result += GettersSettersGenerator.classObjectGetterAndSetter(obj);
		}
		/* getters setters for lists */
		for (Variable variable : classObject.getPrimiveVariablesArray()) {
			result += GettersSettersGenerator
					.variableArrayGetterAndSetter(variable);
		}
		for (ClassObject obj : classObject.getObjectsArray()) {
			result += GettersSettersGenerator
					.classObjectArrayGetterAndSetter(obj);
		}
		result += "}";
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
		for (int i = 0; i < classObject.getObjectsArray().size(); i++) {
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
