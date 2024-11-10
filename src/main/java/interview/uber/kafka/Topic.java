package interview.uber.kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topic {
    private List<Partition> partitionList;
    private HashMap<String, HashMap<String, Integer>> groupIdConsumerIdToPartitionMap;
    private HashMap<String, HashMap<Integer, Integer>> groupIdPartitionIdOffestMap;

    public Topic(int numOfPartitions) {
        this.partitionList = new ArrayList<>();
        for (int index = 0; index < numOfPartitions; index++) {
            this.partitionList.add(new Partition());
        }
        this.groupIdConsumerIdToPartitionMap = new HashMap<>();
        this.groupIdPartitionIdOffestMap = new HashMap<>();
    }

    public void addMessage (String message) {
        int partitionNum = message.length() % this.partitionList.size();
        this.partitionList.get(partitionNum).addMessage(message);
    }

    public void subscribe(String groupId, String consumerId) {
        HashMap<String, Integer> consumerPartitionMap = this.groupIdConsumerIdToPartitionMap.getOrDefault(groupId, new HashMap<>());
        if (consumerPartitionMap.size() == this.partitionList.size()) {
            throw new KafkaException("No more subscribers can be added");
        } else {
            int currNumOfConsumers = consumerPartitionMap.size();
            consumerPartitionMap.put(consumerId, consumerPartitionMap.size());
            this.groupIdConsumerIdToPartitionMap.put(groupId, consumerPartitionMap);
            HashMap<Integer, Integer> partitionOffsetMap = this.groupIdPartitionIdOffestMap.getOrDefault(groupId, new HashMap<>());
            partitionOffsetMap.put(currNumOfConsumers, 0);
            this.groupIdPartitionIdOffestMap.put(groupId, partitionOffsetMap);
        }
    }

    public String readMessage(String groupId, String consumerId) {
        if (!this.groupIdConsumerIdToPartitionMap.containsKey(groupId)) {
            throw new KafkaException("No consumers added for this group");
        }
        if (!this.groupIdConsumerIdToPartitionMap.get(groupId).containsKey(consumerId)) {
            throw new KafkaException("This consumer is not subscribed for this group");
        }
        int partitionId = this.groupIdConsumerIdToPartitionMap.get(groupId).get(consumerId);
        int offset = this.groupIdPartitionIdOffestMap.get(groupId).get(partitionId);
        String message = this.partitionList.get(partitionId).readMessage(offset);
        this.groupIdPartitionIdOffestMap.get(groupId).put(partitionId, offset+1);
        return message;
    }


}
