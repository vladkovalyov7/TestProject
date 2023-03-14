package com.org.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTest {
    private String token;

    @BeforeTest
    public void authenticate() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"admin\", \"password\": \"password123\" }")
                .post("https://restful-booker.herokuapp.com/auth");

        token = response.jsonPath().getString("token");
    }

    @Test
    public void createBooking() {
        String requestBody = "{ \"firstname\": \"John\", \"lastname\": \"Doe\", \"totalprice\": 100, \"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2023-04-01\", \"checkout\": \"2023-04-10\" }, \"additionalneeds\": \"Breakfast\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .post("https://restful-booker.herokuapp.com/booking");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.jsonPath().getString("booking.firstname"), "John");
        softAssert.assertEquals(response.jsonPath().getString("booking.lastname"), "Doe");
        softAssert.assertEquals(response.jsonPath().getInt("booking.totalprice"), 100);
        softAssert.assertTrue(response.jsonPath().getBoolean("booking.depositpaid"));
        softAssert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkin"), "2023-04-01");
        softAssert.assertEquals(response.jsonPath().getString("booking.bookingdates.checkout"), "2023-04-10");
        softAssert.assertEquals(response.jsonPath().getString("booking.additionalneeds"), "Breakfast");
        softAssert.assertAll();
    }

    @Test
    public void getBooking() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get("https://restful-booker.herokuapp.com/booking/2");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertEquals(response.body().jsonPath().getString("firstname"), "Mark");
        softAssert.assertAll();
    }

    @Test
    public void updateBooking() {
        String requestBody = "{ \"firstname\": \"John\", \"lastname\": \"Doe\", \"totalprice\": 100, \"depositpaid\": true, \"bookingdates\": { \"checkin\": \"2023-04-01\", \"checkout\": \"2023-04-10\" }, \"additionalneeds\": \"Breakfast\" }";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(requestBody)
                .put("https://restful-booker.herokuapp.com/booking/4188");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getBookings() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .get("https://restful-booker.herokuapp.com/booking");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();
    }
    @Test
    public void deleteBookings() {

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .delete("https://restful-booker.herokuapp.com/booking/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}