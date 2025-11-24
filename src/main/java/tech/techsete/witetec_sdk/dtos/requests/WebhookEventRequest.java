package tech.techsete.witetec_sdk.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import tech.techsete.witetec_sdk.deserializers.MetadataDeserializer;
import tech.techsete.witetec_sdk.enums.TransactionMethod;
import tech.techsete.witetec_sdk.enums.WebhookEventType;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookEventRequest implements Serializable {

    @JsonProperty("eventType")
    private WebhookEventType eventType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("items")
    private Collection<Item> items;

    @JsonProperty("method")
    private TransactionMethod method;

    @JsonProperty("status")
    private String status;

    @JsonProperty("pix")
    private Pix pix;

    @JsonProperty("boleto")
    private Boleto boleto;

    @JsonProperty("card")
    private Card card;

    @JsonProperty("description")
    private String description;

    @JsonProperty("installments")
    private Integer installments;

    @JsonProperty("metadata")
    @JsonDeserialize(using = MetadataDeserializer.class)
    private Metadata metadata;

    @JsonProperty("paidAt")
    private OffsetDateTime paidAt;

    @JsonProperty("toBank")
    private String toBank;

    @JsonProperty("toBankBranch")
    private String toBankBranch;

    @JsonProperty("toBankAccount")
    private String toBankAccount;

    @JsonProperty("ispb")
    private String ispb;

    @JsonProperty("toName")
    private String toName;

    @JsonProperty("toCNPJ")
    private String toCNPJ;

    @JsonProperty("postbackUrl")
    private String postbackUrl;

    @JsonProperty("end2endId")
    private String end2endId;

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

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Card implements Serializable {

        @JsonProperty("id")
        private String id;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Boleto implements Serializable {

        @JsonProperty("id")
        private String id;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metadata implements Serializable {

        @JsonProperty("id")
        private String id;

        @JsonProperty("externalRef")
        private String externalRef;
    }
}