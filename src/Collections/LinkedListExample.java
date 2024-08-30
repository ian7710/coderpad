package Collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        List<String> names = new LinkedList<>();

        // Add elements to the LinkedList
        names.add("John");
        names.add("Jane");
        names.add("Doe");

        // Access an element
        System.out.println("First name: " + names.get(0));

        // Add an element at a specific position
        names.add(1, "Smith");

        // Remove an element
        names.remove("Doe");

        // Iterate over the LinkedList
        for (String name : names) {
            System.out.println(name);
        }

        // Check if the LinkedList contains a specific element
        if (names.contains("Jane")) {
            System.out.println("Jane is in the list.");
        }

        // Get the size of the LinkedList
        System.out.println("Number of names: " + names.size());
    }
}

