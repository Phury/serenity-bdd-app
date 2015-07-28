package be.phury.integration.bdd.stories;

import static com.jayway.restassured.RestAssured.given;

import org.apache.commons.lang3.StringUtils;

import be.phury.rest.login.LoginReq;
import be.phury.rest.login.LoginResp;

import com.jayway.restassured.http.ContentType;

public class RestClient {
	
	private JsonParser jsonParser = new JsonParser();
	
	public String getApiUrl() {
		return "http://localhost:8080/advisor-dashboard/api/";
	}

	public String login(String advisorId) {
		
		String loginJson = jsonParser.toJson(new LoginReq() {{
    		setUesername("bfett");
    		setPassword("usetheforce");
    	}});
		
		return given()
	    	.contentType(ContentType.JSON)
	    	.body(loginJson)
	    	.when()
	    	.post(getUrl("/authentication/login"))
	    	.as(LoginResp.class)
	    	.getToken();
	}

	public String getUrl(String url, Object... params) {
		String urlReplaced = url;
		for (int i = 0; i < params.length; i+=2) {
			urlReplaced = StringUtils.replace(urlReplaced, "$"+params[i], params[i+1].toString());
		}
		return "http://localhost:8080/advisor-dashboard/api" + urlReplaced;
	}
	
}
