package interview.uber.kafka;


public class Consumer {

    private Broker broker;

    private String groupId;
    private String consumerId;
    private String topicName;

    public Consumer(String groupId, String consumerId, Broker broker, String topicName) {
        this.groupId = groupId;
        this.consumerId = consumerId;
        this.broker = broker;
        this.topicName = topicName;
    }

    public String readMessage() {
        return this.broker.readMessage(topicName, groupId, consumerId);
    }

    public String getConsumerId() {
        return consumerId;
    }

    public String getGroupId() {
        return groupId;
    }
}
