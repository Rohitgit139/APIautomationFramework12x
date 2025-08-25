package com.testingacademy.tests.CRUD;

import com.testingacademy.base.BaseTest;
import com.testingacademy.endpoints.APIconstants;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class test_health_check extends BaseTest {
    @Test
    @Description("TC 3--VERIFY HEALTH")

    public void  testHealthCheck(){
        requestSpecification.basePath(APIconstants.PING_URL);

        response= RestAssured.given(requestSpecification).when().get();
        validatableResponse =response.then().log().all();
        validatableResponse.statusCode(201);

    }


}
