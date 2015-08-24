package com.boldijarpaul.jsontopojo.parser;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.ObjectType;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

public class ParseJson {

	/* this method will parse a json file */
	public static ClassObject parse(String json, String rootName)
			throws JSONException {

		/* initialize the json object */
		JSONObject object = new JSONObject(json);

		/* set its name & json fields */
		ClassObject rootObject = new ClassObject();
		rootObject.setJson(json);
		rootObject.setName(rootName);

		/* iterate through all its objects */
		Iterator<?> keys = object.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			ObjectType type = getKeyType(object, key);

			/* we found a primitive variable, add to the root */
			if (type != ObjectType.JSONArray && type != ObjectType.JSONObject) {
				Variable variable = new Variable();
				variable.setName(key);
				variable.setType(type);
				rootObject.getPrimiveVariables().add(variable);
			}
			/* we found a json object, parse it, and add to root */
			if (type == ObjectType.JSONObject) {
				JSONObject jsonObject = object.getJSONObject(key);
				ClassObject classObject = parse(jsonObject.toString(),
						StringHelper.firstCharUppercase(key));
				classObject.setJson(jsonObject.toString());
				rootObject.getObjects().add(classObject);
			}

			/* we found a json array, parse it, and add to root */
			if (type == ObjectType.JSONArray) {
				JSONArray jsonArray = object.getJSONArray(key);
				if (jsonArray.length() == 0)
					continue; /* array empty */

				/* if we got here, our array is not empty, so get the first item */
				ObjectType arrayType = getJsonArrayType(jsonArray);

				if (arrayType != ObjectType.JSONArray
						&& type != ObjectType.JSONObject) {
					/* array of primitive variable */
					Variable variable = new Variable();
					variable.setName(key);
					variable.setType(arrayType);
					rootObject.getPrimiveVariablesArray().add(variable);
				}
				if (arrayType == ObjectType.JSONObject) {
					JSONObject jsonObject = object.getJSONObject(key);
					ClassObject classObject = parse(jsonObject.toString(),
							StringHelper.firstCharUppercase(key));
					classObject.setJson(jsonObject.toString());
					rootObject.getObjects().add(classObject);
				}

			}

		}

		return rootObject;
	}

	public static ObjectType getJsonArrayType(JSONArray jsonArray) {
		try {
			jsonArray.getLong(0);
			return ObjectType.Long;
		} catch (Exception e) {
		}

		try {
			jsonArray.getDouble(0);
			return ObjectType.Double;
		} catch (Exception e) {
		}

		try {
			jsonArray.getBoolean(0);
			return ObjectType.Boolean;
		} catch (Exception e) {
		}

		try {
			jsonArray.getJSONObject(0);
			return ObjectType.JSONObject;
		} catch (Exception e) {
		}

		try {
			jsonArray.getJSONArray(0);
			return ObjectType.JSONArray;
		} catch (Exception e) {
		}
		try {
			jsonArray.getString(0);
			return ObjectType.String;
		} catch (Exception e) {
		}

		return null;
	}

	/* returns the field type of the json object with the wanted key */
	public static ObjectType getKeyType(JSONObject jsonObject, String key) {

		try {
			jsonObject.getLong(key);
			return ObjectType.Long;
		} catch (JSONException e) {
		}

		try {
			jsonObject.getDouble(key);
			return ObjectType.Double;
		} catch (JSONException e) {
		}

		try {
			jsonObject.getBoolean(key);
			return ObjectType.Boolean;
		} catch (JSONException e) {
		}

		try {
			jsonObject.getString(key);
			return ObjectType.String;
		} catch (JSONException e) {
		}

		try {
			jsonObject.getJSONObject(key);
			return ObjectType.JSONObject;
		} catch (JSONException e) {
		}

		try {
			jsonObject.getJSONArray(key);
			return ObjectType.JSONArray;
		} catch (JSONException e) {
		}

		return null;
	}
}
