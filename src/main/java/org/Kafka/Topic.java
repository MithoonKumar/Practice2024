package org.Kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topic {
    List<Partition> partitionList;
    HashMap<String, HashMap<String, Integer>> groupIdConsumerIdPartitionIdMap;

    public Topic(int numPartitions) {
        this.partitionList = new ArrayList<>();
        for (int i=0; i<numPartitions; i++) {
            this.partitionList.add(new Partition());
        }
        this.groupIdConsumerIdPartitionIdMap = new HashMap<>();
    }

    public void addMessage(String message) {
        int partitionId = message.hashCode() % this.partitionList.size();
        this.partitionList.get(partitionId).addMessageToPartition(message);
    }

    public String readMessage(String groupId, String consumerId) {
        int partitionIndex = this.groupIdConsumerIdPartitionIdMap.get(groupId).get(consumerId);
        return this.partitionList.get(partitionIndex).readMessage(groupId);
    }

    public void subscribeToTopic(String groupId, String consumerId) {
        if (groupIdConsumerIdPartitionIdMap.get(groupId) == null) {
            this.groupIdConsumerIdPartitionIdMap.put(groupId, new HashMap<>());
        }
        int numOfExistingConsumers = this.groupIdConsumerIdPartitionIdMap.get(groupId).size();
        if (numOfExistingConsumers == this.partitionList.size()) {
            throw new RuntimeException("Can not add more consumers to the group");
        }
        HashMap<String, Integer> consumerIdPartitionMap = this.groupIdConsumerIdPartitionIdMap.get(groupId);
        consumerIdPartitionMap.put(consumerId, numOfExistingConsumers);
        this.partitionList.get(numOfExistingConsumers).addConsumerGroup(groupId);
        this.groupIdConsumerIdPartitionIdMap.put(groupId, consumerIdPartitionMap);
    }
}
