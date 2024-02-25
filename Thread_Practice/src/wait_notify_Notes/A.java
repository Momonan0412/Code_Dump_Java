package wait_notify_Notes;

public class A {
    int num;
    boolean flag = false;
    public synchronized void put(int num){
        while(flag){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        System.out.println("Put " + num);
        this.num = num;
        flag = true;
        notify();
    }
    public synchronized void get(){
        while(!flag){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        System.out.println("Get " + num);
        flag = false;
        notify();
    }
}
