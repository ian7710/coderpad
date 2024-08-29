public class Singleton {

    // A static variable to hold the one instance of the Singleton class.
    // 'volatile' ensures that multiple threads handle the 'instance' variable correctly
    // when it is being initialized to the Singleton instance.
    private static volatile Singleton instance = null;

    // Private constructor prevents any other class from instantiating.
    // This ensures that the Singleton class cannot be instantiated from outside this class.
    private Singleton() {
        // Private constructor to prevent instantiation
    }

    // This is the static method to get the Singleton instance.
    // It provides a global point of access to the Singleton instance.
    public static Singleton getInstance() {
        // First check if instance is null, to avoid unnecessary synchronization
        if (instance == null) {
            // Synchronize only the block where instance is created
            synchronized (Singleton.class) {
                // Double-check if instance is still null before creating the Singleton instance
                if (instance == null) {
                    instance = new Singleton(); // Lazy initialization: instance is created only when needed
                }
            }
        }
        return instance; // Return the Singleton instance
    }

    // A simple method to demonstrate functionality of the Singleton class
    public void showMessage(){
        System.out.println("Hello from Singleton!"); // Output message
    }

    // Main method to test the Singleton functionality
    public static void main(String[] args) {
        // Get the only instance of Singleton
        Singleton singleton = Singleton.getInstance();
        // Call the showMessage method
        singleton.showMessage(); // Output: Hello from Singleton!
    }
}
