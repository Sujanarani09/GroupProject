package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.pojos.Postcode;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllProductsListTest {
    private static Response response;
    private static Postcode pojoResponse;

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "https://automationexercise.com/api/productsList";
        response = RestAssured
                .given()
                .header("Accept", "application/json")
                .when()
                .get("/productsList")
                .then()
                .extract()
                .response();
    //pojoResponse = response.as(Postcode.class);

    }

    @Test
    @DisplayName("API returns 200 OK")
    public void testStatusCode200() {
        MatcherAssert.assertThat(response.getStatusCode(), Matchers.is(404));
    }

    @Test
    @DisplayName("Server name in headers is cloudflare")
    public void testServerHeader() {
        MatcherAssert.assertThat(response.header("Server"), Matchers.containsString("cloudflare"));
    }


    @Test
    @DisplayName("The Connection name in the headers is keep alive")
    public void testConnectionNameInHeadersIsKeepAlive() {
        MatcherAssert.assertThat(response.header("Connection"), Matchers.is("keep-alive"));

    }

    @Test
    @DisplayName("The value name is Transfer Encoding")
    public void testTransferEncoding(){
        MatcherAssert.assertThat(response.header("Transfer-Encoding"), Matchers.is("chunked"));
    }

    @Test
    @DisplayName("The value name is referrer policy")
    public void testReferrerPolicy(){
        MatcherAssert.assertThat(response.header("referrer-policy"), Matchers.is("same-origin"));
    }


}
