package interview.uber.kafka;




public class Main {

    public static void main(String[] args) {
        Broker broker = new Broker();
        String topicName = "Topic-1";
        broker.createTopic(2, "Topic-1");
        Consumer consumer1 = new Consumer("group-1", "consumer-1", broker, topicName);
        Consumer consumer2 = new Consumer("group-1", "consumer-2", broker, topicName);

        broker.subscribe(topicName, consumer1.getGroupId(), consumer1.getConsumerId());
        broker.subscribe(topicName, consumer2.getGroupId(), consumer2.getConsumerId());

        Consumer consumer3 = new Consumer("group-2", "consumer-1", broker, topicName);
        Consumer consumer4 = new Consumer("group-2", "consumer-2", broker, topicName);

        broker.subscribe(topicName, consumer3.getGroupId(), consumer3.getConsumerId());
        broker.subscribe(topicName, consumer4.getGroupId(), consumer4.getConsumerId());

        Producer producer = new Producer(topicName, broker);

        producer.addMessage("first");
        producer.addMessage("second");

        producer.addMessage("first");
        producer.addMessage("second");

        System.out.println(consumer1.readMessage());
        System.out.println(consumer2.readMessage());

        System.out.println("line break");

        System.out.println(consumer3.readMessage());
        System.out.println(consumer4.readMessage());

        System.out.println(consumer3.readMessage());
        System.out.println(consumer4.readMessage());

    }
}
