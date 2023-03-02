package practise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(45678);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        while (true) {
            server.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            if (message.equals("Exit")) {
                return;
            }
            System.out.println("Message From Client " + message);
        }
    }
}
