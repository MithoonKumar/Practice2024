package interview.uber.kafka;

public class Producer {
    private String topicName;
    private Broker broker;

    public Producer(String topicName, Broker broker) {
        this.topicName = topicName;
        this.broker = broker;
    }

    public void addMessage(String message) {
        this.broker.addMessage(topicName, message);
    }
}
