package Collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap with String keys and Integer values
        Map<String, Integer> sortedMap = new TreeMap<>();

        // Put key-value pairs into the TreeMap
        sortedMap.put("Apple", 5);
        sortedMap.put("Banana", 2);
        sortedMap.put("Cherry", 7);

        // Access a value by key
        System.out.println("Apple count: " + sortedMap.get("Apple"));

        // Remove a key-value pair
        sortedMap.remove("Banana");

        // Iterate over the TreeMap (entries will be sorted by key)
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Check if the TreeMap contains a specific key
        if (sortedMap.containsKey("Cherry")) {
            System.out.println("Cherry is in the map.");
        }

        // Get the size of the TreeMap
        System.out.println("Number of entries: " + sortedMap.size());
    }
}

