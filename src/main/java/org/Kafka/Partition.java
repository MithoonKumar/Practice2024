package org.Kafka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition {
    List<String> messages;
    HashMap<String, Integer> offsetMap;

    public Partition() {
        this.messages = new ArrayList<>();
        this.offsetMap = new HashMap<>();
    }

    public void addMessageToPartition(String message) {
        this.messages.add(message);
    }

    public void addConsumerGroup(String groupId) {
        this.offsetMap.put(groupId, 0);
    }

    public String readMessage(String groupId) {
        int offset = this.offsetMap.get(groupId);
        String message = messages.get(offset);
        this.offsetMap.put(groupId, offset+1);
        return message;
    }
}
