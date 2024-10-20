package org.Kafka;

public class Consumer {

    String topicName, groupId, consumerId;
    Broker broker;


    public Consumer(String groupId, String consumerId, Broker broker, String topicName) {
        this.groupId = groupId;
        this.consumerId = consumerId;
        this.broker = broker;
        this.topicName = topicName;
    }


    public void readMessage() {
        System.out.println(this.broker.readMessage(this.topicName, this.groupId, this.consumerId));
    }
}
