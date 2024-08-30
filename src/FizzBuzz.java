public class FizzBuzz {

    public static void main(String[] args) {
        // Loop through numbers from 1 to 100
        for (int i = 1; i <= 100; i++) {
            // Check if the number is divisible by both 3 and 5
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz"); // Print "FizzBuzz" if divisible by both
            }
            // Check if the number is divisible by 3
            else if (i % 3 == 0) {
                System.out.println("Fizz"); // Print "Fizz" if divisible by 3
            }
            // Check if the number is divisible by 5
            else if (i % 5 == 0) {
                System.out.println("Buzz"); // Print "Buzz" if divisible by 5
            }
            // If the number is not divisible by 3 or 5
            else {
                System.out.println(i); // Print the number itself
            }
        }
    }
}
