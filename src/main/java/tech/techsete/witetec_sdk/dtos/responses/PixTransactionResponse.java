package tech.techsete.witetec_sdk.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;
import tech.techsete.witetec_sdk.enums.TransactionStatus;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PixTransactionResponse implements Serializable {

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

        @JsonProperty("feeAmount")
        private Integer feeAmount;

        @JsonProperty("netAmount")
        private Integer netAmount;

        @JsonProperty("sellerId")
        private String sellerId;

        @JsonProperty("sellerName")
        private String sellerName;

        @JsonProperty("customer")
        private Customer customer;

        @JsonProperty("items")
        private Collection<Item> items;

        @JsonProperty("method")
        private String method;

        @JsonProperty("status")
        private TransactionStatus status;

        @JsonProperty("pix")
        private Pix pix;

        @JsonProperty("description")
        private String description;

        @JsonProperty("installments")
        private Integer installments;

        @JsonProperty("metadata")
        private JsonNode metadata;

        @JsonProperty("paidAt")
        private OffsetDateTime paidAt;

        @JsonProperty("end2endId")
        private String end2endId;

        @JsonProperty("postbackUrl")
        private String postbackUrl;

        @JsonProperty("createdAt")
        private OffsetDateTime createdAt;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Customer implements Serializable {

            @JsonProperty("id")
            private String id;

            @JsonProperty("externalRef")
            private String externalRef;

            @JsonProperty("name")
            private String name;

            @JsonProperty("email")
            private String email;

            @JsonProperty("phone")
            private String phone;

            @JsonProperty("documentType")
            private String documentType;

            @JsonProperty("document")
            private String document;

            @JsonProperty("createdAt")
            private OffsetDateTime createdAt;
        }

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Item implements Serializable {

            @JsonProperty("id")
            private String id;

            @JsonProperty("title")
            private String title;

            @JsonProperty("amount")
            private Integer amount;

            @JsonProperty("quantity")
            private Integer quantity;

            @JsonProperty("tangible")
            private Boolean tangible;

            @JsonProperty("externalRef")
            private String externalRef;

            @JsonProperty("transactionId")
            private String transactionId;

            @JsonProperty("createdAt")
            private OffsetDateTime createdAt;

            @JsonProperty("updatedAt")
            private OffsetDateTime updatedAt;
        }

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Pix implements Serializable {

            @JsonProperty("id")
            private String id;

            @JsonProperty("qrcode")
            private String qrCode;

            @JsonProperty("qrcodeUrl")
            private String qrCodeUrl;

            @JsonProperty("expirationDate")
            private OffsetDateTime expirationDate;

            @JsonProperty("copyPaste")
            private String copyPaste;

            @JsonProperty("createdAt")
            private OffsetDateTime createdAt;

            @JsonProperty("updatedAt")
            private OffsetDateTime updatedAt;

            @JsonProperty("transactionId")
            private String transactionId;
        }
    }
}
