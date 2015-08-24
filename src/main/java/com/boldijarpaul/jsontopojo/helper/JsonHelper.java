package com.boldijarpaul.jsontopojo.helper;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {
	public static boolean jsonValid(String json) {

		try {
			new JSONObject(json);
			return true;
		} catch (JSONException e) {
			return false;
		}

	}
}
