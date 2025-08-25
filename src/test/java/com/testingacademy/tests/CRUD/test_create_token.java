package com.testingacademy.tests.CRUD;

import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIconstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class test_create_token extends BaseTest {
    @Test(groups ="reg",priority = 1)
    @TmsLink("https://bugz.atlassian.net")
    @Owner("Rohit gaikwad")
    @Description("TC-1 CREATE A TOKEN AND VERIFY")
    public void testTokenPost(){
        requestSpecification.basePath(APIconstants.AUTH_URL);
        response= RestAssured.given(requestSpecification)
                .when()
                    .body(payloadManager.Set_Authpayload()).post();



        /// extraction json to java object
        String token= payloadManager.GettokenfromJSON(response.asString());
        System.out.println(token);

        //validatation of request

        assertActions.verifyStringKeyNotNull(token);
    }

    @Test(groups ="reg",priority = 1)
    @TmsLink("https://bugz.atlassian.net")
    @Owner("Rohit gaikwad")
    @Description("TC-2 create a invalid token")

    public void testTokenPostNegative(){
        requestSpecification.basePath(APIconstants.AUTH_URL);
        response= RestAssured.given(requestSpecification)
                .when()
                .body("{}").post();



        /// extraction json to java object
        String invalid_reason= payloadManager.GetInvalidresponse(response.asString());
        System.out.println(invalid_reason);

        //validatation of request

        assertActions.verifyStringKey(invalid_reason , "Bad credentials");
    }
}
