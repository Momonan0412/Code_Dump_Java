package join_And_isAlive_Notes;
public class Main{
    public static  void main(String[] args) throws IllegalThreadStateException, InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 5; i++){
                System.out.println("Hello");
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(()->{
           for(int i = 0; i < 5; i++){
               System.out.println("Hi");
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
        });
        t1.start();
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

        if(t1.isAlive()) System.out.println("Furina");
        t1.join();
//        isAlive == true only if the code is before the "join()" method

        if(!t2.isAlive()) System.out.println("Qiqi");
        t2.join();

        System.out.println("Xiang Ling");
    }
}