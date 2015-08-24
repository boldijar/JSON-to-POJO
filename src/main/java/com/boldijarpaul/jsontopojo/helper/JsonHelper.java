package com.boldijarpaul.jsontopojo.helper;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonObject;

public class JsonHelper {
	public static boolean jsonValid(String json) {

		try {
			JSONObject jsonObject = new JSONObject(json);
			return true;
		} catch (JSONException e) {
			return false;
		}

	}
}
