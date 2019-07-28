import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class APITest {

    String URL = "https://dev.intelinair.com";
    String token;

    public void getAuthentication (){
        RestAssured.baseURI = URL;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("150319@mailinator.com");
        authScheme.setPassword("Aa123456!");
        RestAssured.authentication = authScheme;
        System.out.println(RestAssured.authentication.toString());
    }

    @Test
    public void apiTest(){
        Response responce = RestAssured
                .when()
                .get("https://jsonplaceholder.typicode.com/posts")
                .andReturn();
        assertEquals(responce.getStatusCode(), 200, "Response not found");
        if (responce.getStatusCode()==200){
            responce.prettyPrint();
        }
    }

    @Test
    public void agMRILoginTest(){
        RestAssured.baseURI = URL;
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "150319@mailinator.com");
        requestParams.put("password", "Aa123456!");
        request.body(requestParams.toString());
        Response resp = request.post("/admin/api/login");

        int statusCodePost = resp.getStatusCode();
        Assert.assertEquals(statusCodePost, 200);
        System.out.println(statusCodePost);
//        resp.prettyPrint();
        token = resp.jsonPath().getString("access_token");      //take access_token from response body
        System.out.println(token);
    }

    @Test (dependsOnMethods = "agMRILoginTest")
    public void getCompanysHierarchy(){
//        getAuthentication();
        Response response = RestAssured.get(URL + "/admin/api/v2/reports/companiesHierarchy?enabled=true&isMonitored=false&subscriptionMode=false");
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");
        request.header("X-Auth-Token", token);
        request.body(request.toString());
        Assert.assertEquals(response.getStatusCode(), 200);
        response.prettyPrint();
    }
}
