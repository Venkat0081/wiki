package apitest;
import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

/**
 * 
 * @author Venki
 *
 */
public class APITest extends BaseCommand {

	public APITest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void getPetDetails() {
		RestAssured.baseURI = baseURI;
		RestAssured.given().contentType("application/json").get("/v2/pet/" + petID).then().assertThat().statusCode(404);
		
	}

	@Test
	public void getAvailablePetsByStatus() {
		RestAssured.baseURI = baseURI;
		Response res = RestAssured.given().contentType("application/json")
				.get("/v2/pet/findByStatus?status=" + petsByStatus);
		ResponseBody body = res.getBody();
		JsonPath jsonPathEvaluator = body.jsonPath();
		ArrayList<String> nameOfPet = jsonPathEvaluator.get("name");
		Assert.assertTrue(nameOfPet.stream().anyMatch(x -> x.equals(petName)));

	}

	@Test
	public void findOrderById() {
		RestAssured.baseURI = baseURI;
		Response res = RestAssured.given().contentType("application/json").get("/v2/store/order/" + orderID);
		ResponseBody body = res.getBody();
		JsonPath jsonPathEvaluator = body.jsonPath();
		String orderStatus = jsonPathEvaluator.get("status");
		Assert.assertTrue(petsByStatus.equals(orderStatus));

	}

	@Test
	public void userLogin() {
		boolean loginSuccess= false;
		RestAssured.baseURI = baseURI;
		System.out.println("userID: " + userID);

		Response userDetails = RestAssured.given().contentType("application/json").get("/v2/user/" + userID);
		System.out.println("userDetails: " + userDetails);
		ResponseBody userDetail = userDetails.getBody();
		JsonPath jsonPathEvaluator = userDetail.jsonPath();
		String username = jsonPathEvaluator.get("username");
		String password = jsonPathEvaluator.get("password");
		if (username != null && password != null) {
			Response loggedinUser = RestAssured.given().contentType("application/json")
					.get("/v2/user/login?username=" + username + "&password=" + password);
			ResponseBody userDtl = loggedinUser.getBody();
			JsonPath userjsonpath = userDtl.jsonPath();
			int responseCode = userjsonpath.get("code");
			if (responseCode == 200) {
				loginSuccess= true;
			}
			
		}
		Assert.assertTrue(loginSuccess);


	}

	@Test
	public void getInventory() {
		RestAssured.baseURI = baseURI;
		Response res = RestAssured.given().contentType("application/json").get("/v2/store/inventory");
		ResponseBody body = res.getBody();
		JsonPath jsonPathEvaluator = body.jsonPath();
		Integer pendingInventory = jsonPathEvaluator.get("pending");
		Assert.assertTrue("20".equals(pendingInventory));


	}

}
