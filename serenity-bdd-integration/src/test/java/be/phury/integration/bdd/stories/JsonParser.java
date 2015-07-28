package be.phury.integration.bdd.stories;

import com.google.gson.Gson;

public class JsonParser {

	private Gson gson;
	
	public JsonParser() {
		gson = new Gson();
	}
	
	
	public String toJson(Object obj) {
		return gson.toJson(obj);
	}
}
