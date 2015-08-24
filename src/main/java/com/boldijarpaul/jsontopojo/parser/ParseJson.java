package com.boldijarpaul.jsontopojo.parser;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.boldijarpaul.jsontopojo.entities.ClassObject;
import com.boldijarpaul.jsontopojo.entities.ObjectType;
import com.boldijarpaul.jsontopojo.entities.Variable;
import com.boldijarpaul.jsontopojo.helper.StringHelper;

public class ParseJson {

	public static ClassObject parse(String json, String rootName)
			throws JSONException {

		JSONObject object = new JSONObject(json);

		ClassObject rootObject = new ClassObject();
		rootObject.setName(rootName);

		Iterator<?> keys = object.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			ObjectType type = getKeyType(object, key);
			if (type != ObjectType.JSONArray && type != ObjectType.JSONObject) {
				Variable variable = new Variable();
				variable.setName(key);
				variable.setType(type);
				rootObject.getPrimiveVariables().add(variable);
			}
			if (type == ObjectType.JSONObject) {
				JSONObject jsonObject = object.getJSONObject(key);
				ClassObject classObject = parse(jsonObject.toString(),
						StringHelper.firstCharUppercase(key));
				classObject.setJson(jsonObject.toString());
				rootObject.getObjects().add(classObject);
			}

		}

		return rootObject;
	}

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
