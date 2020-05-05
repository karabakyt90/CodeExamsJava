package ApiModels_Tests;

import ApiModels.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utilities.Config;
import java.io.IOException;


public class Performance_automation {

    @Before
    public void waitApi() throws InterruptedException {
        Thread.sleep(3000);
    }


    @Test
    public void getRequest() {
        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
        long millis=RestAssured.get(Config.getProperty("urlApi") + "/posts/1").time();

        System.out.println("Status code - " + response.getStatusCode());
        System.out.println("Running time for get request - "+ millis + " milliseconds");
        Assert.assertTrue(15000>millis);
    }


    @Test
    public void postRequest() throws IOException {
        String expectedTitle = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String expectedBody = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";

        int expectedId = 1;
        int expectedUserId = 1;

        Response response = RestAssured.get(Config.getProperty("urlApi") + "/posts/1");
        long millis = RestAssured.get(Config.getProperty("urlApi") + "/posts/1").time();

        Assert.assertTrue(response.statusCode() == 200);

        ObjectMapper mapper = new ObjectMapper();

        try {
            Post post = mapper.readValue(response.asString(), Post.class);

            String actualTitle = post.getTitle();
            String actualBody = post.getBody();
            int actualId = post.getId();
            int actualUserId = post.getUserId();

            Assert.assertTrue(actualBody.equals(expectedBody) && actualTitle.equals(expectedTitle) && actualId == expectedId && actualUserId == expectedUserId);
            System.out.println("Status code - " + response.statusCode());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Running time for Post request - " + millis + " milliseconds");
        Assert.assertTrue(15000 > millis);
    }



    @Test
    public void putRequest() throws IOException {
        Post post = new Post();
        post.setUserId(11);
        post.setBody("New postBody");
        post.setTitle("New postTitle");

        Response response = RestAssured.given().contentType(ContentType.JSON).
                body(post).when().put(Config.getProperty("urlApi") + "/posts/1");

        long millis = RestAssured.given().contentType(ContentType.JSON).body(post).when().put(Config.getProperty("urlApi") + "/posts/1").time();

        System.out.println("Status code - " + response.getStatusCode());

        System.out.println("Running time for put request - "+millis + " milliseconds");

        Assert.assertTrue(15000>millis);
    }



    @Test
    public void deleteRequest(){
        Response response = RestAssured.delete(Config.getProperty("urlApi") + "/posts/1");
        long millis = RestAssured.delete(Config.getProperty("urlApi") + "/posts/1").time();

        System.out.println("Status code - " + response.getStatusCode());
        Assert.assertTrue(response.statusCode() == 200);

        System.out.println("Running time for put request - "+ millis + " milliseconds");
        Assert.assertTrue(15000 > millis);
    }



}
