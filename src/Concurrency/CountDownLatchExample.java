package Concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static final int THREAD_COUNT = 3;
    private static final CountDownLatch latch = new CountDownLatch(THREAD_COUNT);

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                Thread.sleep(1000); // Simulate work
                System.out.println(Thread.currentThread().getName() + " completed work");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // Decrease the count of the latch
            }
        };

        // Create multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            latch.await(); // Wait for all threads to complete
            System.out.println("All threads have completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

