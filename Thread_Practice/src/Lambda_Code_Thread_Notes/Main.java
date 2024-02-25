package Lambda_Code_Thread_Notes;

/**
 * This code demonstrates the use of both extends Thread and implements Runnable approaches for creating and starting threads in Java.
 * It includes the main class, a class implementing the Runnable interface (Extends_And_Implements_Notes.ThreadSecond),
 * and a class extending the Thread class (Extends_And_Implements_Notes.ThreadFirst). The main method creates instances of both classes,
 * starts the execution of Extends_And_Implements_Notes.ThreadFirst using the start() method, sleeps the main thread briefly,
 * and then starts the execution of Extends_And_Implements_Notes.ThreadSecond using a Thread object with start().
 * **/

public class Main {
    public static void main(String[] args) {
        // Creating instances of Extends_And_Implements_Notes.ThreadFirst and Extends_And_Implements_Notes.ThreadSecond
        ThreadFirst t1 = new ThreadFirst();
        /**
         * Compare To The First Thread Notes
         * **/
//        Runnable t2 = () -> {
//                for(int i = 0; i < 5; i++) {
//                    System.out.println("Hello!");
//                    try {
//                        // Simulating some work with a sleep
//                        Thread.sleep(100);
//                    } catch(Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };

        // Creating a Thread object with Extends_And_Implements_Notes.ThreadSecond as a Runnable
        /** Instead Of The Commented Out Code Above
         *  Replace "t2" by the whole " -> code "
         * **/
//        Thread obj = new Thread(t2);
        Thread obj = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Hello!");
                try {
                    // Simulating some work with a sleep
                    Thread.sleep(100);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Starting the execution of the Extends_And_Implements_Notes.ThreadFirst instance (extends Thread)
        t1.start();

        try {
            // Sleeping the main thread for 10 milliseconds
            Thread.sleep(10);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Starting the execution of the Thread object with Extends_And_Implements_Notes.ThreadSecond as a Runnable
        obj.start();
    }
}