package step_definitions.SauceDemo_stepdefs_API;

import ApiModels.Post;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.Config;

import java.io.IOException;

public class API_stepdefs {
    @Given("User makes GET call")
    public void user_makes_GET_call() {
        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
        System.out.println("Status code - " + response.getStatusCode());
        System.out.println(response.asString());
    }

    @When("User makes POST call")
    public void user_makes_POST_call() throws JsonProcessingException {
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

    @Then("User makes PUT call")
    public void user_makes_PUT_call() throws JsonProcessingException {
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

    @Then("User makes DELETE call")
    public void user_makes_DELETE_call() {
        Response response = RestAssured.delete(Config.getProperty("urlApi") + "/posts/1");
        System.out.println("Status code - " + response.getStatusCode());
        Assert.assertTrue("Wrong status", response.statusCode() == 200);
    }

}