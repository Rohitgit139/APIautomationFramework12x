package com.testingacademy.Modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.testingacademy.Pojos.Requestpojo.Bookingdates;
import com.testingacademy.Pojos.Requestpojo.Bookingss;
import com.testingacademy.Pojos.Responsepojo.Bookingresponse01;

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
}
