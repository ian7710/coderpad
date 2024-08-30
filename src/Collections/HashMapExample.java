package Collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap with String keys and Integer values
        Map<String, Integer> ageMap = new HashMap<>();

        // Put key-value pairs into the HashMap
        ageMap.put("Alice", 30);
        ageMap.put("Bob", 25);
        ageMap.put("Charlie", 35);

        // Access a value by key
        System.out.println("Alice's age: " + ageMap.get("Alice"));

        // Remove a key-value pair
        ageMap.remove("Bob");

        // Iterate over the HashMap
        for (Map.Entry<String, Integer> entry : ageMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Check if the HashMap contains a specific key
        if (ageMap.containsKey("Charlie")) {
            System.out.println("Charlie is in the map.");
        }

        // Get the size of the HashMap
        System.out.println("Number of entries: " + ageMap.size());
    }
}

