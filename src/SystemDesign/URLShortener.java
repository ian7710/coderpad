package SystemDesign;

import java.util.HashMap;
import java.util.Random;

public class URLShortener {

    // Base URL for the shortening service (e.g., "http://short.url/")
    private static final String BASE_URL = "http://short.url/";

    // Characters used for generating the short URL code
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Length of the generated short URL code
    private static final int CODE_LENGTH = 6;

    // HashMap to store the mapping between short codes and original URLs
    private HashMap<String, String> urlMap;

    // Random object to generate random codes
    private Random random;

    // Constructor to initialize the URL shortening service
    public URLShortener() {
        urlMap = new HashMap<>();
        random = new Random();
    }

    // Function to shorten a given URL
    public String shortenURL(String longURL) {
        // Generate a unique short code
        String shortCode = generateShortCode();

        // Store the mapping between the short code and the original URL
        urlMap.put(shortCode, longURL);

        // Return the complete short URL
        return BASE_URL + shortCode;
    }

    // Function to retrieve the original URL from a shortened URL
    public String getOriginalURL(String shortURL) {
        // Extract the short code from the short URL
        String shortCode = shortURL.replace(BASE_URL, "");

        // Retrieve the original URL from the map
        return urlMap.get(shortCode);
    }

    // Helper function to generate a unique short code
    private String generateShortCode() {
        StringBuilder shortCode;
        do {
            shortCode = new StringBuilder();
            // Generate a random string of CODE_LENGTH using characters from CHAR_SET
            for (int i = 0; i < CODE_LENGTH; i++) {
                int index = random.nextInt(CHAR_SET.length());
                shortCode.append(CHAR_SET.charAt(index));
            }
        } while (urlMap.containsKey(shortCode.toString())); // Ensure the generated code is unique

        return shortCode.toString();
    }

    public static void main(String[] args) {
        // Example usage
        URLShortener urlShortener = new URLShortener();

        // Shorten a URL
        String longURL = "https://www.example.com/some/very/long/url";
        String shortURL = urlShortener.shortenURL(longURL);
        System.out.println("Shortened URL: " + shortURL);

        // Retrieve the original URL using the shortened URL
        String originalURL = urlShortener.getOriginalURL(shortURL);
        System.out.println("Original URL: " + originalURL);
    }
}
