package com.testingacademy.Modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.testingacademy.Pojos.Requestpojo.LoginRequest;
import com.testingacademy.Pojos.Requestpojo.auth;
import com.testingacademy.Pojos.Requestpojo.Bookingdates;
import com.testingacademy.Pojos.Requestpojo.Bookingss;
import com.testingacademy.Pojos.Responsepojo.Bookingresponse01;
import com.testingacademy.Pojos.Responsepojo.Invalidresponse;
import com.testingacademy.Pojos.Responsepojo.LoginResponse;
import com.testingacademy.Pojos.Responsepojo.Tokenresponse;

public class PayloadManager {

    private final Gson gson;
    private final Faker faker;

    // Constructor to initialize Gson and Faker once
    public PayloadManager() {
        this.gson = new Gson();
        this.faker = new Faker();
    }

    // Convert the Java Object into the JSON String to use as Payload.
    // Serialization
    public String createPayloadBookingAsString() {
        Bookingss booking = new Bookingss();
        booking.setFirstname("rohit");
        booking.setLastname("gaikwad");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        return gson.toJson(booking);
    }

    public String fullUpdatePayloadAsString() {
        Bookingss booking = new Bookingss();
        booking.setFirstname("rg");
        booking.setLastname("gaikwad");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        return gson.toJson(booking);
    }

    public String createPayloadBookingAsStringWrongBody() {
        Bookingss booking = new Bookingss();
        booking.setFirstname("会意; 會意");
        booking.setLastname("会意; 會意");
        booking.setTotalprice(112);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("5025-02-01");
        bookingdates.setCheckout("5025-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("会意; 會意");

        return gson.toJson(booking);
    }

    // Convert the JSON String to Java Object so that we can verify response Body
    // DeSerialization
    public Bookingresponse01 bookingResponseJava(String responseString) {
        return gson.fromJson(responseString, Bookingresponse01.class);
    }

    public Bookingss getResponseFromJSON(String responseString) {
        return gson.fromJson(responseString, Bookingss.class);
    }



    public String createPayloadBookingFakerJS() {
        Bookingss booking = new Bookingss();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1, 1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        return gson.toJson(booking);
    }
////serlization

    public String Set_Authpayload() {
        auth auth = new auth();
        auth.setUsername("admin");
        auth.setPassword("password123");


        String jsonPayloadString = gson.toJson(auth);
        System.out.println("pay load set to the -->" + jsonPayloadString);
        return jsonPayloadString;
    }

        //deserlization
        public String GettokenfromJSON(String tokenResponse){

            Tokenresponse tokenresponse1=gson.fromJson(tokenResponse, Tokenresponse.class);
                    return tokenresponse1.getToken();
        }
    //deserlization
    public String GetInvalidresponse(String Invalidresponse){


        Invalidresponse tokenresponse1=gson.fromJson(Invalidresponse, Invalidresponse.class);
        return tokenresponse1.getReason();
    }


    public String setLoginData(){


        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("contact+aug@thetestingacademy.com");
        loginRequest.setPassword("TtxkgQ!s$rJBk85");
        loginRequest.setRemember(false);
        loginRequest.setRecaptchaResponseField("");



        String jsonPayloadString = gson.toJson(loginRequest);
        System.out.println("Payload Login to the -> " + jsonPayloadString);
        return jsonPayloadString;

    }

    // DeSer ( JSON String -> Java Object
    public LoginResponse getLoginData(String loginResponseEx){

        LoginResponse loginResponse = gson.fromJson(loginResponseEx, LoginResponse.class);
        return  loginResponse;
    }
}



