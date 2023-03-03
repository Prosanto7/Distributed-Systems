package Problem1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 3456);
        Scanner scanner = new Scanner(System.in);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        System.out.print("Enter your ID : ");
        String message = scanner.nextLine();
        oos.writeObject(message);

        String response = (String) ois.readObject();
        System.out.println("Response from server : " + response);
    }
}