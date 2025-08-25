package com.testingacademy.Pojos.Requestpojo;

import java.util.LinkedHashMap;
import java.util.Map;



    public class auth {

        private String username;
        private String password;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

