package tech.techsete.witetec_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tech.techsete.witetec_sdk.enums.PixKeyType;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawRequest implements Serializable {

    @NotNull(message = "Amount cannot be null.")
    @JsonProperty("amount")
    private Integer amount;

    @NotEmpty(message = "PixKey cannot be empty.")
    @JsonProperty("pixKey")
    private String pixKey;

    @NotEmpty(message = "PixKeyType cannot be empty.")
    @JsonProperty("pixKeyType")
    private PixKeyType pixKeyType;

    @NotEmpty(message = "Method cannot be empty.")
    @JsonProperty("method")
    private String method;

    @JsonProperty("metadata")
    private JsonNode metadata;
}