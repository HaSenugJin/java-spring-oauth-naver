package org.example.loginapp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

public class NaverResponse {

    @Data // getter, setter
    public static class TokenDTO {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("token_type")
        private String tokenType;
        @JsonProperty("refresh_token")
        private String refreshToken;
        @JsonProperty("expires_in")
        private Integer expiresIn;

        private String error;

        @JsonProperty("error_description")
        private String errorDescription;
    }

    @Data
    public static class NaverUserDTO {
        @JsonProperty("response")
        private response response;

        @Data
        public static class response {
            private String id;
            private String email;
            private String mobile;
            private String name;
            @JsonProperty("birthyear")
            private String birthYear;
        }
    }
}
