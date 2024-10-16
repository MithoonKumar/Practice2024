package org.example;

import java.util.*;

public class ExperimentationClass {


    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(6);
        treeSet.add(7);

        System.out.println(treeSet.tailSet(5+1).first());
    }


    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int cumSum = 0;
        hashMap.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            cumSum+=nums[i];
            int rem = cumSum %k;
            if (hashMap.containsKey(rem) && i -hashMap.get(rem)  >= 2) {
                return true;
            } else {
                hashMap.put(rem, i);
            }
        }
        return false;

    }

    public int smallestChair(int[][] times, int targetFriend) {
        List<FriendInfo> friendInfoList = new ArrayList<>();
        for (int i=0; i<times.length; i++) {
            friendInfoList.add(new FriendInfo(i, times[i][0], times[i][1]));
        }
        TreeSet<Integer> availableChairs = new TreeSet<>();
        for (int i=0; i< times.length; i++) {
            availableChairs.add(i);
        }
        PriorityQueue<PriorityQueueElement> pq = new PriorityQueue<>();



        for (int i=0; i<times.length; i++) {
            FriendInfo friendInfo = friendInfoList.get(i);
            while(!pq.isEmpty() && pq.peek().departTime <= friendInfo.arrivalTime) {
                pq.poll();
            }
            Integer minNumChair = availableChairs.first();
            availableChairs.remove(minNumChair);
            friendInfo.chairNum = minNumChair;
            if (friendInfo.id == targetFriend) {
                return minNumChair;
            }
            pq.add(new PriorityQueueElement(friendInfo.id, friendInfo.arrivalTime, friendInfo.departTime, minNumChair));
        }
        return -1;
    }




}


class PriorityQueueElement implements Comparable<PriorityQueueElement> {
    public Integer id;
    public Integer arrivalTime, departTime;
    public Integer chairNum;

    public PriorityQueueElement(Integer id, Integer arrivalTime, Integer departTime, Integer chairNum) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
        this.chairNum = chairNum;
    }

    @Override
    public int compareTo(PriorityQueueElement o) {
        if (Objects.equals(this.departTime, o.departTime)) {
            return 0;
        }
        if (this.departTime < o.departTime) {
            return 1;
        } else {
            return -1;
        }
    }
}




class FriendInfo implements Comparable<FriendInfo>{
    public Integer id;
    public Integer arrivalTime, departTime;
    public Integer chairNum;

    public FriendInfo(Integer id, Integer arrivalTime, Integer departTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.departTime = departTime;
    }

    @Override
    public int compareTo(FriendInfo o) {
        if (Objects.equals(this.arrivalTime, o.arrivalTime)) {
            return 0;
        }
        if (this.arrivalTime < o.arrivalTime) {
            return 1;
        } else {
            return -1;
        }
    }
}

//class Element {
//    int first, second, third;
//
//    public Element(int first, int second, int third) {
//        this.first = first;
//        this.second = second;
//        this.third = third;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(first, second, third);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        Element e = (Element) obj;
//        return this.first == e.first && this.second == e.second && this.third == e.third;
//    }
//
//
//}

class ListNode {
       public int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Node implements Comparable<Node> {

    private ListNode listNode;

    public Node(ListNode listNode) {
        this.listNode = listNode;
    }

    @Override
    public int compareTo(Node o) {
        Node node = (Node) o;
        if (node.listNode.val == this.listNode.val) {
            return 0;
        } else if (node.listNode.val < this.listNode.val) {
            return 1;
        } else {
            return -1;
        }
    }
}