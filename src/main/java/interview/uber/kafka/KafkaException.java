package interview.uber.kafka;

public class KafkaException extends RuntimeException {
    public KafkaException(String message) {
        super(message);
    }
}
