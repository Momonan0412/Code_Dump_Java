package set_get_Priority_Notes;

public class Main {
    public static void main(String[] args) throws IllegalThreadStateException, InterruptedException{
        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName());
                if(i == 2) Thread.currentThread().setName("Nilou");
            }
        }, "Kokomi Thread");
        Thread t2 = new Thread(()->{
            try{
                t1.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(mainThread.getName());
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName());
                if(i == 2) Thread.currentThread().setName("Xiang Ling");
            }
        }, "Furina Thread"); // Changing the t2's thread name;
        t1.start();
        t2.start();
        t2.join(); // Adding the t2.join here would make the print method below executed last
        // and commenting out with make it join the t2's run() method print or would change the existing name of the main thread.
        mainThread.setName("Priority Notes 01/28/2024");
        System.out.println(mainThread.getName());
    }
}
