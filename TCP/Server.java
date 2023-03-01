package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(45678);
        System.out.println("Server Started");

        while (true) {

            Socket server = serverSocket.accept();

            ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(server.getInputStream());

            String message = (String) ois.readObject();
            System.out.println("Message From Client : " + message + " " + server.getLocalAddress().toString());

            oos.writeObject(message.toUpperCase());
        }
    }
}