package ApiModels_Tests;

import ApiModels.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

import java.io.IOException;

public class API_Automation {

    @Test
    public void getRequest() {

        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
        System.out.println("Status code - " + response.getStatusCode());
        System.out.println(response.asString());
    }



    @Test
    public void postRequest() throws IOException {

        Post post = new Post();
        post.setUserId(11);
        post.setBody("New postBody");
        post.setTitle("New setBody");


        ObjectMapper objectMapper = new ObjectMapper();
        String postJson = objectMapper.writeValueAsString(post);
        System.out.println(postJson);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(postJson).when().post(Config.getProperty("urlApi") + "/posts");

        System.out.println("Status code - " + response.getStatusCode());
        System.out.println(response.asString());

    }



    @Test
    public void updateRequest() throws IOException {

        Post post = new Post();
        post.setUserId(11);
        post.setBody("New postBody");
        post.setTitle("New postTitle");
        post.setId(1);


        ObjectMapper objectMapper = new ObjectMapper();
        String postJson = objectMapper.writeValueAsString(post);
        System.out.println(postJson);

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(postJson).when().put(Config.getProperty("urlApi") + "/posts/1");

        System.out.println("Status code - " + response.getStatusCode());
        System.out.println(response.asString());

    }



    @Test
    public void deleteRequest(){

        Response response = RestAssured.delete(Config.getProperty("urlApi") + "/posts/1");
        System.out.println("Status code - " + response.getStatusCode());
        Assert.assertTrue("Wrong status",response.statusCode()==200);
    }

}