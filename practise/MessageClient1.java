package practise;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner keyBoard = new Scanner(System.in);

        while (true) {
            Socket client = new Socket("127.0.0.1", 8765);

            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());

            System.out.println("Response : " + ois.readObject());

            System.out.print("Enter your message : ");
            String message = keyBoard.nextLine();
            oos.writeObject(message);


        }
    }
}
