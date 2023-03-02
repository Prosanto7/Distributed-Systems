package practise;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8765);

        if (!serverSocket.isClosed()) {
            System.out.println("Server Opened");
        }

        String message = "";

        while (true) {
            Socket server = serverSocket.accept();

            ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(server.getInputStream());

            String heading = "Message from ";

            if (server.getLocalAddress().getHostAddress().equals("127.0.0.1")) {
                heading += "Client 2 : ";
            } else if (server.getLocalAddress().getHostAddress().equals("127.0.0.2")) {
                heading += "Client 1 : ";
            }

            oos.writeObject(heading + message);


            message = (String) ois.readObject();
        }
    }
}
