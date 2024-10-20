package org.Kafka;

public class KafkaSimulation {
    public static void main(String[] args) {
        // Step 1: Create a broker
        Broker broker = new Broker();

        // Step 2: Add a topic with 2 partitions
        broker.addTopic("test-topic", 2);

        // Step 3: Create a producer and add messages to the topic
        Producer producer = new Producer("test-topic", broker);
        producer.addMessage("Message 1");
        producer.addMessage("Message 2");
        producer.addMessage("Message 3");
        producer.addMessage("Message 4");

        // Step 4: Create consumers and subscribe them to the topic
        broker.subscribeToTopic("test-topic", "group-1", "consumer-1");
        broker.subscribeToTopic("test-topic", "group-1", "consumer-2");

        broker.subscribeToTopic("test-topic", "group-2", "consumer-3");

        // Step 5: Create consumer instances and read messages
        Consumer consumer1 = new Consumer("group-1", "consumer-1", broker, "test-topic");
        Consumer consumer2 = new Consumer("group-1", "consumer-2", broker, "test-topic");
        Consumer consumer3 = new Consumer("group-2", "consumer-3", broker, "test-topic");

        // Read messages for group-1
        System.out.println("Group-1:");
        consumer1.readMessage();  // Reads partition 0
        consumer2.readMessage();  // Reads partition 1

        // Read messages for group-2 (independent of group-1)
        System.out.println("Group-2:");
        consumer3.readMessage();  // Reads partition 0
        consumer3.readMessage();  // Reads partition 1

        // Further messages
        System.out.println("Additional Reads:");
        consumer1.readMessage();  // Should read next message from partition 0
        consumer2.readMessage();  // Should read next message from partition 1
    }
}