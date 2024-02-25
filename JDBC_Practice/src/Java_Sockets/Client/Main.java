package Java_Sockets.Client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Socket_Client[] client = new Socket_Client[10];
        for(int i = 0; i < 10; i++){
            client[i] = new Socket_Client();
            System.out.print("Enter message: ");
            client[i].run(sc.nextLine());
        }
    }
}
