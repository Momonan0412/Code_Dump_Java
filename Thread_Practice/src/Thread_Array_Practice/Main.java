package Thread_Array_Practice;

import java.util.Scanner;

public class Main {
    public static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of threads: ");
        int numThread = sc.nextInt();
        Thread[] thrdArray = new Thread[numThread];
        System.out.print("Enter a number limit: ");
        int limit = sc.nextInt();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numThread; i++) {
            int startRange = (i * limit / numThread) + 1;
            int endRange = (i == numThread - 1) ? limit : (i + 1) * limit / numThread;
            thrdArray[i] = new Thread(new PrimeNumber(startRange, endRange), "Thread" + i);
            thrdArray[i].start();
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Program run time: " + elapsedTime);
        for(Thread thrd : thrdArray){
            try{
                thrd.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("In range of 1 to " + limit + " there are " + count + " primes");
    }
}
