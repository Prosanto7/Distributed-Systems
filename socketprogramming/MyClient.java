package socketprogramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 3333);
            System.out.println(client.isConnected());
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dout = new DataOutputStream(client.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String clientMessage = "", serverMessage = "";
            while (!clientMessage.equals("stop")) {
                System.out.println("Client : ");
                clientMessage = scanner.nextLine();
                dout.writeUTF(clientMessage);
                serverMessage = din.readUTF();
                System.out.println("Server : " + serverMessage);
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred");
        }
    }
}
