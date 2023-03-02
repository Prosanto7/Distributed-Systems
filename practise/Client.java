package practise;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        Scanner keyBoard = new Scanner(System.in);
        byte[] buffer = new byte[1024];
        while (true) {
            System.out.print("Enter Your Message : ");
            String message = keyBoard.nextLine();
            buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 45678);
            client.send(packet);

            if (message.equals("Exit")) {
                return;
            }
        }
    }
}
