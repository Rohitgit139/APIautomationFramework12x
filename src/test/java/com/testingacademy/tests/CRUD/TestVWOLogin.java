package com.testingacademy.tests.CRUD;

import com.testingacademy.Pojos.Responsepojo.Bookingresponse01;
import com.testingacademy.Pojos.Responsepojo.LoginResponse;
import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIconstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestVWOLogin extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Rohit gaikwad")
    @Description("TC#1 - Verify that the Booking can be Created")
    public void testCreateBookingPOST_Positive() {

        // Setup will first and making the request - Part - 1
        requestSpecification.baseUri(APIconstants.APP_VWO_URL);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setLoginData()).log().all()
                .post();

        //Extraction Part - 2
        LoginResponse bookingResponse = payloadManager.getLoginData(response.asString());

        // Validation and verification via the AssertJ, TestNG Part - 3
        assertActions.verifyStatusCode(response,200);

        System.out.println(bookingResponse.getAccountId());
        assertActions.verifyStringKeyNotNull(bookingResponse.getAccountId());
        assertActions.verifyStringKey(bookingResponse.getName(),"Aman");

    }
}
