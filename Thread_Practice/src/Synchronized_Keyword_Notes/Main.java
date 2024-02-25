package Synchronized_Keyword_Notes;

/**
 * Notes: not synchronized method is not thread safe, which means multiple thread can access the same method at the same time.
 * Making the thread synchronized means only one thread can use the method at a time.
 * **/
public class Main {
    public static void main(String[] args) throws InterruptedException{
        SyncDemo c = new SyncDemo();
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 10000; i++) c.counter();
        });
        Thread t2 = new Thread(()->{
            for(int i = 0; i < 10000; i++) c.counter();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.ctr);
    }
}
