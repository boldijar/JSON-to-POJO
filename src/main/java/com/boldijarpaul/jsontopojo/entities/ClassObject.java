package com.boldijarpaul.jsontopojo.entities;

import java.util.ArrayList;
import java.util.List;

public class ClassObject {

	/* a class object has a name, and own json, which is the json object representation of it */
	private String name;
	private String json;

	
	private List<Variable> primiveVariables = new ArrayList<Variable>();
	private List<ClassObject> objects = new ArrayList<ClassObject>();
	
	/* there are also arrays, so here we are going to put the array of variables and array or class object */
	
	private List<Variable> primiveVariablesArray = new ArrayList<Variable>();
	private List<ClassObject> objectsArray = new ArrayList<ClassObject>();
	
	public List<Variable> getPrimiveVariables() {
		return primiveVariables;
	}

	public void setPrimiveVariables(List<Variable> primiveVariables) {
		this.primiveVariables = primiveVariables;
	}

	public List<ClassObject> getObjects() {
		return objects;
	}

	public void setObjects(List<ClassObject> objects) {
		this.objects = objects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Variable> getPrimiveVariablesArray() {
		return primiveVariablesArray;
	}

	public void setPrimiveVariablesArray(List<Variable> primiveVariablesArray) {
		this.primiveVariablesArray = primiveVariablesArray;
	}

	public List<ClassObject> getObjectsArray() {
		return objectsArray;
	}

	public void setObjectsArray(List<ClassObject> objectsArray) {
		this.objectsArray = objectsArray;
	}
	

}
