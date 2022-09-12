package net.danskenet.interview;

public class PaymentMessageUtils {

    public static String prettyPrint(
        PaymentMessage message) {

        return message.json.toPrettyString();
    }

    public static boolean isPain001(PaymentMessage message) {
        return message.type == "pain.001";
    }

    public static boolean getIsPain002(PaymentMessage message) {
        return message.type == "pain.002";
    }
}
