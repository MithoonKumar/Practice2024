package interview.uber.multiLevelCacheSystem;

/*
    ICache
    LRUCache
    ILevelCache
    LevelCache
    ReadInfo
    WriteInfo

*/


public class Main {
    public static void main(String[] args) {
        // Define cache levels with their respective read and write times, and capacities
        ICache<String, String> l1Cache = new LRUCache<>(2);
        ICache<String, String> l2Cache = new LRUCache<>(3);
        ICache<String, String> l3Cache = new LRUCache<>(4);

        ILevelCache<String, String> level3 = new LevelCache<>(null, 3, 5, l3Cache);
        ILevelCache<String, String> level2 = new LevelCache<>(level3, 2, 4, l2Cache);
        ILevelCache<String, String> level1 = new LevelCache<>(level2, 1, 2, l1Cache);

        // Test 1: Basic Write Operation
        System.out.println("---- Test 1: Write Key-Value (key1, value1) ----");
        WriteInfo writeInfo1 = level1.put("key1", "value1");
        System.out.println("Total Write Time: " + writeInfo1.getWriteTime());

        // Test 2: Read Operation from Level 1
        System.out.println("---- Test 2: Read Key (key1) ----");
        ReadInfo<String> readInfo1 = level1.get("key1");
        System.out.println("Value: " + readInfo1.getV());
        System.out.println("Total Read Time: " + readInfo1.getReadTime());

        // Test 3: Read Operation for a Key that is in Level 2 (requires propagation to Level 1)
        System.out.println("---- Test 3: Read Key (key2) ----");
        level2.put("key2", "value2");
        ReadInfo<String> readInfo2 = level1.get("key2");
        System.out.println("Value: " + readInfo2.getV());
        System.out.println("Total Read Time: " + readInfo2.getReadTime());

        // Test 4: Check LRU Eviction in Level 1
        System.out.println("---- Test 4: Add More Keys to Trigger LRU Eviction ----");
        level1.put("key3", "value3");
        level1.put("key4", "value4"); // This should evict "key1" as L1 has capacity of 2
        System.out.println("Value of key1 after eviction from L1: " + level1.get("key1").getV());
        System.out.println("Value of key2 in L1 (should be present): " + level1.get("key2").getV());

        // Test 5: Write Propagation Across All Levels
        System.out.println("---- Test 5: Write Key-Value (key5, value5) ----");
        WriteInfo writeInfo2 = level1.put("key5", "value5"); // Should write across L1, L2, and L3
        System.out.println("Total Write Time: " + writeInfo2.getWriteTime());

        // Test 6: Verify Key in all Levels
        System.out.println("---- Test 6: Check Key Presence Across Levels ----");
        System.out.println("Value in L1 (key5): " + l1Cache.get("key5"));
        System.out.println("Value in L2 (key5): " + l2Cache.get("key5"));
        System.out.println("Value in L3 (key5): " + l3Cache.get("key5"));
    }
}
