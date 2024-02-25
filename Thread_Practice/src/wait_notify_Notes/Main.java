package wait_notify_Notes;

public class Main {
    public static void main(String[] args){
        A a = new A();
        new ThreadOne(a);
        new ThreadTwo(a);
    }
}
