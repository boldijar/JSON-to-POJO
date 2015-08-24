package com.boldijarpaul.jsontopojo.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.boldijarpaul.jsontopojo.entities.ClassObject;

public class Launcher {

	public static void main(String[] args) {

		try {
			String json = readFile("test.json");
			ClassObject root = ParseJson.parse(json, "RootName");

			// System.out.println(ClassObjectConverter.toPojo(root));

			System.out.println(ClassObjectConverter.getAllClassObjects(root,
					new ArrayList<ClassObject>()).size());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static String readFile(String filename) {
		String content = null;
		File file = new File(filename); // for ex foo.txt
		FileReader reader = null;
		try {
			reader = new FileReader(file);
			char[] chars = new char[(int) file.length()];
			reader.read(chars);
			content = new String(chars);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return content;
	}

}
