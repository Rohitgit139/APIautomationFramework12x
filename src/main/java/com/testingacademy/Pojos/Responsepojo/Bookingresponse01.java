package com.testingacademy.Pojos.Responsepojo;

import com.testingacademy.PayloadManagement.Class.Tools.requestpojos.Bookingss;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bookingresponse01 {


        private Integer bookingid;
        private Bookingss booking;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public Integer getBookingid() {
            return bookingid;
        }

        public void setBookingid(Integer bookingid) {
            this.bookingid = bookingid;
        }

        public Bookingss getBooking() {
            return booking;
        }

        public void setBooking(Bookingss booking) {
            this.booking = booking;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

