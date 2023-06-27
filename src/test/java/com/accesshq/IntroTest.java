package com.accesshq;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class IntroTest {
    @Test
    public void greenwoodStatusCodeTest(){
        given()
                .header("auth-key","97e94c95-eb76-43be-abec-e865911aee27")
                .param("q","GREENWAY")
                .param("state","ACT")
                .log().all().
        when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json").
        then()
                .assertThat().statusCode(is(200)).log().all();
    }


    @Test
    public void greenwoodPostCodeTest(){
        given()
                .header("auth-key","97e94c95-eb76-43be-abec-e865911aee27")
                .param("q","GREENWAY")
                .param("state","ACT").
        when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json").
        then()
                .assertThat().body("localities.locality.postcode",equalTo("2900"));
    }
}
