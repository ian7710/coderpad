package SystemDesign;

import java.util.HashMap;

public class LRUCache {

    // Node class representing each element in the doubly linked list
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity; // Maximum capacity of the cache
    private HashMap<Integer, Node> cacheMap; // HashMap to store key-node pairs
    private Node head, tail; // Head and tail of the doubly linked list

    // Constructor to initialize the LRU cache
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new Node(-1, -1); // Dummy head
        tail = new Node(-1, -1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to get the value of the key if it exists in the cache
    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            // Move the accessed node to the front (most recently used)
            Node node = cacheMap.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }
        return -1; // Return -1 if the key is not present
    }

    // Function to put a key-value pair into the cache
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            // If the key already exists, update the value and move it to the front
            Node node = cacheMap.get(key);
            node.value = value;
            removeNode(node);
            addToFront(node);
        } else {
            if (cacheMap.size() == capacity) {
                // If the cache is full, remove the least recently used node (tail.prev)
                cacheMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }
            // Add the new node to the front
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addToFront(newNode);
        }
    }

    // Helper function to remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper function to add a node to the front of the doubly linked list
    private void addToFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        // Example usage
        LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1)); // Returns 1

        lruCache.put(3, 3); // Evicts key 2
        System.out.println(lruCache.get(2)); // Returns -1 (not found)

        lruCache.put(4, 4); // Evicts key 1
        System.out.println(lruCache.get(1)); // Returns -1 (not found)
        System.out.println(lruCache.get(3)); // Returns 3
        System.out.println(lruCache.get(4)); // Returns 4
    }
}

