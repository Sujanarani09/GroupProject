package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostAllProductsTest {
    private static Response response;

    @BeforeAll
    public static void setUp() {
        response = RestAssured
                .given()
                .post("https://automationexercise.com/api/productsList")
                .thenReturn();
    }

    @Test
    @DisplayName("Test post products 405")
    public void responseCode405(){
        MatcherAssert.assertThat(response.getBody().asString(), Matchers.containsString("405"));
    }
}
