package UDPEx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    DatagramSocket socket = null;
    byte[] receiverBuffer = null;
    DatagramPacket receivePacket = null;

    public Server() {
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.initializeVariable();
        server.connecting();
    }

    private void initializeVariable() {
        try {
            this.socket = new DatagramSocket(5554);
            this.receiverBuffer = new byte[1024];
        } catch (SocketException var2) {
            this.log("initializeVariable : " + var2.toString());
        }

    }

    private String receiveData() {
        String line = "";

        try {
            this.receivePacket = new DatagramPacket(this.receiverBuffer, this.receiverBuffer.length);
            this.socket.receive(this.receivePacket);
            line = new String(this.receivePacket.getData(), 0, this.receivePacket.getLength());
        } catch (IOException var3) {
            this.log("receiveData : " + var3.toString());
        }

        return line;
    }

    private void connecting() {
        while(true) {
            String data = this.receiveData();
            this.log("Client : " + data);
            if (data.equals("bye")) {
                this.log("Client say bye . . . Exiting");
                return;
            }

            this.receiverBuffer = new byte[1024];
        }
    }

    private void log(String message) {
        System.out.println(message);
    }
}
