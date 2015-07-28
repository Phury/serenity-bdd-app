package be.phury.integration.bdd.stories.client;

import static com.jayway.restassured.RestAssured.given;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import be.phury.integration.bdd.stories.RestClient;
import be.phury.rest.client.ClientResp;

import com.jayway.restassured.http.ContentType;

public class ClientDetailsStory {
	
	private RestClient restClient = new RestClient();
	private String token;
	private ClientResp client;
	
	@Given("that I am an authenticated advisor with $advisorId")
	public void givenThatIAmAnAuthenticatedAdvisorWithadvisorId(String advisorId) {
		token = restClient.login(advisorId);
	}

	@When("I access uri $clientDetailsUri")
	public void whenIAccessUriclientDetailsUri(String clientDetailsUri) {
		client = given()
			.contentType(ContentType.JSON)
	    	.header("Authorization", "bearer "+token)
	    	.when()
	    	.get(restClient.getUrl(clientDetailsUri, "clientId", 1))
	    	.as(ClientResp.class);
	}

	@Then("I retrieve and client with $firstname and $lastname")
	public void thenIRetrieveAndClientWithfirstnameAndlastname(String firstname, String lastname) {
		Assert.assertEquals(firstname, client.getFirstname());
		Assert.assertEquals(lastname, client.getLastname());
	}

	@Then("I retrieve and $address")
	public void thenIRetrieveAndaddress(String address) {
		Assert.assertEquals(address, client.getAddressFull());
	}
}
