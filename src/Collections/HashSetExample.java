package Collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet of Integers
        Set<Integer> numbers = new HashSet<>();

        // Add elements to the HashSet
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Attempt to add duplicate element
        numbers.add(10); // This will not be added since HashSet does not allow duplicates

        // Remove an element
        numbers.remove(20);

        // Iterate over the HashSet
        for (int number : numbers) {
            System.out.println(number);
        }

        // Check if the HashSet contains a specific element
        if (numbers.contains(30)) {
            System.out.println("30 is in the set.");
        }

        // Get the size of the HashSet
        System.out.println("Number of elements: " + numbers.size());
    }
}
