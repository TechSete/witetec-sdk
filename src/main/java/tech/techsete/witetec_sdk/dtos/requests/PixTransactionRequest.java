package tech.techsete.witetec_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import tech.techsete.witetec_sdk.enums.TransactionMethod;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PixTransactionRequest implements Serializable {

    @NotNull(message = "Amount cannot be null.")
    @JsonProperty("amount")
    private Integer amount;

    @NotNull(message = "Method cannot be null.")
    @JsonProperty("method")
    private TransactionMethod method;

    @Valid
    @JsonProperty("metadata")
    private MetaData metaData;

    @Valid
    @NotNull(message = "Customer cannot be null.")
    @JsonProperty("customer")
    private Customer customer;

    @Valid
    @NotNull(message = "Items cannot be null.")
    @JsonProperty("items")
    private Collection<Item> items;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MetaData implements Serializable {

        @NotEmpty(message = "SellerExternalRef cannot be empty.")
        @JsonProperty("sellerExternalRef")
        private String sellerExternalRef;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Customer implements Serializable {

        @NotNull(message = "Name cannot be empty.")
        @JsonProperty("name")
        private String name;

        @NotEmpty(message = "Email cannot be empty.")
        @JsonProperty("email")
        private String email;

        @NotEmpty(message = "Phone cannot be empty.")
        @JsonProperty("phone")
        private String phone;

        @NotEmpty(message = "DocumentType cannot be empty.")
        @JsonProperty("documentType")
        private String documentType;

        @NotEmpty(message = "Document cannot be empty.")
        @JsonProperty("document")
        private String document;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item implements Serializable {

        @NotEmpty(message = "Title cannot be empty.")
        @JsonProperty("title")
        private String title;

        @NotNull(message = "Amount cannot be null.")
        @JsonProperty("amount")
        private Integer amount;

        @NotNull(message = "Quantity cannot be null.")
        @JsonProperty("quantity")
        private Integer quantity;

        @JsonProperty("tangible")
        private Boolean tangible;

        @JsonProperty("externalRef")
        private String externalRef;
    }
}
