package org.memoryRequired;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(minTime(new int [] {1, 4, 5, 2, 3}, new int [] {1, 2, 1, 3, 4}, 6));
    }

    public static int minTime(int [] tasks, int [] tasksType, int maxMemory) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i=0; i<tasksType.length; i++) {
            hashMap.computeIfAbsent(tasksType[i], k -> new ArrayList<>());
            hashMap.get(tasksType[i]).add(tasks[i]);
        }

        int count = 0;
        for (Map.Entry<Integer,List<Integer>> entry: hashMap.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() == 1) {
                count++;
            } else {
                Collections.sort(list);
                int f = 0, e = list.size()-1;
                while (f<=e) {
                    if (f == e) {
                        count++;
                        break;
                    }
                    int sum = list.get(f) + list.get(e);
                    if (sum <= maxMemory) {
                        count++;
                        f++;
                        e--;
                    } else {
                        count++;
                        e--;
                    }
                }
            }

        }
        return count;
    }
}
