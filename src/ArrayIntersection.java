import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    // Method to find the intersection of two arrays
    public static int[] intersection(int[] nums1, int[] nums2) {
        // A set to store unique elements from the first array
        Set<Integer> set1 = new HashSet<>();

        // A set to store the intersection result
        Set<Integer> result = new HashSet<>();

        // Iterate through the first array and add each element to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Iterate through the second array
        for (int num : nums2) {
            // If an element from the second array is in set1, it means it's in both arrays
            if (set1.contains(num)) {
                // Add the element to the result set
                result.add(num);
            }
        }

        // Convert the result set to an array
        int[] intersection = new int[result.size()];
        int i = 0;
        // Iterate through the result set and copy elements into the intersection array
        for (int num : result) {
            intersection[i++] = num;
        }

        // Return the intersection array
        return intersection;
    }

    public static void main(String[] args) {
        // Example input arrays
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        // Call the intersection method and store the result
        int[] result = intersection(nums1, nums2);

        // Print the result
        for (int num : result) {
            System.out.println(num); // Output: 2
        }
    }
}
