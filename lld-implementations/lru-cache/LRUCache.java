class LRUCache {
    private int currentCapacity = 0;
    private int actualCapacity = 0;
    private Map<Integer, Node> cacheItems;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.actualCapacity = capacity;
        cacheItems = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.setNext(tail);
        tail.setPrevious(head); 
    }
    
    public int get(int key) {
        if (!cacheItems.containsKey(key)) return -1;

        Node node = cacheItems.get(key);
        int value = node.value;
        deleteNode(node);
        addNode(node);
        cacheItems.put(key, tail.previous);
        return value;
    }
    
    public void put(int key, int value) {
        if (cacheItems.containsKey(key)) {
            Node existingNode = cacheItems.get(key);
            deleteNode(existingNode);
            existingNode.setValue(value);
            addNode(existingNode);
            cacheItems.put(key, tail.previous);
        }
        else if (currentCapacity >= actualCapacity) {
            Node deleteNode = head.next;
            deleteNode(deleteNode);
            cacheItems.remove(deleteNode.key);
            Node newNode = new Node(key, value);
            addNode(newNode);
            cacheItems.put(key, tail.previous);
        }
        else {
            Node newNode = new Node(key, value);
            addNode(newNode);
            cacheItems.put(key, tail.previous);
            currentCapacity++;
        }
    }

    public void deleteNode(Node deleteNode) {
        Node deleteNodePrevious = deleteNode.previous;
        Node deleteNodeNext = deleteNode.next;
        deleteNodePrevious.next = deleteNodeNext;
        deleteNodeNext.previous = deleteNodePrevious;
    }

    public void addNode(Node newNode) {
        Node tailPrevious = tail.previous;
        tailPrevious.next = newNode;
        newNode.previous = tailPrevious;
        newNode.next = tail;
        tail.previous = newNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
