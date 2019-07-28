import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojo_api_test.UserPojo;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class JecksonExampleAPITest {

    String userData = "{\n" +
            "  \"id\": 55058,\n" +
            "  \"first_name\": \"Bobby\",\n" +
            "  \"last_name\": \"Ward\",\n" +
            "  \"photo\": \"http://srcimg.com/100/150\",\n" +
            "  \"married\": true\n" +
            "}";

    @Test
    public void apiTest(){
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = RestAssured
                .when()
                .get("http://json-gen.com/rest/service/get/wBAmWzB9vyXt7uDmhBq")
                .andReturn();
        assertEquals(response.getStatusCode(), 200, "Response not found");
//        if (responce.getStatusCode()==200){
//            responce.prettyPrint();
//        }
        try {
            UserPojo user = objectMapper.readValue(userData, UserPojo.class);
            System.out.println(user.getFirst_name());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
