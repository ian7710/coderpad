package SystemDesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatApplication {

    // Inner class representing a User in the chat application
    static class User {
        String username;

        // Constructor to initialize a User
        User(String username) {
            this.username = username;
        }

        // Method to get the username
        public String getUsername() {
            return username;
        }
    }

    // Inner class representing a Message in the chat application
    static class Message {
        String sender;
        String receiver;
        String content;
        long timestamp;

        // Constructor to initialize a Message
        Message(String sender, String receiver, String content) {
            this.sender = sender;
            this.receiver = receiver;
            this.content = content;
            this.timestamp = System.currentTimeMillis(); // Current time in milliseconds
        }

        // Method to display the message content
        @Override
        public String toString() {
            return "[" + sender + " to " + receiver + "]: " + content + " (at " + timestamp + ")";
        }
    }

    // List to store all users in the chat application
    private List<User> users;

    // Map to store message history between users
    private Map<String, List<Message>> messageHistory;

    // Constructor to initialize the chat application
    public ChatApplication() {
        users = new ArrayList<>();
        messageHistory = new HashMap<>();
    }

    // Method to add a new user to the chat application
    public void addUser(String username) {
        User user = new User(username);
        users.add(user);
        System.out.println("User added: " + username);
    }

    // Method to send a message from one user to another
    public void sendMessage(String senderUsername, String receiverUsername, String content) {
        // Ensure both users exist
        if (getUserByUsername(senderUsername) == null || getUserByUsername(receiverUsername) == null) {
            System.out.println("One or both users not found.");
            return;
        }

        // Create a new message
        Message message = new Message(senderUsername, receiverUsername, content);

        // Store the message in the history
        String conversationKey = getConversationKey(senderUsername, receiverUsername);
        messageHistory.putIfAbsent(conversationKey, new ArrayList<>());
        messageHistory.get(conversationKey).add(message);

        System.out.println("Message sent from " + senderUsername + " to " + receiverUsername);
    }

    // Method to view the message history between two users
    public void viewMessageHistory(String user1, String user2) {
        String conversationKey = getConversationKey(user1, user2);
        List<Message> history = messageHistory.get(conversationKey);

        if (history == null || history.isEmpty()) {
            System.out.println("No messages between " + user1 + " and " + user2);
        } else {
            System.out.println("Message history between " + user1 + " and " + user2 + ":");
            for (Message message : history) {
                System.out.println(message);
            }
        }
    }

    // Helper method to get a User by username
    private User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // Return null if user not found
    }

    // Helper method to generate a conversation key
    // Ensures the key is the same regardless of the order of users
    private String getConversationKey(String user1, String user2) {
        return user1.compareTo(user2) < 0 ? user1 + "_" + user2 : user2 + "_" + user1;
    }

    public static void main(String[] args) {
        // Example usage
        ChatApplication chatApp = new ChatApplication();

        // Add users to the chat application
        chatApp.addUser("Alice");
        chatApp.addUser("Bob");

        // Send messages between users
        chatApp.sendMessage("Alice", "Bob", "Hello, Bob!");
        chatApp.sendMessage("Bob", "Alice", "Hi, Alice!");

        // View message history
        chatApp.viewMessageHistory("Alice", "Bob");

        // Add another user and send a message
        chatApp.addUser("Charlie");
        chatApp.sendMessage("Alice", "Charlie", "Hey Charlie!");

        // View message history between Alice and Charlie
        chatApp.viewMessageHistory("Alice", "Charlie");
    }
}

