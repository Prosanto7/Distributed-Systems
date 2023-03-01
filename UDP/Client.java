package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        byte[] buffer = new byte[1024];

        while (true) {
            String line = scanner.nextLine();
            DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(), line.length(), InetAddress.getLocalHost(), 6789);
            socket.send(datagramPacket);
        }
    }
}