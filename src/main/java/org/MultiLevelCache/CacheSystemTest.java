package org.MultiLevelCache;


public class CacheSystemTest {
    public static void main(String[] args) {
        // Define cache metadata (read and write times for each level)
        LevelCacheMetaData metaDataL1 = new LevelCacheMetaData(1, 2);  // Level 1 cache with readTime=1, writeTime=2
        LevelCacheMetaData metaDataL2 = new LevelCacheMetaData(2, 3);  // Level 2 cache with readTime=2, writeTime=3
        LevelCacheMetaData metaDataL3 = new LevelCacheMetaData(3, 4);  // Level 3 cache with readTime=3, writeTime=4

        // Define the multi-level cache structure (L1 -> L2 -> L3)
        IlevelCache<String, String> level3Cache = new LevelCache<>(2, null, metaDataL3);
        IlevelCache<String, String> level2Cache = new LevelCache<>(2, level3Cache, metaDataL2);
        IlevelCache<String, String> level1Cache = new LevelCache<>(2, level2Cache, metaDataL1);

        // Test case 1: Write some data into the cache system
        System.out.println("----- Test Case 1: Write Operation -----");
        WriteInfo writeInfo = level1Cache.put("key1", "value1");
        System.out.println("Time taken to write 'key1': " + writeInfo.getWriteTime());

        // Write another value to test cache eviction (since capacity is 2)
        WriteInfo writeInfo2 = level1Cache.put("key2", "value2");
        System.out.println("Time taken to write 'key2': " + writeInfo2.getWriteTime());

        // Add a third entry to check eviction in action
        WriteInfo writeInfo3 = level1Cache.put("key3", "value3");
        System.out.println("Time taken to write 'key3' (should trigger eviction): " + writeInfo3.getWriteTime());

    }
}
