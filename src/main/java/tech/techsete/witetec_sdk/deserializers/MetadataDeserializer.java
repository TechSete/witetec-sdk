package tech.techsete.witetec_sdk.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import tech.techsete.witetec_sdk.dtos.requests.WebhookTransactionEventRequest;

import java.io.IOException;

public class MetadataDeserializer extends JsonDeserializer<WebhookTransactionEventRequest.Metadata> {

    @Override
    public WebhookTransactionEventRequest.Metadata deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        JsonNode node = p.getCodec().readTree(p);

        if (node.isTextual() && node.asText().equalsIgnoreCase("null")) {
            return null;
        }

        return p.getCodec().treeToValue(node, WebhookTransactionEventRequest.Metadata.class);
    }
}
