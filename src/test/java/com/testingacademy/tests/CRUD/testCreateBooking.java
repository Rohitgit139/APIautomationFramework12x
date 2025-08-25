package com.testingacademy.tests.CRUD;

import com.testingacademy.Pojos.Responsepojo.Bookingresponse01;
import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIconstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class testCreateBooking extends BaseTest {



    @Test(groups = "reg", priority = 1)
    @Owner("Rohit gaikwad")
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingPOST_Positive() {

        // Setup will first and making the request - Part - 1
        requestSpecification.basePath(APIconstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).log().all()
                .post();

        //Extraction Part - 2
        Bookingresponse01 bookingResponse = payloadManager.bookingResponseJava(response.asString());

        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response,200);

        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"rohit");

    }


    @Test(groups = "reg", priority = 1)
    @Owner("Rohit Gaikwad")
    @Description("TC#1 - Verify that the Booking can't be Created, When Payload is null")
    public void testCreateBookingPOST_Negative() {

        requestSpecification.basePath(APIconstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().
                body("{}").log().all().post();

        validatableResponse  = response.then().log().all();
        validatableResponse.statusCode(500);




    }
    @Test(groups = "reg", priority = 1)
    @Owner("Rohit Gaikwad")
    @Description("TC#1 - Verify that the Booking can be Created, When Payload is CHINESE")
    public void testCreateBookingPOST_POSITIVE_CHINESE() {


        requestSpecification.basePath(APIconstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().
                body(payloadManager.createPayloadBookingAsStringWrongBody()).log().all().post();

        validatableResponse  = response.then().log().all();
        validatableResponse.statusCode(200);

        //Extraction Part - 2
        Bookingresponse01 bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());

    }
    @Test(groups = "reg", priority = 1)
    @Owner("Rohit Gaikwad")
    @Description("TC#1 - Verify that the Booking can be Created, When Payload is Random")
    public void testcreatebookingwithfaker() {


        requestSpecification.basePath(APIconstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().
                body(payloadManager.createPayloadBookingFakerJS()).log().all().post();

        validatableResponse  = response.then().log().all();
        validatableResponse.statusCode(200);
        Bookingresponse01 bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotNull(bookingResponse.getBooking().getFirstname());




    }}

