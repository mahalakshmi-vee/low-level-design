class LFUCache {
    class Node {
        int key;
        int value;
        int frequency;
        public Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }
    private Map<Integer, Node> itemMap;
    private Map<Integer, LinkedHashSet<Node>> frequencyMap;
    private int actualCapacity;
    private int leastFrequency;
    public LFUCache(int capacity) {
        actualCapacity = capacity;
        itemMap = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        if (!itemMap.containsKey(key)) return -1;

        Node node = itemMap.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (itemMap.containsKey(key)) {
            Node existingNode = itemMap.get(key);
            updateFrequency(existingNode);
            existingNode.value = value;
        }
        else {
            if (itemMap.size() >= actualCapacity) {
                evictLeastFrequentlyUsedItem();
            }
            Node newNode = new Node(key, value, 1);
            itemMap.put(key, newNode);
            frequencyMap.putIfAbsent(newNode.frequency, new LinkedHashSet<>());
            frequencyMap.get(newNode.frequency).add(newNode);
            leastFrequency = 1;
        }
    }

    private void evictLeastFrequentlyUsedItem() {
        LinkedHashSet<Node> setNode = frequencyMap.get(leastFrequency);
        Node nodeToEvict = setNode.iterator().next(); // To retrieve the first element.
        
        setNode.remove(nodeToEvict);
        itemMap.remove(nodeToEvict.key);
        if (setNode.isEmpty()) {
            frequencyMap.remove(leastFrequency);
            leastFrequency++;
        }
    }

    private void updateFrequency(Node node) {
        // Remove the node from the frequency Map based on it frequencyValue
        LinkedHashSet<Node> setNode = frequencyMap.get(node.frequency);
        setNode.remove(node); 
        if (setNode.isEmpty()) {
            if (leastFrequency == node.frequency) {
                leastFrequency++;
            }
        }

        // Increment the the node frequency value
        node.frequency += 1;

        // Add the node into the frequency Map based on it frequencyValue;
        frequencyMap.putIfAbsent(node.frequency, new LinkedHashSet<>());
        frequencyMap.get(node.frequency).add(node);
    }

    // Time complexity to remove an item from LinkedHashSet is O(1).
    // Code: setNode.remove(node);
    // 
    // How?
    // - LinkedHashSet internally uses LinkedHashMap.
    // - LinkedHashMap stores each node as a key and the corresponding DLL (Doubly Linked List) node as a value.
    // - When we remove a node from LinkedHashSet, its corresponding DLL node is fetched in O(1) time using the HashMap.
    // - Since the DLL node contains direct pointers to its previous and next nodes, removing it from the DLL is also O(1).
    //
    // ✅ HashMap lookup: O(1)
    // ✅ DLL node removal: O(1)
    // ✅ Overall removal complexity: O(1)

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
