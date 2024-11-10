package interview.uber.kafka;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    private final List<String> messages;

    public Partition() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }

    public String readMessage(int offset) {
        if (offset >= messages.size()) {
            throw new KafkaException("offset is out of bounds for the partition");
        } else {
            return this.messages.get(offset);
        }
    }
}
