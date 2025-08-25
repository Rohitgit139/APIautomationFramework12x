package com.testingacademy.base;



import com.testingacademy.Modules.PayloadManager;
import com.testingacademy.asserts.assertactions;
import com.testingacademy.endpoints.APIconstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // CommonToAll Testcase
    //   // Base URL, Content Type - json - common

    public RequestSpecification requestSpecification;
    public assertactions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;
//
//    @BeforeMethod
//    public void waitCustom(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }



    @BeforeTest
    public void setup() {
        // We need to setup the base URL. We need to setup the header.
        System.out.println("Starting of the Test");
        payloadManager = new PayloadManager();
        assertActions = new assertactions();

//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BASE_URL);
//        requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification =  new RequestSpecBuilder()
                .setBaseUri(APIconstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

    }

    @AfterTest
    public void tearDown() {
        System.out.println("Finished the Test!");
    }

        public String getToken () {
            requestSpecification = RestAssured.given();
            requestSpecification.baseUri(APIconstants.BASE_URL)
                    .basePath(APIconstants.AUTH_URL);
            // Setting the payload
            String payload = payloadManager.Set_Authpayload();
            // Get the Token
            response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
            String token = payloadManager.GettokenfromJSON(response.asString());
            return token;

        }


    }





