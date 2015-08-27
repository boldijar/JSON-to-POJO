package com.boldijarpaul.jsontopojo.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {
	/* returns true if json is json object or json array */
	public static boolean jsonValid(String json) {

		try {
			new JSONObject(json);
			return true;
		} catch (JSONException e) {

			try {
				new JSONArray(json);
				return true;
			} catch (JSONException e2) {
				return false;
			}

		}

	}
}
