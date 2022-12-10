package com.restful.restapi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest {
    String url = "https://demoqa.com/BookStore/v1/Books";
    @Test
    public void test01() {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");

        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void test02() {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("oncom");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 404, "Correct status code returned");
    }

    @Test
    public void test03() {
        RestAssured.baseURI = url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        String statusLine = response.getStatusLine();

        assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status code returned");
    }
}