package com.testingacademy.Pojos.Responsepojo;

import java.util.LinkedHashMap;
import java.util.Map;



    public class Invalidresponse {

        private String reason;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

