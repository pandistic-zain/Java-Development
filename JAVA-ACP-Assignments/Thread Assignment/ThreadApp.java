public class ThreadApp {
    // Shared lock object
    private static final Object lock = new Object();
    public static void main(String[] args) {
        // Create the first thread (thread1)
        CustomThread thread1 = new CustomThread(() -> {
            synchronized (lock) {
                // Task for thread 1
                for (int i = 1; i < 4; i++) {
                    System.out.println("Thread 1 executing: " + i);
                    try {
                        Thread.sleep(1000); // Pause for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create the second thread (thread2)
        CustomThread thread2 = new CustomThread(() -> {
            synchronized (lock) {
                // Task for thread 2
                for (int i = 4; i >= 1; i--) {
                    System.out.println("Thread 2 executing: " + i);
                    try {
                        Thread.sleep(1200); // Pause for 1.2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create the third thread (thread3)
        CustomThread thread3 = new CustomThread(() -> {
            synchronized (lock) {
                // Task for thread 3 (print even numbers)
                for (int i = 0; i < 6; i += 2) {
                    System.out.println("Thread 3 executing Even num: " + i);
                    try {
                        Thread.sleep(800); // Pause for 0.8 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create the fourth thread (thread4)
        CustomThread thread4 = new CustomThread(() -> {
            synchronized (lock) {
                // Task for thread 4 (print odd numbers)
                for (int i = 1; i < 6; i += 2) {
                    System.out.println("Thread 4 executing Odd num: " + i);
                    try {
                        Thread.sleep(1000); // Pause for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create the fifth thread (thread5)
        CustomThread thread5 = new CustomThread(() -> {
            synchronized (lock) {
                // Task for thread 5
                System.out.println("I am Thread 5.");
            }
        });

        // Start all threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        // Check if the threads are alive
        System.out.println("Thread 1 is alive: " + thread1.isAlive());
        System.out.println("Thread 2 is alive: " + thread2.isAlive());
        System.out.println("Thread 3 is alive: " + thread3.isAlive());
        System.out.println("Thread 4 is alive: " + thread4.isAlive());
        System.out.println("Thread 5 is alive: " + thread5.isAlive());

        // Set thread priorities (optional)
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(2);
        thread3.setPriority(7);
        thread4.setPriority(9);
        thread5.setPriority(Thread.MIN_PRIORITY);

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Demonstrate interrupting the threads
        thread1.interrupt();
        thread2.interrupt();
        thread3.interrupt();
        thread4.interrupt();
        thread5.interrupt();
    }
}