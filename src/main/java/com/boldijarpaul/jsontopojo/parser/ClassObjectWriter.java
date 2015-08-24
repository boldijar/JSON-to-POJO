package com.boldijarpaul.jsontopojo.parser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import com.boldijarpaul.jsontopojo.entities.ClassObject;

public class ClassObjectWriter {

	/* will write the class file */
	public static void writeClassObject(ClassObject classObject)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(classObject.getName() + ".java",
				"UTF-8");
		writer.print(ClassObjectConverter.toPojo(classObject));
		writer.close();
	}
}
