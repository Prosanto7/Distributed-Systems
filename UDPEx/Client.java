package UDPEx;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    Scanner scan = null;
    DatagramSocket socket = null;
    byte[] buffer = null;

    public Client() {
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.initialVariable();
        client.connecting();
    }

    private void initialVariable() {
        try {
            this.scan = new Scanner(System.in);
            this.socket = new DatagramSocket();
        } catch (SocketException var2) {
            this.log("initializeVariable : " + var2.toString());
        }

    }

    private String readFromKeyboard() {
        String line = this.scan.nextLine();
        return line;
    }

    private void send(String message) {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            this.buffer = message.getBytes();
            DatagramPacket packetsend = new DatagramPacket(this.buffer, this.buffer.length, ip, 5554);
            this.socket.send(packetsend);
        } catch (UnknownHostException var4) {
            this.log("send : " + var4.toString());
        } catch (IOException var5) {
            this.log("send : " + var5.toString());
        }

    }

    private void connecting() {
        String line;
        do {
            line = this.readFromKeyboard();
            this.send(line);
        } while(!line.equals("bye"));

    }

    private void log(String message) {
        System.out.println(message);
    }
}
