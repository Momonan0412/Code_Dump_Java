package wait_notify_Notes;

public class ThreadOne implements Runnable{
    A a;
    public ThreadOne (A a){
        this.a = a;
        Thread t1 = new Thread(this, "Ichi");
        t1.start();
    }
    @Override
    public void run() {
        int i = 0;
        while(true){
            a.put(i++);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException();
            }
        }
    }
}
