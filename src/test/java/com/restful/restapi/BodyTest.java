package com.restful.restapi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BodyTest {
    @Test
    public void weatherMessageBody() {
        // Baca body Respons JSON menggunakan Rest Assured
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        ResponseBody body = response.getBody();
        System.out.println("Response Body is: " + body.asString());
        System.out.println(body.asString().toLowerCase().contains("hyderabad"));
    }

    @Test
    public void VerifyCityInJsonResponse() {
        /**
         * Bagaimana cara Mengekstrak teks Node dari Respons menggunakan JsonPath?
         */
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String city = jsonPathEvaluator.get("City");

        // Let us print the city variable to see what we got
        System.out.println("City received from Response " + jsonPathEvaluator.get("WindSpeed"));

        // Validate the response
        assertEquals(city, "Hyderabad", "Correct city name received in the Response");
    }
}