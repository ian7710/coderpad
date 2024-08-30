package Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static final Lock lock = new ReentrantLock();
    private static int count = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock(); // Acquire the lock
            try {
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
            } finally {
                lock.unlock(); // Release the lock
            }
        };

        // Create multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}

