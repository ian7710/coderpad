package Concurrency;

// Extend the Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        // Code to be executed by this thread
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Value: " + i);
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Create and start two threads
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}
