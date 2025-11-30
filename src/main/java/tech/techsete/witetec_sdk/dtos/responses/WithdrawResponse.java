package tech.techsete.witetec_sdk.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import tech.techsete.witetec_sdk.enums.PixKeyType;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawResponse implements Serializable {

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("data")
    private Data data;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {

        @JsonProperty("id")
        private String id;

        @JsonProperty("amount")
        private Integer amount;

        @JsonProperty("method")
        private String method;

        @JsonProperty("pixKey")
        private String pixKey;

        @JsonProperty("pixKeyType")
        private PixKeyType pixKeyType;

        @JsonProperty("status")
        private String status;

        @JsonProperty("withdrawalType")
        private String withdrawalType;

        @JsonProperty("approvedAt")
        private OffsetDateTime approvedAt;

        @JsonProperty("processedAt")
        private OffsetDateTime processedAt;

        @JsonProperty("createdAt")
        private OffsetDateTime createdAt;

        @JsonProperty("externalRef")
        private String externalRef;

        @JsonProperty("metadata")
        private JsonNode metadata;
    }
}