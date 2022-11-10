package socketprogramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3333);
            Socket server = serverSocket.accept();
            DataInputStream din = new DataInputStream(server.getInputStream());
            DataOutputStream dout = new DataOutputStream(server.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String clientMessage = "", serverMessage = "";
            while (!clientMessage.equals("stop")) {
                clientMessage = din.readUTF();
                System.out.println("Client : " + clientMessage);
                System.out.println("Server : ");
                serverMessage = scanner.nextLine();
                dout.writeUTF(serverMessage);
            }
        } catch (Exception e) {
            System.out.println("Exception Occurred");
        }
    }
}
