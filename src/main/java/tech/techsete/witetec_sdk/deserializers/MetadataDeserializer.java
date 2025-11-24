package tech.techsete.witetec_sdk.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import tech.techsete.witetec_sdk.dtos.requests.WebhookEventRequest;

import java.io.IOException;

public class MetadataDeserializer extends JsonDeserializer<WebhookEventRequest.Metadata> {

    @Override
    public WebhookEventRequest.Metadata deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        JsonNode node = p.getCodec().readTree(p);

        if (node.isTextual() && node.asText().equalsIgnoreCase("null")) {
            return null;
        }

        return p.getCodec().treeToValue(node, WebhookEventRequest.Metadata.class);
    }
}
