package Concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Create tasks that modify the ConcurrentHashMap
        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                map.put("Key" + i, i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 10; i < 20; i++) {
                map.put("Key" + i, i);
            }
        };

        executor.execute(task1);
        executor.execute(task2);

        executor.shutdown();

        // Wait for all tasks to finish and print the map
        while (!executor.isTerminated()) {
        }

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

