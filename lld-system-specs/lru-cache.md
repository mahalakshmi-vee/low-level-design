## Design a Cache Using LRU Eviction Policy

### Requirements:

Design a data structure that follows the constraints of a **Least Recently Used (LRU)** cache.

1. Initialize: Initialize the LRU cache with a positive size capacity.
2. Get: Return the value of the key if the key exists, otherwise return -1.
3. Put: Update the value of the key if the key exists. Otherwise add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the recently used key.

The functions get and put must run in O(1) average time complexity.
