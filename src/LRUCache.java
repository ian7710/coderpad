import java.util.HashMap;

class LRUCache {

    // Node class representing each entry in the cache
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private Node head, tail;

    // Constructor to initialize the LRUCache with a specific capacity
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    // Method to retrieve a value from the cache
    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1; // Return -1 if the key is not found
        }

        // Move the accessed node to the front (head) of the doubly linked list
        moveToHead(node);
        return node.value;
    }

    // Method to insert or update a value in the cache
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // Update the value of the existing node
            node.value = value;
            // Move the updated node to the front (head) of the doubly linked list
            moveToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node(key, value);

            // Add the new node to the map
            map.put(key, newNode);
            // Add the new node to the front (head) of the doubly linked list
            addNode(newNode);

            // Check if the cache exceeds its capacity
            if (map.size() > capacity) {
                // Remove the least recently used (LRU) node, which is at the tail
                Node tailNode = popTail();
                map.remove(tailNode.key); // Remove from the map
            }
        }
    }

    // Helper method to add a node to the front (head) of the doubly linked list
    private void addNode(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = node;
        }
    }

    // Helper method to remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }

        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }

    // Helper method to move a node to the front (head) of the doubly linked list
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Helper method to remove the node at the tail of the doubly linked list
    private Node popTail() {
        Node res = tail;
        removeNode(tail);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1); // Cache: {1=1}
        lruCache.put(2, 2); // Cache: {1=1, 2=2}

        System.out.println(lruCache.get(1)); // Returns 1, Cache: {2=2, 1=1}

        lruCache.put(3, 3); // Evicts key 2, Cache: {1=1, 3=3}

        System.out.println(lruCache.get(2)); // Returns -1 (not found)

        lruCache.put(4, 4); // Evicts key 1, Cache: {3=3, 4=4}

        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3, Cache: {4=4, 3=3}
        System.out.println(lruCache.get(4)); // Returns 4, Cache: {3=3, 4=4}
    }
}
