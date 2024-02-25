package Lambda_Code_Thread_Notes;

// Class extending the Thread class
public class ThreadFirst extends Thread {
    public void run() {
        // Task to be executed in a separate thread
        for(int i = 0; i < 5; i++) {
            System.out.println("Hi!");

            try {
                // Simulating some work with a sleep
                Thread.sleep(100);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}