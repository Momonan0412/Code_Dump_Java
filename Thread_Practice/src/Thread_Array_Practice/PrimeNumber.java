package Thread_Array_Practice;

import static Thread_Array_Practice.Main.count;

public class PrimeNumber implements Runnable {
    public int startNum;
    public int endNum;
    public PrimeNumber(int startNum, int endNum){
        this.startNum = startNum;
        this.endNum = endNum;
    }

    @Override
    public void run() {
        count_primes_in_range();
        System.out.println(Thread.currentThread().getName() + " Handling: " + startNum + " to " + endNum);
    }
    public void count_primes_in_range() {
        for (int num = startNum; num <= endNum; ++num) {
            if (is_prime(num)) {
                count++;
            }
        }
    }
    public boolean is_prime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
