package wait_notify_Notes;

public class ThreadTwo implements Runnable{
    A a;
    public ThreadTwo (A a){
        this.a = a;
        Thread t1 = new Thread(this, "Ni");
        t1.start();
    }
    @Override
    public void run() {
        while(true){
            a.get();
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
