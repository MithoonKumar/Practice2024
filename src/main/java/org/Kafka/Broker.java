package org.Kafka;

import java.util.HashMap;

public class Broker {
    HashMap<String, Topic> topicHashMap;


    public Broker() {
        this.topicHashMap = new HashMap<>();
    }

    public void addTopic(String topicName, int numOfPartitions) {
        Topic topic = new Topic(numOfPartitions);
        this.topicHashMap.put(topicName, topic);
    }

    public void subscribeToTopic(String topicName, String groupId, String consumerId) {
        Topic topic  = this.topicHashMap.get(topicName);
        topic.subscribeToTopic(groupId, consumerId);
    }

    public String readMessage(String topicName, String groupId, String consumerId) {
        return this.topicHashMap.get(topicName).readMessage(groupId, consumerId);
    }

    public void addMessage(String topicName, String message) {
        this.topicHashMap.get(topicName).addMessage(message);
    }
}
