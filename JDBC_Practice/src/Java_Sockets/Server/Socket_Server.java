package Java_Sockets.Server;
import java.net.*;
import java.io.*;

public class Socket_Server {
    public static void main(String[] args) {
        Socket_Server server = new Socket_Server();
        server.run();
    }
    public void run(){
        ServerSocket serverSocket = null;
        try{
//---------------------------------------------------------------------------------------------------------------------
            serverSocket = new ServerSocket(8996);
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(()-> clientHandler(socket)).start();
            }
//---------------------------------------------------------------------------------------------------------------------
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void clientHandler(Socket socket){
        try(
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                PrintStream printStream = new PrintStream(socket.getOutputStream())
        ){
//---------------------------------------------------------------------------------------------------------------------
            String msg = bufferedReader.readLine();
            System.out.println(msg);
//---------------------------------------------------------------------------------------------------------------------
            if(msg != null){
                printStream.println("Message Received!");
            }
//---------------------------------------------------------------------------------------------------------------------
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//---------------------------------------------------------------------------------------------------------------------
/**
 * TO-LEARN
 * Serialization is the process of converting an object into a stream of bytes,
 * and deserialization is the process of reconstructing the object from that stream.
 * In Java, you typically use the ObjectOutputStream for serialization and the ObjectInputStream for deserialization.
 * **/