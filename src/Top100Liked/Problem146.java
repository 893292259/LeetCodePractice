package Top100Liked;

import DataStructures.LRUCache;

public class Problem146 {
    public static void main(String...args){
        LRUCache cache = new LRUCache(3);
        cache.put(2, 1);
        cache.get(2);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.put(1, 4);
        cache.put(2, 4);
        cache.put(3, 4);
        cache.put(4, 4);
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
        cache.put(5, 1);
        cache.get(2);       // returns 1
        cache.put(2, 3);    // evicts key 2
        cache.get(5);       // returns -1 (not found)
        cache.put(1, 4);    // evicts key 1
        cache.put(1, 4);
        cache.put(3, 4);
        cache.put(3, 4);
        cache.put(6, 4);
        cache.get(6);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
        // returns 4
    }
}
