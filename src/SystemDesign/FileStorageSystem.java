package SystemDesign;

import java.util.HashMap;
import java.util.Map;

public class FileStorageSystem {

    // A HashMap to simulate the storage, where the key is the file name and the value is the file content
    private Map<String, String> storage;

    // Constructor to initialize the storage system
    public FileStorageSystem() {
        storage = new HashMap<>();
    }

    // Function to upload a file
    public void uploadFile(String fileName, String fileContent) {
        if (storage.containsKey(fileName)) {
            System.out.println("File already exists. Overwriting the content.");
        }
        storage.put(fileName, fileContent);
        System.out.println("File uploaded successfully: " + fileName);
    }

    // Function to download a file
    public String downloadFile(String fileName) {
        if (storage.containsKey(fileName)) {
            System.out.println("File downloaded successfully: " + fileName);
            return storage.get(fileName);
        } else {
            System.out.println("File not found: " + fileName);
            return null;
        }
    }

    // Function to delete a file
    public void deleteFile(String fileName) {
        if (storage.containsKey(fileName)) {
            storage.remove(fileName);
            System.out.println("File deleted successfully: " + fileName);
        } else {
            System.out.println("File not found: " + fileName);
        }
    }

    // Function to list all files in the storage
    public void listFiles() {
        if (storage.isEmpty()) {
            System.out.println("No files in the storage.");
        } else {
            System.out.println("Files in storage:");
            for (String fileName : storage.keySet()) {
                System.out.println(fileName);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        FileStorageSystem fileStorage = new FileStorageSystem();

        // Upload files
        fileStorage.uploadFile("file1.txt", "This is the content of file1.");
        fileStorage.uploadFile("file2.txt", "This is the content of file2.");

        // List files
        fileStorage.listFiles();

        // Download a file
        String content = fileStorage.downloadFile("file1.txt");
        System.out.println("Content of file1.txt: " + content);

        // Delete a file
        fileStorage.deleteFile("file2.txt");

        // List files after deletion
        fileStorage.listFiles();
    }
}

