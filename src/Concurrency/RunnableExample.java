package Concurrency;

// Implement the Runnable interface
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to be executed by this thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value: " + i);
        }
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        // Create and start two threads using Runnable
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());
        thread1.start();
        thread2.start();
    }
}
