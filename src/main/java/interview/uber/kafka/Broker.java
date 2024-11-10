package interview.uber.kafka;

import java.util.HashMap;

public class Broker {

    private HashMap<String, Topic> topicsMap ;

    public Broker() {
        this.topicsMap = new HashMap<>();
    }

    public void createTopic(int numPartitions, String topicName) {
        Topic topic = new Topic(numPartitions);
        this.topicsMap.put(topicName, topic);
    }

    public void subscribe(String topicName, String groupId, String consumerId) {
        this.topicsMap.get(topicName).subscribe(groupId, consumerId);
    }

    public String readMessage(String topicName, String groupId, String consumerId) {
        return this.topicsMap.get(topicName).readMessage(groupId, consumerId);
    }

    public void addMessage(String topicName, String message) {
        this.topicsMap.get(topicName).addMessage(message);
    }


}
