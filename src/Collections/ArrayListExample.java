package Collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        List<String> fruits = new ArrayList<>();

        // Add elements to the ArrayList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Access elements
        System.out.println("First fruit: " + fruits.get(0));

        // Remove an element
        fruits.remove("Banana");

        // Iterate over the ArrayList
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Check if the ArrayList contains a specific element
        if (fruits.contains("Cherry")) {
            System.out.println("Cherry is in the list.");
        }

        // Get the size of the ArrayList
        System.out.println("Number of fruits: " + fruits.size());
    }
}
