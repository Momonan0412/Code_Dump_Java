package Java_Sockets.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Socket_Client {
    public void run(String message){
        Socket socket = null;
        try{
//---------------------------------------------------------------------------------------------------------------------
            /**
             * Sends message to server!
             * **/
            socket = new Socket("192.168.254.108", 8996);
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println(message);
//---------------------------------------------------------------------------------------------------------------------
            /**
             * Prints whatever the server's message to client is.
             * **/
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String msg = bufferedReader.readLine();
            System.out.println(msg);
//---------------------------------------------------------------------------------------------------------------------
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
