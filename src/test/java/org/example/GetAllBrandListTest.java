package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class GetAllBrandListTest {

    private static Response response;

    @BeforeAll
    public static void setup() {
        response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/api/brandList")
                .header("Accept", "text/json")
                .when()
                .log().all()
                .get("https://automationexercise.com/api/brandsList")
                .thenReturn();
    }

    @Test
    @DisplayName("Status code 200 returned short")
    public void textStatusCode200_Shortversion() {
        RestAssured
                .get("https://automationexercise.com/api/brandsList")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    @DisplayName("Display the brandlist")
    public void BrandList() {
        RestAssured
                .given()
                .get("https://automationexercise.com/api/brandsList")
                .then();
        List<Map<String, Object>> brands = response.jsonPath().getList("brands");
        MatcherAssert.assertThat(brands, Matchers.not(Matchers.empty()));
    }
}
