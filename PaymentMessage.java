package net.danskenet.oipc.caseregistration.interview;

import com.fasterxml.jackson.databind.node.ObjectNode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class PaymentMessage {
    final String type;
    ObjectNode json;

    public PaymentMessage(String type) {
        this.type = type;
    }

    public String paymentId() throws Exception {
        if (PaymentMessageUtils.isPain001(this)) {
            return json.path("/groupHeader/messageIdentification").textValue();
        } else if (PaymentMessageUtils.getIsPain002(this)) {
            return json.path("/originalGroupInformationAndStatus/originalMessageIdentification").textValue();
        } else {
            throw new Exception("Unsupported message type.");
        }
    }

public LocalDateTime fetchTimestamp() throws Exception {
    if (PaymentMessageUtils.isPain001(this)) {
        return LocalDateTime.parse(json.path("/groupHeader/CreationDateTime").textValue());
    }
    if (PaymentMessageUtils.getIsPain002(this)) {
        return LocalDateTime.parse(
            json.path("/originalGroupInformationAndStatus/originalCreationDateTime").textValue()
        );
    }
    throw new Exception("Unsupported message type.");
}

    public void setContent(ObjectNode json) {
        this.json = json;
    }

    public List<PaymentMessage> allPain001sSince(LocalDate date) {
        throw new UnsupportedOperationException("Will implement later");
    }
}
