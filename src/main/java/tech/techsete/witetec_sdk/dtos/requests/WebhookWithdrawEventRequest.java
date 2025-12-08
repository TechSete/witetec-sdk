package tech.techsete.witetec_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tech.techsete.witetec_sdk.enums.PixKeyType;
import tech.techsete.witetec_sdk.enums.WebhookEventType;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookWithdrawEventRequest implements Serializable {

    @JsonProperty("eventType")
    private WebhookEventType eventType;

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
}
