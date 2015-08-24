package com.boldijarpaul.jsontopojo.parser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.boldijarpaul.jsontopojo.entities.ClassObject;

public class ClassObjectWriter {

	/* will write the class file */
	public static void writeClassObject(ClassObject classObject, String folder)
			throws FileNotFoundException, UnsupportedEncodingException {
		String path = folder + "/" + classObject.getName() + ".java";
		if (folder.length() == 0) {
			path = classObject.getName() + ".java";
		}
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		writer.print(ClassObjectConverter.toPojo(classObject));
		writer.close();
	}
}
