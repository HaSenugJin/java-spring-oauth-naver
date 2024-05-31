package org.example.loginapp.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class KakaoResponse {

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
        private String scope; // 조심하자
        @JsonProperty("refresh_token_expires_in")
        private Integer refreshTokenExpiresIn;
    }

    @Data
    public static class KakaoUserDTO {
        private Long id;

        @JsonProperty("connected_at")
        private String connectedAt;
        private properties properties;

        @Data
        class properties {
            private String nickname;
        }
    }
}
